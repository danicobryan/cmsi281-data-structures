//package web_nav;

import java.util.Scanner;
import java.util.LinkedList;

public class WebNavigator {

    private LinkedList<String> forwardHistory;
    private LinkedList<String> backHistory;
    private String current; 
    
    WebNavigator () {
        forwardHistory = new LinkedList<String>();
        backHistory = new LinkedList<String>();
    }
    
    public boolean getNextUserCommand (Scanner input) {
        String command = input.nextLine();
        String[] parsedCommand = command.split(" ");
        
        switch(parsedCommand[0]) {
        case "exit":
            System.out.println("Goodbye!");
            return false;
        case "visit":
            visit(parsedCommand[1]);
            break;
        case "back":
            back();
            break;
        case "forward":
            forw();
            break;
        default:
            System.out.println("[X] Invalid command, try again");
        }
        
        System.out.println("Currently Visiting: " + current);
        
        return true;
    }
    
    /*
     *  Visits the current site, clears the forward history,
     *  and records the visited site in the back history
     */
    public void visit (String site) {
        backHistory.add(current);
        current = site;
        forwardHistory.clear();

    }
    
    /*
     *  Changes the current site to the one that was last
     *  visited in the order on which visit was called on it
     */
    public void back () {
        if (backHistory.size() > 1) {
            forwardHistory.addFirst(current);
            current = backHistory.getLast();
            backHistory.removeLast();
        }
    }
    
    public void forw () {
        if (forwardHistory.size() > 0){
            backHistory.add(current);
            current = forwardHistory.getFirst();
            forwardHistory.removeFirst();
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        WebNavigator navi = new WebNavigator();
        
        System.out.println("Welcome to ForneyFox, enter a command from your ForneyFox user manual!");
        while (navi.getNextUserCommand(input)) {}
        System.out.println("Goodbye!");
    }

}
