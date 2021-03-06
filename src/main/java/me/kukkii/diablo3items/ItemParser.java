// $Id$

package me.kukkii.diablo3items;

import java.io.File;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class ItemParser {
  private static final String FILENAME = "data/Helms - Game Guide - Diablo III.xhtml.html";

  public ItemParser() {
  }

  public List<Item> parse(String text) {
    List<Item> items = new ArrayList<Item>();
    int n = 0;
    while (true) {
      int m = text.indexOf("<td valign=\"top\" class=\"column-item\">", n) ;
      if (m < 0) {
        break;
      }
      m = text.indexOf("class=\"d3-color-", m);
      if (m < 0) {
        break;
      }
      m = text.indexOf(">", m) + 1;
      if (m < 0) {
        break;
      }
      n = text.indexOf("<", m);
      if (n < 0) {
        break;
      }
      String name = text.substring(m,n).trim();
      // System.err.println("m=" + m + " n=" + n + " name=" + name);

      m = text.indexOf("span class=\"d3-color-",m);
      m = text.indexOf(">",m) + 1;
      n = text.indexOf("<",m);
      String type = text.substring(m,n).trim();
      // System.err.println("m=" + m + " n=" + n + " type=" + type);

      m = text.indexOf("class=\"value\">",m);
      m = text.indexOf(">",m) + 1;
      n = text.indexOf("<",m);
      String stat = text.substring(m,n).trim();
      // System.err.println("m=" + m + " n=" + n + " stat=" + stat);

      m = text.indexOf("class=\"value\">",m);
      m = text.indexOf(">",m) + 1;
      n = text.indexOf("<",m);
      String level = text.substring(m,n).trim();
      // System.err.println("m=" + m + " n=" + n + " level=" + level);

      items.add( new Item(name, type, stat, level) );
    }
    return items;
  }

  public static void main(String[] args) throws Exception {
    String text = FileUtils.readFileToString(new File(FILENAME), "UTF-8");
    PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, "UTF-8"));
    for (Item item : new ItemParser().parse(text)) {
      out.println(item);
    }
    out.flush();
  }
}
