//package yarn;

//import static org.junit.Assert.*;

//import org.junit.Test;

public class YarnTests {

    public static void main(String [] args){
        testYarn();
        testIsEmpty();
        testGetSize();
        testGetUniqueSize();
        testInsert();
        testRemove();
        testRemoveAll();
        testCount();
        testContains();
        testGetNth();
        testGetMostCommon();
        testClone();
        testSwap();
        testKnit();
        testTear();
        testSameYarn();


    }

    public static void testYarn() {
        Yarn ball = new Yarn();
    }

    public static void testIsEmpty() {
        int result = 3;
        Yarn ball = new Yarn();
        if(ball.isEmpty() == false){
            System.out.println("testIsEmpty failed");
            result--;
        }
        ball.insert("not_empty");
        if(ball.isEmpty() == true){
            System.out.println("testIsEmpty failed");
            result--;
        }
        ball.insert("more_stuff");
        if(ball.isEmpty() == true){
            System.out.println("testIsEmpty failed");
            result--;
        }
        System.out.println(result + "/3 testIsEmpty tests passed");
    }

    public static void testGetSize() {
        int result = 3;
        Yarn ball = new Yarn();
        ball.insert("dup");
        ball.insert("dup");
        if(!(ball.getSize() == 2)){
            System.out.println("testGetSize 1 failed");
            result--;
        }
        ball.insert("unique");
        if(!(ball.getSize() == 3)){
            System.out.println("testGetSize 2 failed");
            result--;
        }
        ball.insert("another");
        if(!(ball.getSize() == 4)){
            System.out.println("testGetSize 3 failed");
            result--;
        }
        System.out.println(result + "/3 testGetSize tests passed");

        
    }

    public static void testGetUniqueSize() {
        int result = 3;
        Yarn ball = new Yarn();
        ball.insert("dup");
        ball.insert("dup");
        if(!(ball.getUniqueSize() == 1)){
            System.out.println("testGetUniqueSize 1 failed");
            result--;
        }
        ball.insert("unique");
        if(!(ball.getUniqueSize() == 2)){
            System.out.println("testGetUniqueSize 2 failed");
            result--;
        }
        ball.insert("another");
        if(!(ball.getUniqueSize() == 3)){
            System.out.println("testGetUniqueSize 3 failed");
            result--;
        }
        System.out.println(result + "/3 testGetUniqueSize tests passed");
    }

    public static void testInsert() {
        int result = 3;
        Yarn ball = new Yarn();
        ball.insert("dup");
        ball.insert("dup");
        ball.insert("unique");
        ball.insert("another");
        if(!(ball.contains("dup"))){
            System.out.println("testInsert 1 failed");
            result--;
        }
        if(!(ball.contains("unique"))){
            System.out.println("testInsert 2 failed");
            result--;
        }
        if(!(ball.contains("another"))){
            System.out.println("testInsert 3 failed");
            result--;
        }
    }

    public static void testRemove() {
        int result = 6;
        Yarn ball = new Yarn();
        ball.insert("dup");
        ball.insert("dup");
        if(ball.getSize() != 2){
            System.out.println("testRemove 1 failed");
            result--;
        }
        if(ball.getUniqueSize() != 1){
            System.out.println("testRemove 2 failed");
            result--;
        }
        ball.remove("dup");
        if(ball.getSize() != 1){
            System.out.println("testRemove 3 failed");
            result--;
        }
        if(ball.getUniqueSize() != 1){
            System.out.println("testRemove 4 failed");
            result--;
        }
        ball.remove("dup");
        if(ball.getUniqueSize() != 0){
            System.out.println("testRemove 5 failed");
            result--;
        }
        if(ball.getSize() != 0){
            System.out.println("testRemove 6 failed");
            result--;
        }
        System.out.println(result + "/6 testRemove tests passed");

    }

    public static void testRemoveAll() {
        int result = 6;
        Yarn ball = new Yarn();
        ball.insert("dup");
        ball.insert("dup");
        ball.insert("unique");
        if(ball.getSize() != 3){
            System.out.println("testRemoveAll 1 failed");
        }
        if(ball.getUniqueSize() != 2){
            System.out.println("testRemoveAll 2 failed");
        }
        ball.removeAll("dup");
        if(ball.getSize() != 1){
            System.out.println("testRemoveAll 3 failed");
        }
        if(ball.getUniqueSize() != 1){
            System.out.println("testRemoveAll 4 failed");
        }
        ball.removeAll("unique");
        if(ball.getSize() != 0){
            System.out.println("testRemoveAll 5 failed");
        }
        if(ball.getUniqueSize() != 0){
            System.out.println("testRemoveAll 6 failed");
        }
        System.out.println(result + "/6 testRemoveAll tests passed");
    }

