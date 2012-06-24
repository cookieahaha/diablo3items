// $Id$

package me.kukkii.diablo3items;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class ItemParser {
  private static final String FILENAME = "data/Helms - Game Guide - Diablo III.xhtml.html";

  public ItemParser() {
  }

  public List<Item> parse(String text) {
    List<Item> items = new ArrayList<Item>();
    //
    return items;
  }

  public static void main(String[] args) throws Exception {
    String text = FileUtils.readFileToString(new File(FILENAME), "UTF-8");
    for (Item item : new ItemParser().parse(text)) {
      System.out.println(item);
    }
    System.out.flush();
  }
}
