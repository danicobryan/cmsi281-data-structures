package autocompleter;

import java.util.ArrayList;

public class Autocompleter implements AutocompleterInterface {

    // -----------------------------------------------------------
    // Fields
    // -----------------------------------------------------------
    TTNode root;
    
    
    // -----------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------
    Autocompleter () {
        root = null;
    }
    
    
    // -----------------------------------------------------------
    // Methods
    // -----------------------------------------------------------
    
    public boolean isEmpty () {
        return root == null;
    }
    
    public void addTerm (String toAdd) {
        root = insert(root, normalizeTerm(toAdd), 0);
        //preorderPrint(root);
       

    }
    
    public boolean hasTerm (String query) {
        return find(root, normalizeTerm(query), 0);
    }
    
    public String getSuggestedTerm (String query) {
        return suggest(root, normalizeTerm(query), 0, "");
    }
    
    public ArrayList<String> getSortedTerms () {
        ArrayList<String> alphabetizedWords = new ArrayList<String>();
        alphabetizedWords = sortTerms(root, "", alphabetizedWords);
        return alphabetizedWords;
    }
    
    
    // -----------------------------------------------------------
    // Helper Methods
    // -----------------------------------------------------------
    
    private String normalizeTerm (String s) {
        // Edge case handling: empty Strings illegal
        if (s == null || s.equals("")) {
            throw new IllegalArgumentException();
        }
        return s.trim().toLowerCase();
    }
    
    /*
     * Returns:
     *   int less than 0 if c1 is alphabetically less than c2
     *   0 if c1 is equal to c2
     *   int greater than 0 if c1 is alphabetically greater than c2
     */
    private int compareChars (char c1, char c2) {
        return Character.toLowerCase(c1) - Character.toLowerCase(c2);
    }
    
    // [!] Add your own helper methods here!

    private TTNode insert(TTNode n, String word, int charIndex){

    	if(n == null){
    		n = new TTNode(word.charAt(charIndex), false);
    	}

    	if(compareChars(word.charAt(charIndex), n.letter) < 0){
    		n.left = insert(n.left, word, charIndex);
    	} else if(compareChars(word.charAt(charIndex), n.letter) > 0){
    		n.right = insert(n.right, word, charIndex);
    	} else {
    		if(charIndex + 1 < word.length()){
    			n.mid = insert(n.mid, word, charIndex + 1);
    		} else {
    			n.wordEnd = true;
    		}
    	}
    	return n;
    }

    private boolean find(TTNode n, String word, int charIndex){
    	if(n == null){
    		return false;
    	}
    	if(compareChars(word.charAt(charIndex), n.letter) < 0){
    		return find(n.left, word, charIndex);
    	} else if(compareChars(word.charAt(charIndex), n.letter) > 0){
    		return find(n.right, word, charIndex);
    	} else {
    		if(charIndex == word.length() - 1 && n.wordEnd){
    			return true;
    		} else if(charIndex == word.length() - 1 && !n.wordEnd){
    			return false;
    		} else {
    			return find(n.mid, word, charIndex + 1);
    		}
    	}
    }

    private String suggest(TTNode n, String query, int charIndex, String result){
    	if(n == null){
    		return null;
    	}
    	if(query.charAt(charIndex) == n.letter){
			result += query.charAt(charIndex);
		} 
		if(compareChars(query.charAt(charIndex), n.letter) < 0){
    		result = suggest(n.left, query, charIndex, result);
    	} else if(compareChars(query.charAt(charIndex), n.letter) > 0){
    		result = suggest(n.right, query, charIndex, result);
    	} else {
   
    		if(charIndex < query.length() - 1){
    			result = suggest(n.mid, query, charIndex + 1, result);
    		} else {
    			result = addDownMiddle(n, result);
    		}

    	}
    	
    	
    	return result;
    }

    private String addDownMiddle(TTNode n, String result){
    	if(n == null){
    		return null;
    	}
    	if(!n.wordEnd && n != null){
    		result += n.mid.letter;
    		result = addDownMiddle(n.mid, result);
    	}
    	return result;
    }

    private ArrayList<String> sortTerms(TTNode n, String word, ArrayList<String> sortedWords){
    	if(n != null){
    		sortedWords = sortTerms(n.left, word, sortedWords);
    		word += n.letter;
    		if(n.wordEnd){
    			sortedWords.add(word);
    		}
    		sortedWords = sortTerms(n.mid, word, sortedWords);
    		word = word.substring(0, word.length() - 1);
    		sortedWords = sortTerms(n.right, word, sortedWords);

    	}
    	return sortedWords;
    }


    private void preorderPrint(TTNode n){
    	if(n == null){ 
    		return; 
    	}

    	System.out.println(n.letter);
    	preorderPrint(n.left);
    	preorderPrint(n.mid);
    	preorderPrint(n.right);

    }

    
    
    // -----------------------------------------------------------
    // TTNode Internal Storage
    // -----------------------------------------------------------
    
    /*
     * Internal storage of autocompleter search terms
     * as represented using a Ternary Tree with TTNodes
     */
    private class TTNode {
        
        boolean wordEnd;
        char letter;
        TTNode left, mid, right;
        
        TTNode (char c, boolean w) {
            letter  = c;
            wordEnd = w;
            left    = null;
            mid     = null;
            right   = null;
        }
        
    }
    
}
