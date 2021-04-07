package game;

import java.util.Arrays;

public class GameBoard {

    private static final FieldStates[] fields = new FieldStates[9];
    private static Players currentPlayer;
    private static Players winner;

    /**
     * Makes a move with the current player on the given field with the index of input if possible
     */
    public static void nextMove(final int input) {
        if (!winner.equals(Players.NOBODY)) {
            reset();
        } else if (currentPlayer.equals(Players.X) && fields[input].equals(FieldStates.EMPTY)) {
            fields[input] = FieldStates.X;
            currentPlayer = Players.O;
            checkWinner();
            Logger.logBoard();
        } else if (currentPlayer.equals(Players.O) && fields[input].equals(FieldStates.EMPTY)) {
            fields[input] = FieldStates.O;
            currentPlayer = Players.X;
            checkWinner();
            Logger.logBoard();
        }

        if (Ai.getAiRole().equals(currentPlayer) && winner.equals(Players.NOBODY)) {
            Ai.yourTurn();
        }
    }

    /**
     * Checks if there is a winner and sets the variable winner
     */
    private static void checkWinner() {
        if (checkLine(0, 1, 2, FieldStates.X) || checkLine(3, 4, 5, FieldStates.X) || checkLine(6, 7, 8, FieldStates.X) ||
                checkLine(0, 3, 6, FieldStates.X) || checkLine(1, 4, 7, FieldStates.X) || checkLine(2, 5, 8, FieldStates.X) ||
                checkLine(0, 4, 8, FieldStates.X) || checkLine(2, 4, 6, FieldStates.X)) {
            winner = Players.X;
        } else if (checkLine(0, 1, 2, FieldStates.O) || checkLine(3, 4, 5, FieldStates.O) || checkLine(6, 7, 8, FieldStates.O) ||
                checkLine(0, 3, 6, FieldStates.O) || checkLine(1, 4, 7, FieldStates.O) || checkLine(2, 5, 8, FieldStates.O) ||
                checkLine(0, 4, 8, FieldStates.O) || checkLine(2, 4, 6, FieldStates.O)) {
            winner = Players.O;
        } else if (allFieldsOccupied()) {
            winner = Players.TIE;
        } else {
            winner = Players.NOBODY;
        }
    }

    /**
     * Checks if a Line of 3 fields has the same Field State
     */
    private static boolean checkLine(final int f1, final int f2, final int f3, final FieldStates state) {
        if (fields[f1] == state && fields[f2] == state && fields[f3] == state) {
            return true;
        } else {
            return false;
        }

    }

    private static boolean allFieldsOccupied() {
        return !Arrays.asList(fields).contains(FieldStates.EMPTY);
    }

    /**
     * Resets the Board for a new game
     */
    private static void reset() {
        for (int i = 0; i < 9; i++) {
            fields[i] = FieldStates.EMPTY;
        }
        currentPlayer = Players.X;
        winner = Players.NOBODY;
    }

    /**
     * Resets the Game Board and creates a Gui
     */
    public static void start() {
        reset();
        Gui.create();
    }

    public static FieldStates getField(int field) {
        return fields[field];
    }

    public static Players getWinner() {
        return winner;
    }

    public static Players getCurrentPlayer() {
        return currentPlayer;
    }
}
