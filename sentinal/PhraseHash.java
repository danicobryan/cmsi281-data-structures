package sentinal;

import java.util.LinkedList;

public class PhraseHash implements PhraseHashInterface {

    // -----------------------------------------------------------
    // Fields
    // -----------------------------------------------------------
    
    private final static int BUCKET_COUNT = 1000;
    private int size, longest;
    private LinkedList<String>[] buckets;
    
    
    // -----------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------
    
    @SuppressWarnings("unchecked") // Don't worry about this >_>
    PhraseHash () {
        size = 0;
        longest = 0;
        buckets = new LinkedList[BUCKET_COUNT];
    }
    
    
    // -----------------------------------------------------------
    // Public Methods
    // -----------------------------------------------------------
    
    public int size () {
        return size;
    }
    
    public boolean isEmpty () {
        return size == 0;
    }
    
    public void put (String s) {
        int value = hash(s);
        if(buckets[value] != null && buckets[value].contains(s)){
            return;
        }
        if(buckets[value] == null){
             buckets[value] = new LinkedList<String>();
        }
        buckets[value].add(s);
        //System.out.println(hash(s));
        checkLongestPhrase(s);
        size++;

    }
    
    public String get (String s) {
        int value = hash(s);
        if(buckets[value] != null && buckets[value].contains(s)){
            //return buckets[value].get(buckets[value].indexOf(s));
            return s;
        } else {
            return null;
        }
    }
    
    public int longestLength () {
        return longest;
    }
    
    
    // -----------------------------------------------------------
    // Helper Methods
    // -----------------------------------------------------------
    
    private int hash (String s) {
        int hashIndex = 0;
        for(int i = 0; i < s.length(); i++){
            hashIndex += Character.getNumericValue(s.charAt(i));
        }
        return hashIndex % BUCKET_COUNT;
    }

    private void checkLongestPhrase(String s){
        String words[] = s.split(" ");
        if(words.length > longest){
            longest = words.length;
        }
    }

    
}