    public static void testCount() {
        int result = 4;
        Yarn ball = new Yarn();
        ball.insert("dup");
        ball.insert("dup");
        ball.insert("unique");
        if(ball.count("dup") != 2){
            System.out.println("testCount 1 failed");
            result--;
        }
        if(ball.count("unique") != 1){
            System.out.println("testCount 2 failed");
            result--;
        }
        if(ball.count("forneymon") != 0){
            System.out.println("testCount 3 failed");
            result--;
        }
        ball.remove("dup");
        if(ball.count("dup") != 1){
            System.out.println("testCount 4 failed");
            result--;
        }
        System.out.println(result + "/4 testCount tests passed");
    }

    public static void testContains() {
        int result = 4;
        Yarn ball = new Yarn();
        ball.insert("dup");
        ball.insert("dup");
        ball.insert("unique");
        if(!ball.contains("dup")){
            System.out.println("testContains 1 failed");
            result--;
        }
        if(!ball.contains("unique")){
            System.out.println("testContains 2 failed");
            result--;

        }
        if(ball.contains("forneymon")){
            System.out.println("testContains 3 failed");
            result--;
        }
        ball.remove("unique");
        if(ball.contains("unique")){
            System.out.println("testContains 4 failed");
            result--;
        }
        System.out.println(result + "/4 testContains tests passed");

    }


    public static void testGetNth() {
        int result = 9;
        Yarn ball = new Yarn();
        ball.insert("dup");
        ball.insert("dup");
        ball.insert("unique");
        ball.insert("cool");
        Yarn comparison = ball.clone();
        for (int i = 0; i < ball.getSize(); i++) {
            String gotten = ball.getNth(i);
            if(!(comparison.contains(gotten))){
                System.out.println("testGetNth failed");
                result--;
            }
            comparison.remove(gotten);
        }
        ball.insert("another");
        Yarn comparison2 = ball.clone();
        for (int i = 0; i < ball.getSize(); i++) {
            String gotten2 = ball.getNth(i);
            if(!(comparison2.contains(gotten2))){
                System.out.println("testGetNth failed");
                result--;
            }
            comparison2.remove(gotten2);
        }
        System.out.println(result + "/9 testGetNth tests passed");    
    }

    public static void testGetMostCommon() {
        int result = 3;
        Yarn ball = new Yarn();
        ball.insert("dup");
        ball.insert("dup");
        ball.insert("unique");
        ball.insert("cool");
        if(!ball.getMostCommon().equals("dup")){
            System.out.println("testGetMostCommon 1 failed");
            result--;
        }
        ball.insert("cool");
        String mc = ball.getMostCommon();
        if(!(mc.equals("dup") || mc.equals("cool"))){
            System.out.println("testGetMostCommon 2 failed");
            result--;
        }
        ball.remove("unique");
        if(ball.getMostCommon().equals("unique")){
            System.out.println("testGetMostCommon 3 failed");
            result--;
        }
        System.out.println(result + "/3 testGetMostCommon tests passed");
    }

    public static void testClone() {
        int result = 5;
        Yarn ball = new Yarn();
        ball.insert("dup");
        ball.insert("dup");
        ball.insert("unique");
        Yarn dolly = ball.clone();
        if(!(dolly.count("dup") == 2)){
            System.out.println("testClone 1 passed");
            result--;
        }
        if(!(dolly.count("unique") == 1)){
            System.out.println("testClone 2 passed");
            result--;
        }
        dolly.insert("cool");
        if(!(ball.contains("cool") == false)){
            System.out.println("testClone 3 passed");
            result--;
        }
        if(!(ball.getUniqueSize() == 2)){
            System.out.println("testClone 4 passed");
            result--;
        }
        if(!(dolly.getUniqueSize() == 3)){
            System.out.println("testClone 4 passed");
            result--;
        }
        System.out.println(result + "/5 testClone tests passed");

    }

    public static void testSwap() {
        int result = 7;
        Yarn y1 = new Yarn();
        y1.insert("dup");
        y1.insert("dup");
        y1.insert("unique");
        Yarn y2 = new Yarn();
        y2.insert("yo");
        y2.insert("sup");
        y1.swap(y2);
        if(!y1.contains("yo")){
            System.out.println("testSwap 1 failed");
            result--;
        }
        if(!y1.contains("sup")){
            System.out.println("testSwap 2 failed");
            result--;
        }
        if(!y2.contains("dup")){
            System.out.println("testSwap 3 failed");
            result--;
        }
        if(!y2.contains("unique")){
            System.out.println("testSwap 4 failed");
            result--;
        }
        if(y1.contains("dup")){
            System.out.println("testSwap 5 failed");
            result--;
        }
        if(!(y1.getSize() == 2 && y2.getSize() == 3)){
            System.out.println("testSwap 6 failed");
            result--;
        }
        if(!(y1.getUniqueSize() == 2 && y2.getUniqueSize() == 2)){
            System.out.println("testSwap 7 failed");
            result--;
        }
        System.out.println(result + "/7 testSwap tests passed");
    }

