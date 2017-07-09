//package autocompleter;

//import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

/*import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;*/

public class AutocompleterTests {

    public static void main(String[] args){
        Autocompleter ac = new Autocompleter();
        /*ac.addTerm("item");
        ac.addTerm("items");
        ac.addTerm("bat");
        System.out.println(ac.hasTerm("items"));
        System.out.println(ac.hasTerm("item"));
        System.out.println(ac.hasTerm("bat"));
        System.out.println(ac.getSuggestedTerm("ba"));*/



        
        ac.addTerm("is");
        ac.addTerm("  it   ");
        ac.addTerm("as");
        ac.addTerm("at");
        ac.addTerm("item");
        ac.addTerm("ass");
        ac.addTerm("bat");
        ac.addTerm("bother");
        ac.addTerm("goat");
        ac.addTerm("goad");
        System.out.println(ac.hasTerm("   item   "));
        System.out.println(ac.hasTerm("i"));
        System.out.println(ac.getSuggestedTerm("  is  "));
        System.out.println(ac.getSuggestedTerm("it"));
        System.out.println(ac.getSuggestedTerm("ite "));
        System.out.println(ac.getSuggestedTerm("as"));
        System.out.println(ac.getSuggestedTerm("ba"));
        System.out.println(ac.getSuggestedTerm("bo"));
        System.out.println(ac.getSuggestedTerm("bad"));
        System.out.println(ac.getSuggestedTerm("zoo"));
        String result = ac.getSuggestedTerm("go");
        System.out.println(result);


        /*
        ac.addTerm("is");
        ac.addTerm("it");
        ac.addTerm("as");
        ac.addTerm("itenerary");
        ac.addTerm("ass");
        ac.addTerm("at");
        ac.addTerm("zoo");
        ac.addTerm("bat");
        ac.addTerm("bother");
        //System.out.println(ac.getSortedTerms);
        ArrayList<String> solution = ac.getSortedTerms();
        for(int i = 0; i < solution.size(); i++){
            System.out.println(solution.get(i));
        }*/
    }

    /*
    
    // =================================================
    // Test Configuration
    // =================================================
    
    // Global timeout to prevent infinite loops from
    // crashing the test suite
    @Rule
    public Timeout globalTimeout = Timeout.seconds(2);
    
    // Used as the basic empty Autocompleter to test; 
    // the @Before method is run before every @Test
    Autocompleter ac;
    @Before
    public void init () {
        ac = new Autocompleter();
    }
    
    
    // =================================================
    // Unit Tests
    // =================================================
    
    // Initialization Tests
    // -------------------------------------------------
    @Test
    public void testAutocompleter() {
        assertTrue(ac.isEmpty());
    }

    // Basic Tests
    // -------------------------------------------------
    @Test
    public void testAddTerm() {
        ac.addTerm("is");
        ac.addTerm("it");
        ac.addTerm("as");
        ac.addTerm("ass");
        ac.addTerm("at");
        ac.addTerm("bat");
    }

    @Test
    public void testHasTerm() {
        ac.addTerm("is");
        ac.addTerm("it");
        ac.addTerm("as");
        ac.addTerm("ass");
        ac.addTerm("at");
        ac.addTerm("bat");
        assertTrue(ac.hasTerm("is"));
        assertTrue(ac.hasTerm("it"));
        assertTrue(ac.hasTerm("as"));
        assertTrue(ac.hasTerm("ass"));
        assertTrue(ac.hasTerm("at"));
        assertTrue(ac.hasTerm("bat"));
        assertFalse(ac.hasTerm("ii"));
        assertFalse(ac.hasTerm("i"));
        assertFalse(ac.hasTerm("zoo"));
    }

    @Test
    public void getSuggestedTerm() {
        ac.addTerm("is");
        ac.addTerm("it");
        ac.addTerm("as");
        ac.addTerm("at");
        ac.addTerm("item");
        ac.addTerm("ass");
        ac.addTerm("bat");
        ac.addTerm("bother");
        ac.addTerm("goat");
        ac.addTerm("goad");
        assertEquals("is", ac.getSuggestedTerm("is"));
        assertEquals("it", ac.getSuggestedTerm("it"));
        assertEquals("item", ac.getSuggestedTerm("ite"));
        assertEquals("as", ac.getSuggestedTerm("as"));
        assertEquals("bat", ac.getSuggestedTerm("ba"));
        assertEquals("bother", ac.getSuggestedTerm("bo"));
        assertEquals(null, ac.getSuggestedTerm("bad"));
        assertEquals(null, ac.getSuggestedTerm("zoo"));
        String result = ac.getSuggestedTerm("go");
        assertTrue(result.equals("goat") || result.equals("goad"));
    }
    
    @Test
    public void getSortedTerms() {
        ac.addTerm("is");
        ac.addTerm("it");
        ac.addTerm("as");
        ac.addTerm("itenerary");
        ac.addTerm("ass");
        ac.addTerm("at");
        ac.addTerm("zoo");
        ac.addTerm("bat");
        ac.addTerm("bother");
        ArrayList<String> solution = new ArrayList<String>(Arrays.asList(
            "as", "ass", "at", "bat", "bother", "is", "it", "itenerary", "zoo"
        ));
        assertEquals(solution, ac.getSortedTerms());
    }

    */
    
}
