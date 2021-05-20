import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class PlayerVsPlayer extends board {

        private boolean isWin=false;

        PlayerVsPlayer(int size) {
            super(size);
            FirstTurn();
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < get_board_size(); i++) {
            for(int j=0;j<get_board_size();j++) {
                if (e.getSource() == getButtons().get(i).get(j)) {
                    if (getButtons().get(i).get(j).getText() == "") {
                        if (isX_turn() == true) {
                            getText_label().setText("O turn");
                            getButtons().get(i).get(j).setForeground(new Color(196, 24, 64));
                            getButtons().get(i).get(j).setText("X");
                            setX_turn(false);
                            ifWin();
                        } else {
                            getText_label().setText("X turn");
                            getButtons().get(i).get(j).setForeground(new Color(17, 36, 172));
                            getButtons().get(i).get(j).setText("O");
                            setX_turn(true);
                            ifWin();
                        }
                    }
                }
            }
        }
            if(e.getSource() == getReset()){
                Restart();
            }
    }

    public void ifWin() {


        int o_count = 0;
        int x_count = 0;

        for (int i = 0; i < get_board_size(); i++) {


            //Check for a win in horizontal direction
            for (int j = 0; j < get_board_size(); j++) {
                if (getButtons().get(i).get(j).getText() == "O") {
                    o_count++;
                    if (o_count == get_board_size()) {
                        getText_label().setText("O Wins!");
                        isWin = true;
                    }
                } else if (getButtons().get(i).get(j).getText() == "X") {
                    x_count++;
                    if (x_count == get_board_size()) {
                        getText_label().setText("X Wins!");
                        isWin = true;
                    }
                }
            }

            x_count = 0;
            o_count = 0;


            //Check for a win in vertical direction
            for (int j = 0; j < get_board_size(); j++) {
                if (getButtons().get(j).get(i).getText() == "O") {
                    o_count++;
                    if (o_count == get_board_size()) {
                        getText_label().setText("O Wins!");
                        isWin = true;
                    }
                } else if (getButtons().get(j).get(i).getText() == "X") {
                    x_count++;
                    if (x_count == get_board_size()) {
                        getText_label().setText("X Wins!");
                        isWin = true;
                    }
                }
            }

            x_count = 0;
            o_count = 0;


            //Check for a win in a diagonal direction
            for (int j = 0; j < get_board_size(); j++) {
                if (getButtons().get(j).get(j).getText() == "O") {
                    o_count++;
                    if (o_count == get_board_size()) {
                        getText_label().setText("O Wins!");
                        isWin = true;
                    }
                } else if (getButtons().get(j).get(j).getText() == "X") {
                    x_count++;
                    if (x_count == get_board_size()) {
                        getText_label().setText("X Wins!");
                        isWin = true;
                    }
                }
            }

            x_count = 0;
            o_count = 0;

            //Check for a win in a anti-diagonal direction
            int c=0;
            int d=get_board_size()-1;
            while(c < get_board_size()){
                while(d >= 0){
                    if (getButtons().get(c).get(d).getText() == "O") {
                        o_count++;
                        if (o_count == get_board_size()) {
                            getText_label().setText("O Wins!");
                            isWin = true;
                        }
                    } else if (getButtons().get(c).get(d).getText() == "X") {
                        x_count++;
                        if (x_count == get_board_size()) {
                            getText_label().setText("X Wins!");
                            isWin = true;
                        }
                    }

                    c++;
                    d--;
                }
            }


            x_count = 0;
            o_count = 0;

            if (isWin == true) {
                for (int b = 0; b < get_board_size(); b++) {
                    for (int j = 0; j < get_board_size(); j++) {
                        getButtons().get(b).get(j).setEnabled(false);
                    }
                }

            }

        }

    }

    public void FirstTurn()
    {
        Random rand = new Random();
        int randomValue = rand.nextInt() % 2;
        if(randomValue == 0) {
            setX_turn(false);
        }
        else {
            setX_turn(true);
        }
    }


    public void Restart(){
            for(int i=0; i < get_board_size(); i++) {
                for (int j = 0; j < get_board_size(); j++) {
                    getButtons().get(i).get(j).setText("");
                    getButtons().get(i).get(j).setEnabled(true);
                    getButtons().get(i).get(j).setBackground(null);
                    isWin = false;
                }
            }
        getText_label().setText("Tic-Tac-Toe");
    }

    public void Xwins(){




    }

    public void Ywins(){


    }



}
