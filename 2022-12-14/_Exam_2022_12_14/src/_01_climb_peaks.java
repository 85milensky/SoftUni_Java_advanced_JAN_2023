import com.sun.source.tree.Tree;

import java.util.*;

public class _01_climb_peaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<Integer, TreeMap<String, Integer>> peaksToClimB = new TreeMap<Integer, TreeMap<String, Integer>>();

        peaksToClimB.put(1, new TreeMap<String, Integer>());
        peaksToClimB.put(2, new TreeMap<String, Integer>());
        peaksToClimB.put(3, new TreeMap<String, Integer>());
        peaksToClimB.put(4, new TreeMap<String, Integer>());
        peaksToClimB.put(5, new TreeMap<String, Integer>());
        peaksToClimB.get(1).put("Vihren", 80);
        peaksToClimB.get(2).put("Kutelo", 90);
        peaksToClimB.get(3).put("Banski Suhodol", 100);
        peaksToClimB.get(4).put("Polezhan", 60);
        peaksToClimB.get(5).put("Kamenitza", 70);

        ArrayDeque<Integer> foodStack = new ArrayDeque<>();
        ArrayDeque<Integer> staminaQueue = new ArrayDeque<>();

        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();
        fillStack(input1, foodStack);
        fillQueue(input2, staminaQueue);
        ArrayDeque<String> successStoriesQueue = new ArrayDeque<>();

        while(!foodStack.isEmpty() && !staminaQueue.isEmpty() && peaksToClimB.size()!=0){
            if (foodStack.pop() + staminaQueue.poll() >= currentPeakDifficulty(peaksToClimB)){
                String peakToAdd = peaksToClimB.firstEntry().getValue().firstKey();
                peaksToClimB.remove(peaksToClimB.firstEntry().getKey());
                successStoriesQueue.add(peakToAdd);
            }
        }

        printResult(successStoriesQueue, peaksToClimB);
    }

    private static int currentPeakDifficulty(TreeMap<Integer, TreeMap<String, Integer>> peaksToClimB) {
        int difficulty = 0;

        TreeMap<String, Integer> tree= peaksToClimB.firstEntry().getValue();
        difficulty = tree.firstEntry().getValue();

        return difficulty;
    }

    private static void printResult(ArrayDeque<String> successStories, TreeMap<Integer, TreeMap<String, Integer>> peaksToClimB) {
        if (!peaksToClimB.isEmpty()){
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        } else {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
            System.out.println("Conquered peaks:");
            for (String peak : successStories){
                System.out.println(peak);
            }
        }


    }

    private static ArrayDeque<Integer> fillQueue(String input2, ArrayDeque<Integer> staminaQueue) {
       String[] arrayOfInputs = input2.split(", ");

       for(String input: arrayOfInputs){
            staminaQueue.add(Integer.valueOf(input));
       }
        return staminaQueue;
    }

    private static ArrayDeque<Integer> fillStack(String input1, ArrayDeque<Integer> foodStack) {

        String[] arrayOfInputs = input1.split(", ");

        for (String input : arrayOfInputs){
            foodStack.push(Integer.valueOf(input));
        }

        return foodStack;
    }

    /*private static TreeMap<Integer, TreeMap<String,Integer>> fillPeaks(TreeMap peaks<Integer, TreeMap<String, Integer>>) {

        peaks.put(1, new TreeMap<String, Integer>().put("Vihren", 80));
        peaks.put(2, new TreeMap<String, Integer>().put("Kutelo", 90));
        peaks.put(3, new TreeMap<String, Integer>().put("Banski Suhodol", 100));
        peaks.put(4, new TreeMap<String, Integer>().put("Polezhan", 60));
        peaks.put(5, new TreeMap<String, Integer>().put("Kamenitza", 70));

        return peaks;
    }*/
}
