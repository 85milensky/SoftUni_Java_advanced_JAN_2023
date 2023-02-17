import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //1. input
        //- an integer N, which represents the size of a square matrix
        int n = Integer.valueOf(scanner.nextLine());
        //- the racing number of the tracked race car
        String racingNo = scanner.nextLine();
        // - On the next N lines you will be given the rows of  the matrix
        String[][] raceTrack = new String[n][n];
        //fillRaceTrack(raceTrack); //   (string sequences, separated by whitespace), which will be representing the race route

        for (int row = 0; row < raceTrack.length; row++) {
            String[] matrixInput = scanner.nextLine().split(" ");

            for (int col = 0; col < raceTrack.length; col++) {
                raceTrack[row][col] = String.valueOf(matrixInput[col]);
            }
        }

        String command = scanner.nextLine(); // - receiving the directions for the race car - left, right, up, down, End
        int kmTracker = 0;
        int[] currentCoordinates = new int[2];
        currentCoordinates[0] = 0;
        currentCoordinates[1] = 0;
        raceTrack[currentCoordinates[0]][currentCoordinates[1]] = "C";//Car is at starting position 0 0
        boolean raceEnded = false;

        while (!command.equals("End")) {

            Integer[] oldCoordinates = new Integer[2];
            oldCoordinates[0] = currentCoordinates[0];
            oldCoordinates[1] = currentCoordinates[1];

            if (command.equals("left")) {
                Integer newCoordinatesRows = currentCoordinates[1] - 1;
                currentCoordinates[1] = newCoordinatesRows;

            } else if (command.equals("right")) {
                Integer newCoordinatesRows = currentCoordinates[1] + 1;
                currentCoordinates[1] = newCoordinatesRows;

            } else if (command.equals("up")) {
                Integer newCoordinatesRows = currentCoordinates[0] - 1;
                currentCoordinates[0] = newCoordinatesRows;

            } else if (command.equals("down")) {
                Integer newCoordinatesRows = currentCoordinates[0] + 1;
                currentCoordinates[0] = newCoordinatesRows;
            }

            String newPosition = raceTrack[currentCoordinates[0]][currentCoordinates[1]]; // getting the symbol at the current coordinates


            if(newPosition.equals("T")){
                //tunnelPassing(); // - Thеre will be a tunnel T somewhere across the race route. , the car goes through it and exits at the other end.
                kmTracker+=30;//     The car passes 30 kilometers
                raceTrack[oldCoordinates[0]][oldCoordinates[1]] = ".";//old position = .
                raceTrack[currentCoordinates[0]][currentCoordinates[1]] = "."; // new position = . - car is entering and leaving the tunnel entry
                //search for the other end of the tunnel
                //int[] tunnelExitCoordinates = new int[2];

                for(int row = 0; row < raceTrack.length; row++) {
                    boolean colBreak = false;
                    for (int col = 0; col < raceTrack.length; col++) {
                        if (raceTrack[row][col].equals("T")) {
                           //tunnelExitCoordinates[0] = row;
                            //tunnelExitCoordinates[1] = col;
                            raceTrack[row][col] = "C";
                            currentCoordinates[0] = row;
                            currentCoordinates[1] = col;
                            colBreak = true;
                            break;
                        }
                    }
                    if(colBreak == true) break;
                }

                //     The tunnel stays behind the car, so the race route is clear, and both the positions marked with "T", should be marked with ".".
            } else if(newPosition.equals(".")){
                // - If the race car comes across a position marked with ".".
                kmTracker+=10; //      The car passes 10 kilometers for the current move and waits for the next direction.
                raceTrack[oldCoordinates[0]][oldCoordinates[1]] = ".";//old position = .
                raceTrack[currentCoordinates[0]][currentCoordinates[1]] = "C"; // new position = c

            } else if(newPosition.equals("F")){
                //- If the car reaches the finish line - "F" position, the race is over.
                //     the car has covered another 10 km with the last move.
                // - mark the last known position of the race car with "C"
                kmTracker+=10;
                raceTrack[oldCoordinates[0]][oldCoordinates[1]] = ".";//old position = .
                raceTrack[currentCoordinates[0]][currentCoordinates[1]] = "C"; // new position = c
                raceEnded = true;
                break;
            }




                // - mark the last known position of the race car with "C"

                command = scanner.nextLine(); // - receiving the directions for the race car - left, right, up, down, End
            }


            //

            //2. operations
            //

            // - The finish line will be marked with "F". All other positions will be marked with ".".



            //3. output
        if (!raceEnded){        // - If you receive "End" command, before the race car manages to reach the finish line,
                                //   the car is disqualified and the following output should be printed on the Console: "Racing car {racing number} DNF.
            System.out.printf("Racing car %s DNF.", racingNo);

        } else{
            System.out.printf("Racing car %s finished the stage!", racingNo);

        }
        System.out.println();
        System.out.printf("Distance covered %s km.", kmTracker);
        System.out.println();
        printRaceTrack(raceTrack);

            // - If the car reaches F- "Racing car {racing number} finished the stage!".
            // 2nd line:
            // - print the distance that the tracked race car has covered: "Distance covered {kilometers passed} km."
            // print the race track
        }

    private static void printRaceTrack(String[][] raceTrack) {
        for(Integer row = 0; row < raceTrack.length; row++){
            for(Integer column = 0; column < raceTrack.length; column++){
                System.out.print(raceTrack[row][column]);
            }
            System.out.println();
        }
    }

    //private static String[][] fillRaceTrack(String[][] raceTrack) {

  //      Scanner scanner = new Scanner(System.in);


      //  return raceTrack;
    //}
}