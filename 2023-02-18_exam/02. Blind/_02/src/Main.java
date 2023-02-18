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
        String[] nm = scanner

        //•	On the next N lines, you will receive a string representing the respective row of the playground.
        // The positions in every string will be separated by a single space (" ").
        //•	On the next few lines, until you receive the command "Finish", you will be given directions (up, down, right, left).
        //02. process
        //If the direction leads you out of the field, you need to stay in position inside the field(do NOT make the move).
        // if an obstacle do not make the move
        // In case you step on a position marked with '-', increase the count of the moves made.

        //03. output
        //"Game over!"
        //"Touched opponents: {count} Moves made: {count}"
    }
}