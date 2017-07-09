//package yarn;

public class Yarn implements YarnInterface {

    // -----------------------------------------------------------
    // Fields
    // -----------------------------------------------------------
    private Entry[] items;
    private int size;
    private int uniqueSize;
    private final int MAX_SIZE = 100;
    
    
    // -----------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------
    Yarn () {
        items = new Entry[MAX_SIZE];
        size = 0;
        uniqueSize = 0;
    }
    
    
    // -----------------------------------------------------------
    // Methods
    // -----------------------------------------------------------
    public boolean isEmpty () {
        if(size == 0){
            return true;
        } else {
            return false;
        }
    }
    
    public int getSize () {
        return size;
    }
    
    public int getUniqueSize () {
        int nullCount = 0;
        for(int i = 0; i <= items.length - 1; i++){
            if(items[i] == null){
                nullCount++;
            }
        }
        return items.length - nullCount;
    }
    
    public boolean insert (String toAdd) {
        if(size < MAX_SIZE){
            boolean repeated = false;
            for(int i = 0; i <= items.length - 1; i++){  
                if(items[i] != null && items[i].text.equals(toAdd)){
                    items[i].count++;
                    repeated = true;
                    break;
                }
            }
            if(repeated == false){
                items[getUniqueSize()] = new Entry(toAdd, 1);
            }
            size++;
            uniqueSize = getUniqueSize();
            return true;
        }else{

            return false;
        }
    }
    
    public int remove (String toRemove) {
        int result = 0;
        if (size > 0){
            for(int i = 0; i <= items.length - 1; i++){
                if(items[i] != null && items[i].text.equals(toRemove) && items[i].count >= 1){
                    items[i].count -= 1;
                    result = items[i].count;
                    size--;
                    rearrange();
                } 
            }
        } 
        uniqueSize = getUniqueSize();
        return result;
    }
    
    public void removeAll (String toNuke) {
        for(int i = 0; i <= getUniqueSize() - 1; i++){
            if(items[i].text.equals(toNuke)){
                size -= items[i].count;
                items[i].count = 0;
                rearrange();
            }
        }
        uniqueSize = getUniqueSize();
    }
    
    public int count (String toCount) {
        int result = 0;
        for(int i = 0; i <= getUniqueSize() - 1; i++){
            if(items[i].text.equals(toCount)){
                result = items[i].count;
            }
        }
        return result;
    }
    
    public boolean contains (String toCheck) {
        boolean result = false;
        for(int i = 0; i <= getUniqueSize() - 1; i++){
            if(items[i].text.equals(toCheck)){
                result = true;
            }
        }
        return result;
    }
    
    public String getNth (int n) {
        int index = 0;

        while(n > items[index].count && n < size){
            n -= items[index].count;
            index++;
        }

        return items[index].text;

    }
    
    public String getMostCommon () {
        String result = items[0].text;
        for(int i = 1; i <= items.length - 1; i++){
            if(items[i] == null){
                break;
            }
            if(items[i].count > items[i-1].count){
                result = items[i].text;
            }
        }
        return result;
    }
    
    public Yarn clone () {
        Yarn clone = new Yarn();
        for(int i = 0; i <= this.getUniqueSize() - 1; i++){
            clone.items[i] = new Entry(items[i].text, items[i].count);
        }
        //clone.size = this.size;
        clone.uniqueSize = clone.getUniqueSize();
        return clone;

    }
    
    public void swap (Yarn other) {
        Entry[] storedItems = other.items;
        other.items = items;
        items = storedItems;

        int storedSize = other.size;
        other.size = size;
        size = storedSize;

        int storedUniqueSize = other.getUniqueSize();
        other.uniqueSize = this.getUniqueSize();
        this.uniqueSize = storedUniqueSize;
    }
    
    
    // -----------------------------------------------------------
    // Static methods
    // -----------------------------------------------------------
    
    public static Yarn knit (Yarn y1, Yarn y2) {
        Yarn y3 = y1.clone();
        for(int i = 0; i <= y2.getUniqueSize() - 1; i++){
            for(int j = 0; j < y2.items[i].count; j++){
                y3.insert(y2.items[i].text);
            }
        }
        return y3;

    }
    
    public static Yarn tear (Yarn y1, Yarn y2) {
        Yarn y3 = new Yarn();
        int y3Index = 0;
        for(int i = 0; i <= y1.getUniqueSize() - 1; i++){
            if(!(y2.contains(y1.items[i].text))){
                y3.items[y3Index] = new Entry(y1.items[i].text, y1.items[i].count);
                y3Index++;
                y3.size++;
            } else if(y2.count(y1.items[i].text) < y1.count(y1.items[i].text)){
                y3.items[y3Index] = new Entry(y1.items[i].text, y1.items[i].count - y2.count(y1.items[i].text));
                y3Index++;
                y3.size++;
            }
        }
        return y3;

    }
    
    public static boolean sameYarn (Yarn y1, Yarn y2) {
        boolean result = false;
        if(y1.getUniqueSize() != y2.getUniqueSize()){
            result = false;
        } else {
            for(int i = 0; i <= y1.getUniqueSize() - 1; i++){
                if(y2.contains(y2.items[i].text) && (y2.count(y1.items[i].text) == y1.count(y1.items[i].text))) {
                    result = true;
                }
            }
        }
        return result;
    }
    
    
    // -----------------------------------------------------------
    // Private helper methods
    // -----------------------------------------------------------
    // Add your own here!
    

    // If count of Unique String is 0, switches the last Unique String to that place 
    private void rearrange(){
        for(int i = 0; i <= getUniqueSize() - 1; i++){
            if(items[i].count == 0 && items[i] != null){
                items[i] = items[findLastString()];
                items[findLastString()] = null;
            } 

        }
    }

    private int findLastString(){
        int index = 0;
        for(int i = 0; i <= items.length - 1; i++){
            if(items[i] != null && items[i + 1] == null){
                index = i;
            }
        }
        return index;
    }
}

class Entry {
    String text;
    int count;
    
    Entry (String s, int c) {
        text = s;
        count = c;
    }
}