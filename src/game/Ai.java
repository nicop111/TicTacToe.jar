package game;

public class Ai {
    private static Players aiRole;
    private static FieldStates aiField;
    private static FieldStates playerField;

    /**
     * Let the Ai make a more or less intelligent move
     */
    public static void yourTurn() {
        //Trys to win
        intelligentMove(aiField);
        //ELse trys to prevent player from winning
        if (aiRole.equals(GameBoard.getCurrentPlayer())) {
            intelligentMove(playerField);
        }
        //Else makes random move
        if (aiRole.equals(GameBoard.getCurrentPlayer())) {
            randomMove();
        }

    }

    /**
     * Checks if a certain move would lead to a win of the Ai or the player and does that move
     * to win or prevent the player from winning
     */
    private static void intelligentMove(final FieldStates fs) {
        if (GameBoard.getField(0).equals(FieldStates.EMPTY) && (checkPair(1, 2, fs) || checkPair(3, 6, fs) || checkPair(4, 8, fs))) {
            GameBoard.nextMove(0);
        } else if (GameBoard.getField(1).equals(FieldStates.EMPTY) && (checkPair(0, 2, fs) || checkPair(4, 7, fs))) {
            GameBoard.nextMove(1);
        } else if (GameBoard.getField(2).equals(FieldStates.EMPTY) && (checkPair(0, 1, fs) || checkPair(4, 6, fs) || checkPair(5, 8, fs))) {
            GameBoard.nextMove(2);
        } else if (GameBoard.getField(3).equals(FieldStates.EMPTY) && (checkPair(0, 6, fs) || checkPair(4, 5, fs))) {
            GameBoard.nextMove(3);
        } else if (GameBoard.getField(4).equals(FieldStates.EMPTY) && (checkPair(3, 5, fs) || checkPair(1, 7, fs) || checkPair(0, 8, fs) || checkPair(2, 6, fs))) {
            GameBoard.nextMove(4);
        } else if (GameBoard.getField(5).equals(FieldStates.EMPTY) && (checkPair(3, 4, fs) || checkPair(2, 8, fs))) {
            GameBoard.nextMove(5);
        } else if (GameBoard.getField(6).equals(FieldStates.EMPTY) && (checkPair(0, 3, fs) || checkPair(7, 8, fs) || checkPair(2, 4, fs))) {
            GameBoard.nextMove(6);
        } else if (GameBoard.getField(7).equals(FieldStates.EMPTY) && (checkPair(1, 4, fs) || checkPair(6, 8, fs))) {
            GameBoard.nextMove(7);
        } else if (GameBoard.getField(8).equals(FieldStates.EMPTY) && (checkPair(0, 4, fs) || checkPair(2, 5, fs) || checkPair(6, 7, fs))) {
            GameBoard.nextMove(8);
        }
    }

    /**
     * Does a move on a random empty field
     */
    private static void randomMove() {
        int index = (int) (Math.random() * 9);
        while (!GameBoard.getField(index).equals(FieldStates.EMPTY)) {
            index = (int) (Math.random() * 9);
        }
        GameBoard.nextMove(index);
    }

    /**
     * Checks if a pair of fields has the same Field State
     */
    private static boolean checkPair(final int f1, final int f2, final FieldStates state) {
        if (GameBoard.getField(f1).equals(state) && GameBoard.getField(f2).equals(state)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Sets the Ai to a specific role
     */
    public static void setAiRole(final Players role) {
        aiRole = role;
        if (aiRole.equals(Players.X)) {
            aiField = FieldStates.X;
            playerField = FieldStates.O;
        } else if (aiRole.equals(Players.O)) {
            aiField = FieldStates.O;
            playerField = FieldStates.X;
        }
    }

    /**
     * True if the Ai has role X or O
     */
    public static boolean isActive() {
        if (aiRole.equals(Players.X) || aiRole.equals(Players.O)) {
            return true;
        } else {
            return false;
        }
    }

    public static Players getAiRole() {
        return aiRole;
    }
}
