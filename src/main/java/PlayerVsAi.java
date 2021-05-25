
/*
This class states for implementing Ai to the program using minimax algorithm
and setting a human player against it
 */

import java.awt.event.ActionEvent;
import java.util.HashMap;

public class PlayerVsAi extends board {

    private final char human = 'O';

    private final char Ai = 'X';

    private static final int INFINITY = 999999;

    private boolean isMaximazing;

    PlayerVsAi(int size,int win_num) {
        super(size, win_num);
        FirstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == getReset()) {
            Restart();
        }
        if (e.getSource() == getGame_type_buttons().get(0)) {
            this.getFrame().dispose();
            new PlayerVsPlayer(get_board_size(),get_win_number());
        }
        if (e.getSource() == getGame_type_buttons().get(1)) {
            this.getFrame().dispose();
            new PlayerVsAi(get_board_size(),get_win_number());
        }
    }

    public int minimax(int depth, boolean isMaximazing) {







        return 0;
    }


}






































