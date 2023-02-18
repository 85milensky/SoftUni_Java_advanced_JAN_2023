import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//00. objects
        // track of the count of touched opponents and
        int touchCount = 0;
        // the moves you’ve made
        int movesMade = 0;
        // obstacle
        // opponent
//01. input
        Scanner scanner = new Scanner(System.in);
        //•	On the first line, you'll receive the dimensions of the playground in format:
        // "N M", where N is the number of rows, and M is the number of columns.
        // They'll be separated by a single space (" ").
        String[] nm = scanner.nextLine().split(" ");
        int n = Integer.valueOf(nm[0]);
        int m = Integer.valueOf(nm[1]);

        String[][] track = new String[n][m];

        //•	On the next N lines, you will receive a string representing the respective row of the playground.
        // The positions in every string will be separated by a single space (" ").
        for(int row = 0; row < n; row++){
            String[] matrixInput = scanner.nextLine().split(" ");
            for(int col = 0; col < m; col++){
                track[row][col] = String.valueOf(matrixInput[col]);
            }
        }
        int[] currentCoordinates = new int[2];

        // find your position

        for(int row = 0; row < n; row++){
            boolean breaking = false;

            for(int col = 0; col < m; col++){
                if (track[row][col].equals("B")){
                    currentCoordinates[0] = row;
                    currentCoordinates[1] = col;
                    breaking = true;
                    break;
                }
            }
            if(breaking == true) break;
        }

        String command = scanner.nextLine(); // - receiving the directions (up, down, right, left) End
 //02. process
        while(!command.equals("Finish")){
            Integer[] oldCoordinates = new Integer[2];
            oldCoordinates[0] = currentCoordinates[0];
            oldCoordinates[1] = currentCoordinates[1];
            boolean moveAllowed = true;

            if (command.equals("left")) {
                if(currentCoordinates[1] > 0){
                Integer newCoordinatesRows = currentCoordinates[1] - 1;
                currentCoordinates[1] = newCoordinatesRows;
                } else moveAllowed = false;

            } else if (command.equals("right")) {
                if(currentCoordinates[1] < m - 1) {
                    Integer newCoordinatesRows = currentCoordinates[1] + 1;
                    currentCoordinates[1] = newCoordinatesRows;
                } else moveAllowed = false;
            } else if (command.equals("up")) {
                if(currentCoordinates[0] > 0) {
                    Integer newCoordinatesRows = currentCoordinates[0] - 1;
                    currentCoordinates[0] = newCoordinatesRows;
                } else moveAllowed = false;
            } else if (command.equals("down")) {
                if(currentCoordinates[0] < n - 1) {
                    Integer newCoordinatesRows = currentCoordinates[0] + 1;
                    currentCoordinates[0] = newCoordinatesRows;
                } else moveAllowed = false;
            }

            //results from the move

            if(moveAllowed && track[currentCoordinates[0]][currentCoordinates[1]].equals("O")){ // if an obstacle do not make the move / return to the old coordinates
                currentCoordinates[0] = oldCoordinates[0];
                currentCoordinates[1] = oldCoordinates[1];
            } else if(moveAllowed && track[currentCoordinates[0]][currentCoordinates[1]].equals("-")) { // regular move
                movesMade+=1; // number of moves increases;
                track[oldCoordinates[0]][oldCoordinates[1]] = "-";//old position = -
                track[currentCoordinates[0]][currentCoordinates[1]] = "B";

            } else if (moveAllowed && track[currentCoordinates[0]][currentCoordinates[1]].equals("P")) {// found player
                movesMade+=1; // number of moves increases;
                track[oldCoordinates[0]][oldCoordinates[1]] = "-";//old position = -
                track[currentCoordinates[0]][currentCoordinates[1]] = "B";
                touchCount += 1;
            }

            if (touchCount == 3) break;
            command = scanner.nextLine();
        }
 //03. output
        //"Game over!"
        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d", touchCount, movesMade);
        //"Touched opponents: {count} Moves made: {count}"
    }
}