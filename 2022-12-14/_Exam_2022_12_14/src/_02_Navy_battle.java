import java.util.Scanner;

public class _02_Navy_battle {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Integer matrixSize =Integer.valueOf(scanner.nextLine());
        String[][] battleMap = new String[matrixSize][matrixSize];


        for(Integer row = 0; row < battleMap.length; row++){
             String inputCharacters = scanner.nextLine();
            char[] input = inputCharacters.toCharArray();

            for(Integer column = 0; column < input.length; column++){
                battleMap[row][column] = String.valueOf(input[column]);
            }
        }

        Integer submarineHealth = 3;
        Integer battleCruisersOnTheMap = 3;
        Integer[] submarineCoordinates = new Integer[2];
        findSubmarineCoordinates(battleMap, submarineCoordinates);

        while(submarineHealth!=0 && battleCruisersOnTheMap != 0){
            String command = scanner.nextLine();

            Integer[] oldCoordinates = new Integer[2];
            oldCoordinates[0] = submarineCoordinates[0];
            oldCoordinates[1] = submarineCoordinates[1];

            if(command.equals("left")) {
                Integer newCoordinatesRows = submarineCoordinates[1]-1;
                submarineCoordinates[1] = newCoordinatesRows;

                //move(battleMap, submarineCoordinates, oldCoordinates, submarineHealth, battleCruisersOnTheMap);

                }else if(command.equals("right")) {
                Integer newCoordinatesRows = submarineCoordinates[1] + 1;
                submarineCoordinates[1] = newCoordinatesRows;

                //move(battleMap, submarineCoordinates, oldCoordinates, submarineHealth, battleCruisersOnTheMap);

                }else if (command.equals("up")) {
                Integer newCoordinatesColumn = submarineCoordinates[0] - 1;
                submarineCoordinates[0] = newCoordinatesColumn;

                //move(battleMap, submarineCoordinates, oldCoordinates, submarineHealth, battleCruisersOnTheMap);

                }else if (command.equals("down")) {
                Integer newCoordinatesColumn = submarineCoordinates[0] + 1;
                submarineCoordinates[0] = newCoordinatesColumn;

                //move(battleMap, submarineCoordinates, oldCoordinates, submarineHealth, battleCruisersOnTheMap);
            }

            battleMap[oldCoordinates[0]][oldCoordinates[1]] = "-"; //1. change the old coordinates to _
            //2. submarine moves to the new coordinates. check what is there

            if (battleMap[submarineCoordinates[0]][submarineCoordinates[1]].equals("*")) {//mine hit
                //mineHit(battleMap, submarineHealth);
                submarineHealth -= 1;
                battleMap[submarineCoordinates[0]][submarineCoordinates[1]] = "S";

            } else if (battleMap[submarineCoordinates[0]][submarineCoordinates[1]].equals("C")) {//battle cruiser hit
                //battleCruiserHit(battleMap, battleCruisersOnTheMap);
                battleCruisersOnTheMap -= 1;
                battleMap[submarineCoordinates[0]][submarineCoordinates[1]] = "S";

            } else { //field is free so the submarine moves there
                battleMap[submarineCoordinates[0]][submarineCoordinates[1]] = "S";
            }

        }

        if (battleCruisersOnTheMap == 0){
            System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
            printMatrixCoordinates(battleMap);
        } else if (submarineHealth ==0) {
            System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!", submarineCoordinates[0], submarineCoordinates[1]);
            System.out.println();
            printMatrixCoordinates(battleMap);
        } //else printMatrixCoordinates(battleMap);
    }
    private static void printMatrixCoordinates(String[][] battleMap) {
        for(Integer row = 0; row < battleMap.length; row++){
            for(Integer column = 0; column < battleMap.length; column++){
                System.out.print(battleMap[row][column]);
            }
            System.out.println();
        }
    }
    private static Integer[] findSubmarineCoordinates(String[][] battleMap, Integer[] submarineCoordinates) {

        for (Integer row = 0; row < battleMap.length; row++){
            boolean submarineFound = false;

            for (Integer column = 0; column < battleMap.length; column++)
            {
                if (battleMap[row][column].equals("S")){
                    submarineCoordinates[0] = row;
                    submarineCoordinates[1] = column;
                    submarineFound = true;
                    break;
                }
            }

            if(submarineFound == true) break;
        }

        return submarineCoordinates;
    }
}