    public static void testKnit() {
        int result = 7;
        Yarn y1 = new Yarn();
        y1.insert("dup");
        y1.insert("dup");
        y1.insert("unique");
        Yarn y2 = new Yarn();
        y2.insert("dup");
        y2.insert("dup");
        y2.insert("cool");
        Yarn y3 = Yarn.knit(y1, y2);
        if(y3.count("dup") != 4){
            System.out.println("testKnit 1 failed");
            result--;
        }
        if(y3.count("unique") != 1){
            System.out.println("testKnit 2 failed");
            result--;
        }
        if(y3.count("cool") != 1){
            System.out.println("testKnit 3 failed");
            result--;
        }
        y3.insert("test");
        if(y1.contains("test") == true){
            System.out.println("testKnit 4 failed");
            result--;
        }
        if(y2.contains("test") == true){
            System.out.println("testKnit 5 failed");
            result--;
        }
        if(y3.getUniqueSize() == y2.getUniqueSize()){
            System.out.println("testKnit 6 failed");
            result--;
        }
        if(y3.getSize() == y2.getSize()){
            System.out.println("testKnit 7 failed");
            result--;
        }
        System.out.println(result + "/7 testKnit tests passed");

    }

    public static void testTear() {
        int result = 6;
        Yarn y1 = new Yarn();
        y1.insert("dup");
        y1.insert("dup");
        y1.insert("unique");
        Yarn y2 = new Yarn();
        y2.insert("dup");
        y2.insert("cool");
        Yarn y3 = Yarn.tear(y1, y2);
        if(y3.count("dup") != 1){
            System.out.println("testTear 1 failed");
            result--;
        }
        if(y3.count("unique") != 1){
            System.out.println("testTear 2 failed");
            result--;
        }
        if(y3.contains("cool")){
            System.out.println("testTear 3 failed");
            result--;
        }
        y3.insert("test");
        if(y1.contains("test")){
            System.out.println("testTear 4 failed");
            result--;
        }
        if(y2.contains("test")){
            System.out.println("testTear 5 failed");
            result--;
        }
        if(!(y3.getUniqueSize() == 3 && y3.getSize() == 3)){
            System.out.println("testTear 6 failed");
            result--;
        }
        System.out.println(result + "/6 testTear tests passed");
    }

    public static void testSameYarn() {
        int result = 4;
        Yarn y1 = new Yarn();
        y1.insert("dup");
        y1.insert("dup");
        y1.insert("unique");
        Yarn y2 = new Yarn();
        y2.insert("unique");
        y2.insert("dup");
        y2.insert("dup");
        if(!(Yarn.sameYarn(y1, y2))) {
            System.out.println("testSameYarn 1 failed");
            result--;
        }
        if(!(Yarn.sameYarn(y2, y1))) {
            System.out.println("testSameYarn 2 failed");
            result--;
        }
        y2.insert("test");
        if(Yarn.sameYarn(y1, y2)) {
            System.out.println("testSameYarn 3 failed");
            result--;
        }
        if(Yarn.sameYarn(y2, y1)){
            System.out.println("testSameYarn 4 failed");
            result--;
        }
        System.out.println(result + "/4 testSameYarn tests passed");
    }


