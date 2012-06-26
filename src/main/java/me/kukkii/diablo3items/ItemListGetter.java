package me.kukkii.diablo3items;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;
import java.net.URL;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;

public class ItemListGetter{

  public List<String> getUrls() throws Exception{

    List<String> urls = new ArrayList<String>();
    FileReader fr = new FileReader("/Users/cookieahaha/git/diablo3items/data/itemdata.txt");
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
    for(String url : getter.getUrls()){
      for (Item item : ip.parse(getter.getContent(url))){
        out.println(item);
      }
    }
    out.flush();
  }

  public String getContent(String url) throws Exception{
      String input = IOUtils.toString(new URL(url));
      return input;
  }

}
