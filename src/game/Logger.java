package game;

public class Logger {

    private static final String[] fieldAsString = new String[9];

    /**
     * Prints the current GameBoard and the winner into the console
     */
    public static void logBoard() {
        for (int i = 0; i < 9; i++) {
            if (GameBoard.getField(i).equals(FieldStates.X)) {
                fieldAsString[i] = "X";
            } else if (GameBoard.getField(i).equals(FieldStates.O)) {
                fieldAsString[i] = "O";
            } else {
                fieldAsString[i] = " ";
            }
        }
        System.out.println(fieldAsString[0] + "|" + fieldAsString[1] + "|" + fieldAsString[2]);
        System.out.println("-+-+-");
        System.out.println(fieldAsString[3] + "|" + fieldAsString[4] + "|" + fieldAsString[5]);
        System.out.println("-+-+-");
        System.out.println(fieldAsString[6] + "|" + fieldAsString[7] + "|" + fieldAsString[8]);
        System.out.println();
        if (GameBoard.getWinner().equals(Players.TIE)) {
            Logger.log("Tie");
        } else if (!GameBoard.getWinner().equals(Players.NOBODY)) {
            Logger.log(GameBoard.getWinner().toString() + " won");
        }
    }

    /**
     * Prints a given String into the console
     */
    public static void log(String s) {
        System.out.println(s);
    }
}