    /*@Test
    public void testYarn() {
        Yarn ball = new Yarn();
    }

    @Test
    public void testIsEmpty() {
        Yarn ball = new Yarn();
        assertTrue(ball.isEmpty());
        ball.insert("not_empty");
        assertFalse(ball.isEmpty());
    }

    @Test
    public void testGetSize() {
        Yarn ball = new Yarn();
        ball.insert("dup");
        ball.insert("dup");
        assertEquals(ball.getSize(), 2);
        ball.insert("unique");
        assertEquals(ball.getSize(), 3);
    }

    @Test
    public void testGetUniqueSize() {
        Yarn ball = new Yarn();
        ball.insert("dup");
        ball.insert("dup");
        assertEquals(ball.getUniqueSize(), 1);
        ball.insert("unique");
        assertEquals(ball.getUniqueSize(), 2);
    }

    @Test
    public void testInsert() {
        Yarn ball = new Yarn();
        ball.insert("dup");
        ball.insert("dup");
        ball.insert("unique");
        assertTrue(ball.contains("dup"));
        assertTrue(ball.contains("unique"));
    }

    @Test
    public void testRemove() {
        Yarn ball = new Yarn();
        ball.insert("dup");
        ball.insert("dup");
        assertEquals(ball.getSize(), 2);
        assertEquals(ball.getUniqueSize(), 1);
        ball.remove("dup");
        assertEquals(ball.getSize(), 1);
        assertEquals(ball.getUniqueSize(), 1);
    }

    @Test
    public void testRemoveAll() {
        Yarn ball = new Yarn();
        ball.insert("dup");
        ball.insert("dup");
        ball.insert("unique");
        assertEquals(ball.getSize(), 3);
        assertEquals(ball.getUniqueSize(), 2);
        ball.removeAll("dup");
        assertEquals(ball.getSize(), 1);
        assertEquals(ball.getUniqueSize(), 1);
    }

    @Test
    public void testCount() {
        Yarn ball = new Yarn();
        ball.insert("dup");
        ball.insert("dup");
        ball.insert("unique");
        assertEquals(ball.count("dup"), 2);
        assertEquals(ball.count("unique"), 1);
        assertEquals(ball.count("forneymon"), 0);
    }

    @Test
    public void testContains() {
        Yarn ball = new Yarn();
        ball.insert("dup");
        ball.insert("dup");
        ball.insert("unique");
        assertTrue(ball.contains("dup"));
        assertTrue(ball.contains("unique"));
        assertFalse(ball.contains("forneymon"));
    }

    @Test
    public void testGetNth() {
        Yarn ball = new Yarn();
        ball.insert("dup");
        ball.insert("dup");
        ball.insert("unique");
        ball.insert("cool");
        Yarn comparison = ball.clone();
        for (int i = 0; i < ball.getSize(); i++) {
            String gotten = ball.getNth(i);
            assertTrue(comparison.contains(gotten));
            comparison.remove(gotten);
        }
    }

    @Test
    public void testGetMostCommon() {
        Yarn ball = new Yarn();
        ball.insert("dup");
        ball.insert("dup");
        ball.insert("unique");
        ball.insert("cool");
        assertEquals(ball.getMostCommon(), "dup");
        ball.insert("cool");
        String mc = ball.getMostCommon();
        assertTrue(mc.equals("dup") || mc.equals("cool"));
    }

    @Test
    public void testClone() {
        Yarn ball = new Yarn();
        ball.insert("dup");
        ball.insert("dup");
        ball.insert("unique");
        Yarn dolly = ball.clone();
        assertEquals(dolly.count("dup"), 2);
        assertEquals(dolly.count("unique"), 1);
        dolly.insert("cool");
        assertFalse(ball.contains("cool"));
    }

    @Test
    public void testSwap() {
        Yarn y1 = new Yarn();
        y1.insert("dup");
        y1.insert("dup");
        y1.insert("unique");
        Yarn y2 = new Yarn();
        y2.insert("yo");
        y2.insert("sup");
        y1.swap(y2);
        assertTrue(y1.contains("yo"));
        assertTrue(y1.contains("sup"));
        assertTrue(y2.contains("dup"));
        assertTrue(y2.contains("unique"));
        assertFalse(y1.contains("dup"));
    }

    @Test
    public void testKnit() {
        Yarn y1 = new Yarn();
        y1.insert("dup");
        y1.insert("dup");
        y1.insert("unique");
        Yarn y2 = new Yarn();
        y2.insert("dup");
        y2.insert("cool");
        Yarn y3 = Yarn.knit(y1, y2);
        assertEquals(y3.count("dup"), 3);
        assertEquals(y3.count("unique"), 1);
        assertEquals(y3.count("cool"), 1);
        y3.insert("test");
        assertFalse(y1.contains("test"));
        assertFalse(y2.contains("test"));
    }

    @Test
    public void testTear() {
        Yarn y1 = new Yarn();
        y1.insert("dup");
        y1.insert("dup");
        y1.insert("unique");
        Yarn y2 = new Yarn();
        y2.insert("dup");
        y2.insert("cool");
        Yarn y3 = Yarn.tear(y1, y2);
        assertEquals(y3.count("dup"), 1);
        assertEquals(y3.count("unique"), 1);
        assertFalse(y3.contains("cool"));
        y3.insert("test");
        assertFalse(y1.contains("test"));
        assertFalse(y2.contains("test"));
    }

    @Test
    public void testSameYarn() {
        Yarn y1 = new Yarn();
        y1.insert("dup");
        y1.insert("dup");
        y1.insert("unique");
        Yarn y2 = new Yarn();
        y2.insert("unique");
        y2.insert("dup");
        y2.insert("dup");
        assertTrue(Yarn.sameYarn(y1, y2));
        assertTrue(Yarn.sameYarn(y2, y1));
        y2.insert("test");
        assertFalse(Yarn.sameYarn(y1, y2));
    }*/

}
