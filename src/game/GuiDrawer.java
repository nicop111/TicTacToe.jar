package game;

import javax.swing.*;
import java.awt.*;

public class GuiDrawer extends JLabel {

    /**
     * Draws the Game Board depending on its condition
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (Gui.isGameStarted()) {
            if (GameBoard.getWinner().equals(Players.NOBODY)) {
                // Lines
                g.setColor(Color.DARK_GRAY);
                g.drawLine(0, Gui.tile, 3 * Gui.tile, Gui.tile);
                g.drawLine(0, 2 * Gui.tile, 3 * Gui.tile, 2 * Gui.tile);
                g.drawLine(Gui.tile, 0, Gui.tile, 3 * Gui.tile);
                g.drawLine(2 * Gui.tile, 0, 2 * Gui.tile, 3 * Gui.tile);

                // X/O
                if (GameBoard.getField(0) != FieldStates.EMPTY) {
                    setColor(GameBoard.getField(0), g);
                    g.drawString(GameBoard.getField(0).toString(), Gui.tile / 2, Gui.tile / 2);
                }
                if (GameBoard.getField(1) != FieldStates.EMPTY) {
                    setColor(GameBoard.getField(1), g);
                    g.drawString(GameBoard.getField(1).toString(), Gui.tile * 3 / 2, Gui.tile / 2);
                }
                if (GameBoard.getField(2) != FieldStates.EMPTY) {
                    setColor(GameBoard.getField(2), g);
                    g.drawString(GameBoard.getField(2).toString(), Gui.tile * 5 / 2, Gui.tile / 2);
                }

                if (GameBoard.getField(3) != FieldStates.EMPTY) {
                    setColor(GameBoard.getField(3), g);
                    g.drawString(GameBoard.getField(3).toString(), Gui.tile / 2, Gui.tile * 3 / 2);
                }
                if (GameBoard.getField(4) != FieldStates.EMPTY) {
                    setColor(GameBoard.getField(4), g);
                    g.drawString(GameBoard.getField(4).toString(), Gui.tile * 3 / 2, Gui.tile * 3 / 2);
                }
                if (GameBoard.getField(5) != FieldStates.EMPTY) {
                    setColor(GameBoard.getField(5), g);
                    g.drawString(GameBoard.getField(5).toString(), Gui.tile * 5 / 2, Gui.tile * 3 / 2);
                }

                if (GameBoard.getField(6) != FieldStates.EMPTY) {
                    setColor(GameBoard.getField(6), g);
                    g.drawString(GameBoard.getField(6).toString(), Gui.tile / 2, Gui.tile * 5 / 2);
                }
                if (GameBoard.getField(7) != FieldStates.EMPTY) {
                    setColor(GameBoard.getField(7), g);
                    g.drawString(GameBoard.getField(7).toString(), Gui.tile * 3 / 2, Gui.tile * 5 / 2);
                }
                if (GameBoard.getField(8) != FieldStates.EMPTY) {
                    setColor(GameBoard.getField(8), g);
                    g.drawString(GameBoard.getField(8).toString(), Gui.tile * 5 / 2, Gui.tile * 5 / 2);
                }
            } else if (GameBoard.getWinner().equals(Players.TIE)) {
                g.setColor(Color.BLACK);
                g.drawString("Tie!", Gui.tile / 2, Gui.tile * 3 / 2);
            } else if (!Ai.isActive()) {
                g.setColor(Color.BLACK);
                g.drawString("Player " + GameBoard.getWinner().toString() + " won!", Gui.tile / 2, Gui.tile * 3 / 2);
            } else if (Ai.getAiRole().equals(GameBoard.getCurrentPlayer())) {
                g.setColor(Color.BLACK);
                g.drawString("You won!", Gui.tile / 2, Gui.tile * 3 / 2);
            } else if (!Ai.getAiRole().equals(GameBoard.getCurrentPlayer())) {
                g.setColor(Color.BLACK);
                g.drawString("You lose!", Gui.tile / 2, Gui.tile * 3 / 2);
            }
        }

        repaint();
    }

    /**
     * Sets the color of the graphics drawer depending on the field state
     */
    private static void setColor(final FieldStates fieldState, final Graphics g) {
        if (fieldState == FieldStates.X) {
            g.setColor(Color.RED);
        } else if (fieldState == FieldStates.O) {
            g.setColor(Color.BLUE);
        }
    }
}
