import java.util.Hashtable;
import java.util.Scanner;

// -----------------------------------------------------------
    // PROBLEM 1:
    // -----------------------------------------------------------
    // [PART I]
    public class UniqueWordsEtc {
    
        public static void main (String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter a sentence.");
          
            String[] words = input.nextLine().split(" ");
          
            // TODO: Your improved solution here!

            Hashtable<String, String> hashedWords = new Hashtable<String, String>();
            for(int i = 0; i < words.length; i++){
                if(!hashedWords.containsValue(words[i])){
                    hashedWords.put(words[i], words[i]);
                } else {
                    hashedWords.remove(words[i]);
                }
            }

            int count = hashedWords.size();

          
            System.out.println("There are " + count + " unique words in that sentence.");
        }


      
}
  
// [PART II]
// Asymptotic Runtime Complexity of OLD UniqueWords.java (the solution):  O(n^2)
// Asymptotic Runtime Complexity of NEW UniqueWords.java (the above):     O(n)
  
// -----------------------------------------------------------
// PROBLEM 2:
// -----------------------------------------------------------
// T_1(n) = \Theta(n^[log_3(2)])
// T_2(n) = \Theta(n^[log_2(4) * log(n)])






