package game;

import javax.swing.*;
import java.awt.*;

public class Gui {

    private static JFrame jf;
    private static GuiDrawer guiDrawer;
    private static final JButton[] btn = new JButton[10];
    private static final JButton[] startBtn = new JButton[4];
    private static boolean gameStarted = false;

    protected static final int size = 255, tile = size / 3;

    /**
     * Creates a JFrame containing the GuiDrawer
     */
    public static void create() {
        jf = new JFrame();
        jf.setSize(size + 14, size + 38);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        jf.setTitle("TicTacToe");

        guiDrawer = new GuiDrawer();
        guiDrawer.setBounds(0, 0, jf.getWidth(), jf.getHeight());
        guiDrawer.setVisible(true);
        jf.add(guiDrawer);

        setUpStartScreenButtons();

        jf.setVisible(true);
    }

    /**
     * Sets up the buttons for the StartScreen in the JFrame
     */
    private static void setUpStartScreenButtons() {
        startBtn[0] = new JButton("1v1");
        startBtn[1] = new JButton("Play X");
        startBtn[2] = new JButton("Play O");
        startBtn[3] = new JButton();

        for (int i = 0; i < 4; i++) {
            startBtn[i].setVisible(true);
            startBtn[i].setFocusPainted(false);
            startBtn[i].setContentAreaFilled(true);
            startBtn[i].setBorder(null);
            startBtn[i].setBackground(new Color(200, 190, 180));
            jf.add(startBtn[i]);
        }

        startBtn[0].addActionListener(e -> {
            for (int j = 0; j < 4; j++) {
                jf.remove(startBtn[j]);
            }
            gameStarted = true;
            setUpButtons();
            Ai.setAiRole(Players.NOBODY);
            Logger.log("Set to 1v1");
        });
        startBtn[0].setBounds(0, 0, size, size / 2);

        startBtn[1].addActionListener(e -> {
            for (int j = 0; j < 4; j++) {
                jf.remove(startBtn[j]);
            }
            gameStarted = true;
            setUpButtons();
            Ai.setAiRole(Players.O);
            Logger.log("Playing X");
        });
        startBtn[1].setBounds(0, size / 2, size / 2, size / 2);
        startBtn[1].setForeground(Color.RED);

        startBtn[2].addActionListener(e -> {
            for (int j = 0; j < 4; j++) {
                jf.remove(startBtn[j]);
            }
            gameStarted = true;
            setUpButtons();
            Ai.setAiRole(Players.X);
            Logger.log("Playing O");
            Ai.yourTurn();
        });
        startBtn[2].setBounds(size / 2, size / 2, size / 2, size / 2);
        startBtn[2].setForeground(Color.BLUE);
    }

    /**
     * Sets up the buttons for the Game
     */
    private static void setUpButtons() {
        for (int i = 0; i < 10; i++) {
            btn[i] = new JButton();
            btn[i].setVisible(true);
            final int fieldID = i;
            btn[i].addActionListener(e -> GameBoard.nextMove(fieldID));
            btn[i].setFocusPainted(false);
            btn[i].setContentAreaFilled(false);
            btn[i].setBorder(null);
            jf.add(btn[i]);
        }

        btn[0].setBounds(0, 0, tile, tile);
        btn[1].setBounds(tile, 0, tile, tile);
        btn[2].setBounds(2 * tile, 0, tile, tile);

        btn[3].setBounds(0, tile, tile, tile);
        btn[4].setBounds(tile, tile, tile, tile);
        btn[5].setBounds(2 * tile, tile, tile, tile);

        btn[6].setBounds(0, 2 * tile, tile, tile);
        btn[7].setBounds(tile, 2 * tile, tile, tile);
        btn[8].setBounds(2 * tile, 2 * tile, tile, tile);
    }

    public static boolean isGameStarted() {
        return gameStarted;
    }
}
