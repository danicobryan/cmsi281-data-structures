  class Entry {
      // [!] Intentionally not private fields, since
      // the Entry class will be used internally
      String text;
      int count;
      
      Entry (String s, int c) {
          text = s;
          count = c;
      }
  }