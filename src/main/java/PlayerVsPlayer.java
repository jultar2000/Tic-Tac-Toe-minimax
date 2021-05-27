
/*
This class states for implementing normal tic-tac-toe game where one user
can play agaist another
 */

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class PlayerVsPlayer extends board {

        PlayerVsPlayer(int size,int win_num) {
            super(size,win_num);
            FirstTurn();
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < get_board_size(); i++) {
            for(int j=0;j<get_board_size();j++) {
                if (e.getSource() == getButtons().get(i).get(j)) {
                    if (getButtons().get(i).get(j).getText().equals("")) {
                        if (isX_turn() == true) {
                            getText_label().setText("O turn");
                            getButtons().get(i).get(j).setForeground(new Color(196, 24, 64));
                            getButtons().get(i).get(j).setText("X");
                            setX_turn(false);
                            String result = ifWin();
                            if(result == "X")
                                setDisable(true,"X");
                            else if(result == "draw")
                                setDisable(false,"Draw");
                        } else {
                            getText_label().setText("X turn");
                            getButtons().get(i).get(j).setForeground(new Color(17, 36, 172));
                            getButtons().get(i).get(j).setText("O");
                            setX_turn(true);
                            String result = ifWin();
                            if(result == "O")
                                setDisable(true,"O");
                            else if(result == "draw")
                                setDisable(false,"Draw");
                        }
                    }
                }
            }
        }

            if(e.getSource() == getReset()){
                Restart();
            }
        if(e.getSource() == getGame_type_buttons().get(0)) {
            this.getFrame().dispose();
            new PlayerVsPlayer(get_board_size(), get_win_number());
        }
        if(e.getSource() == getGame_type_buttons().get(1)) {
            this.getFrame().dispose();
            new PlayerVsAi(get_board_size(), get_win_number());
        }
    }
}
