package sentinal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Sentinal implements SentinalInterface {

    // -----------------------------------------------------------
    // Fields
    // -----------------------------------------------------------
    
    private PhraseHash posHash, negHash;

    
    // -----------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------
    
    Sentinal (String posFile, String negFile) throws FileNotFoundException {
        posHash = new PhraseHash();
        negHash = new PhraseHash();
        loadSentimentFile(posFile, true);
        loadSentimentFile(negFile, false);
    }
    
    
    // -----------------------------------------------------------
    // Methods
    // -----------------------------------------------------------
    
    public void loadSentiment (String phrase, boolean positive) {
        if(positive){
            posHash.put(phrase);
        } else {
            negHash.put(phrase);
        }
    }
    
    public void loadSentimentFile (String filename, boolean positive) throws FileNotFoundException {
        try{
            File file = new File(filename);
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                loadSentiment(line, positive);
                //System.out.println(line);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
           System.out.println(e);
        }
    }
    
    public String sentinalyze (String filename) throws FileNotFoundException {
        //throw new UnsupportedOperationException();
        int count = 0;
        try{
            File file = new File(filename);
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                count += sentenceCount(line);
                //System.out.println(line);
            }
            sc.close();
            //System.out.println("Count is " + count);
        }
        catch (FileNotFoundException e) {
           System.out.println(e);

        }

        if(count > 0){
            return "positive";
        } else if(count < 0){
            return "negative";
        } else {
            return "neutral";
        }


    }
    
    
    // -----------------------------------------------------------
    // Helper Methods
    // -----------------------------------------------------------
    
    // TODO: Add your helper methods here!
    
    private int phraseLength(String phrase){
        String words[] = phrase.split(" ");
        return words.length;
    }

    private int sentenceCount(String sentence){
        int count = 0;
        //String words[] = sentence.split(" ");
        String[] words = null;
        for(int phraseLength = 1; phraseLength <= longestPhraseHashLength(); phraseLength++){
            words = arrayOfPhrases(sentence, phraseLength);
            //System.out.println(Arrays.toString(words));
            for(int i = 0; i < words.length; i ++){
                if(negHash.get(words[i]) != null){
                    count--;
                } else if (posHash.get(words[i]) != null){
                    count++;
                }
            }
        }
        return count;
    }

    private String splitSentence(String sentence, int length, int index){
        int startIndex = index;
        String words[] = sentence.split(" ");
        String phrase = "";
        if(startIndex < words.length - length + 1){
            phrase = words[index];
            for(int i = 1; i < length; i++){
                phrase += " " + words[index + 1];
                index++;
            }
        }
        return phrase;
    }

    private String[] arrayOfPhrases(String sentence, int length){
        int arrayLength = phraseLength(sentence) - length + 1;
        String[] phrases = new String[arrayLength];
        for(int i = 0; i < phrases.length; i++){
            phrases[i] = splitSentence(sentence, length, i);
        }
        return phrases;
    }

    private int longestPhraseHashLength(){
        return Math.max(posHash.longestLength(), negHash.longestLength());
    }


}

