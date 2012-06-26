package me.kukkii.diablo3items;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ItemListGetter{

  public List<String> getUrls() throws Exception{

    List<String> urls = new ArrayList<String>();
    FileReader fr = new FileReader("/Users/cookieahaha/git/diablo3items/data/itemdata.txt");
    BufferedReader br = new BufferedReader(fr);

    String input = null;
    while ((input = br.readLine()) != null){
    	urls.add(input);
    }      
    return urls;
  }

  public static void main(String[] args) throws Exception{
    ItemListGetter getter = new ItemListGetter();
    for(String url : getter.getUrls()){
      System.out.println(url);
    } 
 }

}
