import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
        * Input
•	In the first line, you will be given a sequence of the milligrams of caffeinе - integers separated by comma and space ", " in the range [1, 50].
•	In the second line, you will be given a sequence of energy drinks - integers separated by comma and space ", " in the range [1, 300].

*
*       Capacity
*   the maximum caffeine Stamat can have for the night is 300 milligrams,
*   and his initial is always 0.
*/
        Scanner scanner = new Scanner(System.in);

        String[] mgCaffInput = scanner.nextLine().split(", ");
        String[] energyDrinksInput = scanner.nextLine().split(", ");

        ArrayDeque<Integer> mgCaffeineStack = new ArrayDeque<>();
        ArrayDeque<Integer> nrgDrinksQueue = new ArrayDeque<>();

        int maxCaffeine = 300;
        int caffeineLevel = 0;

        for (int i = 0; i < mgCaffInput.length; i++ ){
            int inputNumber = Integer.parseInt(mgCaffInput[i].trim());
            mgCaffeineStack.push(inputNumber);
        }

        for (int i = 0; i < energyDrinksInput.length; i++ ){
            int inputNumber = Integer.parseInt(energyDrinksInput[i]);
            nrgDrinksQueue.add(inputNumber);
        }

        //Operations
        while(!mgCaffeineStack.isEmpty() && !nrgDrinksQueue.isEmpty()){
            int mgCaffPop = mgCaffeineStack.pop();
            int nrgDrinkRemove = nrgDrinksQueue.remove();
            int caffToTake = mgCaffPop * nrgDrinkRemove;

            if (caffToTake + caffeineLevel >= 300){
                nrgDrinksQueue.add(nrgDrinkRemove);
                if(caffeineLevel - 30 >= 0) caffeineLevel -= 30;
            } else caffeineLevel += caffToTake;

        }

        //Output

        if(!nrgDrinksQueue.isEmpty()){
            //System.out.print("Drinks left: ");

           // for (int i = 0; i < nrgDrinksQueue.size(); i++){
            //    System.out.print(nrgDrinksQueue.remove());
           //     if(i != nrgDrinksQueue.size() -1 ) System.out.print(nrgDrinksQueue.remove());
           // }

            //System.out.println(nrgDrinksQueue.);
            System.out.printf("Drinks left: %s%n", String.join(", ", Arrays.asList(nrgDrinksQueue.toString()
                    .substring(1, nrgDrinksQueue.toString().length() - 1))));

            //System.out.print(String drink -> );

            //System.out.println();
        }else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }

        System.out.printf("Stamat is going to sleep with %s mg caffeine.", caffeineLevel);


        /*
        *Output
•	On the first line:
o	If Stamat hasn't drunk all the energy drinks, print the remaining ones separated by a comma and a space ", ":
	"Drinks left: { remaining drinks separated by ", " }"
o	If Stamat has drunk all the energy drinks, print:
	"At least Stamat wasn't exceeding the maximum caffeine."
•	On the next line, print:
o	"Stamat is going to sleep with { current caffeine } mg caffeine."

        * */

    }

}