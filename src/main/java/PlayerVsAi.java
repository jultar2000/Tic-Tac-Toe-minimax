import java.awt.event.ActionEvent;
import java.util.HashMap;

public class PlayerVsAi extends board {

    private final char human = 'O';

    private final char Ai = 'X';

    private static final int INFINITY = 999999;

    private boolean isMaximazing;

    PlayerVsAi(int size) {
        super(size);
        FirstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == getReset()) {
            Restart();
        }
        if (e.getSource() == getGame_type_buttons().get(0)) {
            this.getFrame().dispose();
            new PlayerVsPlayer(get_board_size());
        }
        if (e.getSource() == getGame_type_buttons().get(1)) {
            this.getFrame().dispose();
            new PlayerVsAi(get_board_size());
        }
    }

    public int minimax(int depth, boolean isMaximazing) {







        return 0;
    }


}






































