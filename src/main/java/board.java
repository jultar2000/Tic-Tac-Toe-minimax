
/*
This class states for implementing the board of tic-tac-toe game
It also contains some functions to define state of the game or reset the game
 */

import lombok.Getter;
import lombok.Setter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

@Getter
@Setter
public class board implements ActionListener
{

    private int _board_size;
    private boolean X_turn;
    private int _win_number;

    private JFrame frame = new JFrame();
    private JPanel text_panel = new JPanel();
    private JPanel button_panel = new JPanel();

    private JPanel additional_panel = new JPanel();
    private JButton reset = new JButton();
    private ArrayList<JButton> game_type_buttons = new ArrayList<>();

    private JLabel text_label = new JLabel();
    private ArrayList<ArrayList<JButton>> buttons = new ArrayList<>();

    board(int size,int win_num) {
        _board_size = size;
        _win_number = win_num;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,900);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        text_label.setForeground(new Color(179, 14, 14));
        text_label.setBackground(new Color(5, 5, 5));
        text_label.setFont(new Font("Ink Free",Font.BOLD,90));
        text_label.setHorizontalAlignment(JLabel.CENTER);
        text_label.setText("Tic-Tac-Toe");
        text_label.setOpaque(true);

        reset.setFont(new Font("Ink Free",Font.BOLD,30));
        reset.setFocusable(true);
        reset.setText("Restart the game!");
        reset.setBackground(new Color(173, 116, 68));
        reset.setForeground(new Color(12,12,12));
        reset.addActionListener(this);

        additional_panel.setLayout(new GridLayout(3,1));
        additional_panel.add(reset);

        for(int i =0;i<2;i++)
        {
            game_type_buttons.add(new JButton());
            additional_panel.add(game_type_buttons.get(i));
            game_type_buttons.get(i).setFont(new Font("Ink Free",Font.BOLD,30));
            game_type_buttons.get(i).setBackground(new Color(173, 116, 68));
            game_type_buttons.get(i).setForeground(new Color(12,12,12));
            game_type_buttons.get(i).setFocusable(true);
            game_type_buttons.get(i).addActionListener(this);
        }

        game_type_buttons.get(0).setText("Player Vs Player");
        game_type_buttons.get(1).setText("Player Vs Ai");

        text_panel.setLayout(new BorderLayout());
        button_panel.setLayout(new GridLayout(_board_size,_board_size));

        for(int i=0;i < _board_size;i++)
            buttons.add(new ArrayList<>());

        for(int i=0; i< _board_size; i++) {
            for(int j=0;j<_board_size;j++) {
                buttons.get(i).add(new JButton());
                button_panel.add(buttons.get(i).get(j));
                buttons.get(i).get(j).setFont(new Font("Ink Free", Font.BOLD, 100));
                buttons.get(i).get(j).setFocusable(true);
                buttons.get(i).get(j).addActionListener(this);
            }
        }

        text_panel.add(text_label);
        frame.add(text_panel,BorderLayout.NORTH);
        frame.add(additional_panel, BorderLayout.EAST);
        frame.add(button_panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == game_type_buttons.get(0)) {
            this.frame.dispose();
            new PlayerVsPlayer(_board_size,_win_number);
        }

        else if(e.getSource() == game_type_buttons.get(1)) {
            this.frame.dispose();
            new PlayerVsAi(_board_size,_win_number);
        }
    }


    //Function defining if there is a win on the board
    public String ifWin() {

        int x_count = 0;
        int o_count = 0;

        for (int i = 0; i < _board_size; i++) {

            //Check for a win in horizontal direction
            for (int j = 0; j < _board_size; j++) {
                if (buttons.get(i).get(j).getText().equals("X")) {
                    x_count++;
                    if (x_count == _win_number) return "X";
                }
                else x_count=0;


                if (buttons.get(i).get(j).getText().equals("O")) {
                    o_count++;
                    if (o_count == _win_number) return "O";
                }
                else o_count=0;
            }

            x_count = 0;
            o_count = 0;

            //Check for a win in vertical direction
            for (int j = 0; j < _board_size; j++) {
                if (buttons.get(j).get(i).getText().equals("X")) {
                    x_count++;
                    if (x_count == _win_number) return "X";
                }
                else x_count=0;

                if (buttons.get(j).get(i).getText().equals("O")) {
                    o_count++;
                    if (o_count == _win_number) return "O";
                }
                else o_count=0;
            }

            x_count = 0;
            o_count = 0;

            //Check for a win in a diagonal direction
            for (int j = 0; j < _board_size; j++) {
                if (buttons.get(j).get(j).getText().equals("X")) {
                    x_count++;
                    if (x_count == _win_number) return "X";
                }
                else x_count=0;

                if (buttons.get(j).get(j).getText().equals("O")) {
                    o_count++;
                    if (o_count == _win_number) return "O";
                }
                else o_count=0;
            }

            x_count = 0;
            o_count = 0;

            //Check for a win in a anti-diagonal direction
            int c = 0;
            int d = _board_size - 1;
            while (c < _board_size) {
                while (d >= 0) {
                    if (buttons.get(c).get(d).getText().equals("X")) {
                        x_count++;
                        if (x_count == _win_number) return "X";
                    }
                    else x_count=0;

                    if (buttons.get(c).get(d).getText().equals("O")) {
                        o_count++;
                        if (o_count == _win_number) return "O";
                    }
                    else o_count=0;

                    c++;
                    d--;
                }
            }
            x_count = 0;
            o_count = 0;
        }

        int count_three = 0;


        //Function defining if its a draw
        for (int i = 0; i < _board_size; i++) {
            for (int j = 0; j < _board_size; j++) {
                if (buttons.get(i).get(j).getText().equals("X") || buttons.get(i).get(j).getText().equals("O"))
                    count_three ++;
            }
        }
        if (count_three  == _board_size * _board_size) {
            text_label.setText("It's a Draw!");
            return "draw";
        }

        return null;

    }


    //Function disabling all buttons
    public void setDisable(boolean win,String sign){

            for (int b = 0; b < _board_size; b++) {
                for (int j = 0; j < _board_size; j++) {
                    buttons.get(b).get(j).setEnabled(false);
                }
            }
            if(win)
                text_label.setText(sign + " Wins!");
            else
                text_label.setText("It's a " + sign + "!");
    }



    //Functions defining who's the first turn of a players
    public void FirstTurn() {
        Random rand = new Random();
        int randomValue = rand.nextInt() % 2;
        X_turn = randomValue != 0;
    }

    //Function restarting board and buttons
    public void Restart(){
        for(int i=0; i < _board_size; i++) {
            for (int j = 0; j < _board_size; j++) {
                buttons.get(i).get(j).setText("");
                buttons.get(i).get(j).setEnabled(true);
                buttons.get(i).get(j).setBackground(null);
            }
        }
        text_label.setText("Tic-Tac-Toe");
    }





}
