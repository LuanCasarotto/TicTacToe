package ticTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {

    Random randomFirstPlay = new Random();
    JFrame frame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];

    boolean player1Turn;

    TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(25, 255, 0));
        textField.setFont(new Font("Ink Free", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 800, 100);

        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        titlePanel.add(textField);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (buttons[i].getText().equals("")) {
                    if (player1Turn) {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1Turn = false;
                        textField.setText("O Turn");
                    } else {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player1Turn = true;
                        textField.setText("X Turn");
                    }
                }
            }
        }
        check("X");
        check("O");
    }

    public void firstTurn() {
        if (randomFirstPlay.nextInt(2) == 0) {
            player1Turn = true;
            textField.setText("X Turn");
        } else {
            player1Turn = false;
            textField.setText("O Turn");
        }
    }

    public void check(String symbol) {
        checkLines(symbol);
        checkColumns(symbol);
        checkDiagonal(symbol);
    }

    public void checkLines(String symbol) {
        for (int j = 0; j < 7; j += 3) {
            if ((buttons[j].getText().equals(symbol))
                    && (buttons[j + 1].getText().equals(symbol))
                    && (buttons[j + 2].getText().equals(symbol))
            ) Win(j, j + 1, j + 2, symbol);
        }
    }

    public void checkColumns(String symbol) {
        for (int j = 0; j < 3; j++) {
            if ((buttons[j].getText().equals(symbol))
                    && (buttons[j + 3].getText().equals(symbol))
                    && (buttons[j + 6].getText().equals(symbol))
            ) Win(j, j + 3, j + 6, symbol);
        }
    }

    public void checkDiagonal(String symbol) {
        if ((buttons[0].getText().equals(symbol))
                && (buttons[4].getText().equals(symbol))
                && (buttons[8].getText().equals(symbol))
        ) Win(0, 4, 8, symbol);
        if ((buttons[2].getText().equals(symbol))
                && (buttons[4].getText().equals(symbol))
                && (buttons[6].getText().equals(symbol))
        ) Win(2, 4, 6, symbol);
    }

    public void Win(int a, int b, int c, String symbol) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }

        textField.setText(symbol.equals("X") ? "X WINS" : "O WINS");
    }
}
