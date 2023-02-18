import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
//00 objects
        //
//01 input
        Scanner scanner = new Scanner(System.in);
    // String QUEUE textiles / add, remove
        String[] textilesInput = scanner.nextLine().split(" ");
        ArrayDeque<Integer> textileQueue = new ArrayDeque<>();

        for(int i = 0; i < textilesInput.length; i++){
            textileQueue.add(Integer.valueOf(textilesInput[i]));
        }
    // String STACK meds / push, pop
        String[] medsInput = scanner.nextLine().split(" ");
        ArrayDeque<Integer> medsStack = new ArrayDeque<>();

        for(int i = 0; i < medsInput.length; i++){
            medsStack.push(Integer.valueOf(medsInput[i]));
        }

        //create a key value pair set with the healing items
        HashMap<Integer, String> healingItemsMenu = new HashMap<>(); //menu of healing itemss to produce
        healingItemsMenu.put(30, "Patch");
        healingItemsMenu.put(40, "Bandage");
        healingItemsMenu.put(100, "MedKit");

        TreeMap<String, Integer> healingItemsProduced = new TreeMap<>();
//02 process
        // combine elements to create healing items
        while(!textileQueue.isEmpty() && !medsStack.isEmpty()){      // stop creating when  healing items when either the textile or the medicaments are exhausted
            int medicalElement = medsStack.pop();
            int mixture = textileQueue.remove() + medicalElement;

            // if their sum is equal to any of the items in the table below create that item and remove both values.
            if(healingItemsMenu.containsKey(mixture)){

            }



        }


    // Otherwise, check if the sum is bigger than the value of the MedKit,
        // create the MedKit,
        // remove both values, and
        // add the remaining resources(of the sum) to the next value in the medicament collection
        // (Take the element from the collection, add the remaining sum to it, and put the element back to its place).
     // If you can’t create anything, remove the textile value, add 10 to the medicament value,
        //    and return the medicament back to its place, into its collection
//03 output
     //On the first line, print which one of the collections is over:
        //If the textile is over print: "Textiles are empty."
        //If the medicaments are over print: "Medicaments are empty."
        //If both are empty print: "Textiles and medicaments are both empty."
        //On the next n lines print only the created items (if any) ordered by the amount created descending, then by name alphabetically:
        //"{item name} - {amount created}
        // {item name} - {amount created}
     //On the last line print the remaining items (if any):
        //If there are any medicaments left:
        //"Medicaments left: {medicament1}, {medicament2}…"
        //If there are any textiles left:
        //"Textiles left: {textile1}, {textile2}…"
    }
}