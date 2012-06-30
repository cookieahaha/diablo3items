package me.kukkii.diablo3items;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.FileUtils;
import java.net.URL;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;

public class ItemListGetter{

  private static final String FILENAME = "data/itemdata.txt";

  public List<String> getUrls() throws Exception{

    List<String> urls = new ArrayList<String>();
    FileReader fr = new FileReader(FILENAME);
    BufferedReader br = new BufferedReader(fr);

    String input = null;
    while ((input = br.readLine()) != null){
        if(input.charAt(0) == '#'){
          continue;
        }
    	urls.add(input);
    }      
    return urls;
  }

  public static void main(String[] args) throws Exception{
    ItemListGetter getter = new ItemListGetter();
    ItemParser ip = new ItemParser();
    PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, "UTF-8"));
    int i = 1;
    for(String url : getter.getUrls()){
      out.println("URL=" + url);
      String content = getter.getContent(url);
      getter.save(content, "data/" + (i++) + ".html");
      for (Item item : ip.parse(content)) {
        out.println(item);
      }
      out.println();
      out.flush();
    }
    out.flush();
  }

  public String getContent(String url) throws Exception{
      String input = IOUtils.toString(new URL(url), "UTF-8");
      return input;
  }

  public void save(String content, String filename) throws Exception {
    FileUtils.writeStringToFile(new File(filename), content, "UTF-8");
  }
}
