// package extra;
//import javax.swing.filechooser.*; 
 import java.io.*;
 import java.util.*;

 public class NameFilter extends javax.swing.filechooser.FileFilter {
   private String[] suf;            // fält med suffix
   private String description = ""; 
 
   public NameFilter(String suffix) {
     StringTokenizer tok = new StringTokenizer(suffix);
     suf = new String[tok.countTokens()];
     for (int i=0; i<suf.length; i++) {
       suf[i] = tok.nextToken();    // nästa suffix
       description += "*" + suf[i] + " ";
     }
   }

   public boolean accept(File f) {    // skall filen f vara med?
     if (f.isDirectory()) {
       return true;
     }
     for (int i=0; i<suf.length; i++) {
       if (f.getName().endsWith(suf[i]))
         return true;
     }
     return false;
   }

   public String getDescription() {  // beskrivning av vilka
     return description;             // filer som väljs ut
   }
 }
