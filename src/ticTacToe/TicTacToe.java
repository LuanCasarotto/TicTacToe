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
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(new Color(25,25,25));
        textField.setForeground(new Color(25,255,0));
        textField.setFont(new Font("Ink Free", Font.BOLD,75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0,0,800,100);

        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(new Color(150,150,150));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD,120));
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
                if (player1Turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1Turn = false;
                        textField.setText("O Turn");
                        check();
                    }
                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        player1Turn = true;
                        textField.setText("X Turn");
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (randomFirstPlay.nextInt(2) == 0) {
            player1Turn = true;
            textField.setText("X Turn");
        } else {
            player1Turn = false;
            textField.setText("O Turn");
        }
    }

    public void check() {
        // check X win conditions
        if ((buttons[0].getText().equals("X"))
                && (buttons[1].getText().equals("X"))
                && (buttons[2].getText().equals("X"))
        ) xWins(0,1,2);
        if ((buttons[3].getText().equals("X"))
                && (buttons[4].getText().equals("X"))
                && (buttons[5].getText().equals("X"))
        ) xWins(3,4,5);
        if ((buttons[6].getText().equals("X"))
                && (buttons[7].getText().equals("X"))
                && (buttons[8].getText().equals("X"))
        ) xWins(6,7,8);
        if ((buttons[0].getText().equals("X"))
                && (buttons[3].getText().equals("X"))
                && (buttons[6].getText().equals("X"))
        ) xWins(0,3,6);
        if ((buttons[1].getText().equals("X"))
                && (buttons[4].getText().equals("X"))
                && (buttons[7].getText().equals("X"))
        ) xWins(1,4,7);
        if ((buttons[2].getText().equals("X"))
                && (buttons[5].getText().equals("X"))
                && (buttons[8].getText().equals("X"))
        ) xWins(2,5,8);
        if ((buttons[0].getText().equals("X"))
                && (buttons[4].getText().equals("X"))
                && (buttons[8].getText().equals("X"))
        ) xWins(0,4,8);
        if ((buttons[2].getText().equals("X"))
                && (buttons[4].getText().equals("X"))
                && (buttons[6].getText().equals("X"))
        ) xWins(2,4,6);

        // check O win conditions
        if ((buttons[0].getText().equals("O"))
                && (buttons[1].getText().equals("O"))
                && (buttons[2].getText().equals("O"))
        ) oWins(0,1,2);
        if ((buttons[3].getText().equals("O"))
                && (buttons[4].getText().equals("O"))
                && (buttons[5].getText().equals("O"))
        ) oWins(3,4,5);
        if ((buttons[6].getText().equals("O"))
                && (buttons[7].getText().equals("O"))
                && (buttons[8].getText().equals("O"))
        ) oWins(6,7,8);
        if ((buttons[0].getText().equals("O"))
                && (buttons[3].getText().equals("O"))
                && (buttons[6].getText().equals("O"))
        ) oWins(0,3,6);
        if ((buttons[1].getText().equals("O"))
                && (buttons[4].getText().equals("O"))
                && (buttons[7].getText().equals("O"))
        ) oWins(1,4,7);
        if ((buttons[2].getText().equals("O"))
                && (buttons[5].getText().equals("O"))
                && (buttons[8].getText().equals("O"))
        ) oWins(2,5,8);
        if ((buttons[0].getText().equals("O"))
                && (buttons[4].getText().equals("O"))
                && (buttons[8].getText().equals("O"))
        ) oWins(0,4,8);
        if ((buttons[2].getText().equals("O"))
                && (buttons[4].getText().equals("O"))
                && (buttons[6].getText().equals("O"))
        ) oWins(2,4,6);

    }

    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textField.setText("X WINS");
    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textField.setText("O WINS");
    }
}
