
/*
This class states for implementing Ai to the program using minimax algorithm
and setting a human player against it
 */






import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Objects;

public class PlayerVsAi extends board {

    private final String Player = "O";

    private final String Ai = "X";

    private static final int INFINITY = 9999999;

    HashMap<String, Integer> hashMap = new HashMap<>();

    PlayerVsAi(int size, int win_num) {
        super(size, win_num);
        FirstTurn();

        hashMap.put("X", 100000);
        hashMap.put("O", -100000);
        hashMap.put("draw", 0);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < get_board_size(); i++) {
                    for (int j = 0; j < get_board_size(); j++) {
                        if (e.getSource() == getButtons().get(i).get(j)) {
                            if (getButtons().get(i).get(j).getText().equals("")) {
                                getButtons().get(i).get(j).setFont(new Font("Ink Free", Font.BOLD, 100));
                                getButtons().get(i).get(j).setForeground(new Color(17, 36, 172));
                                getButtons().get(i).get(j).setText("O");
                                getText_label().setText("Ai turn");
                                if (Objects.equals(ifWin(), Player)) {
                                    setDisable(true, "Player");
                                    break;
                                } else if (Objects.equals(ifWin(), "draw")) {
                                    setDisable(false, "draw");
                                    break;
                                }
                                minimax_move();
                                getText_label().setText("Player turn");
                                if (Objects.equals(ifWin(), Ai)) {
                                    setDisable(true, "Ai");
                                }
                            }
                        }
                    }
                }

        if (e.getSource() == getReset()) {
            Restart();
        }
        if (e.getSource() == getGame_type_buttons().get(0)) {
            this.getFrame().dispose();
            new PlayerVsPlayer(get_board_size(), get_win_number());
        }
        if (e.getSource() == getGame_type_buttons().get(1)) {
            this.getFrame().dispose();
            new PlayerVsAi(get_board_size(), get_win_number());
        }
    }


    public int Calculate_current_state(String sign){
        int count;
        int result=0;

            //Horizontal
            for(int i=0;i<get_board_size();i++){
                count = 0;
                for(int j=0;j<get_board_size();j++){
                    if(getButtons().get(i).get(j).getText().equals(sign))
                        count++;
                }
                if(count != 0)
                    result += count*10;
            }


            //Vertical
            for(int i=0;i<get_board_size();i++){
                count = 0;
                for(int j=0;j<get_board_size();j++){
                    if(getButtons().get(j).get(i).getText().equals(sign))
                        count++;
                }
                if(count != 0)
                    result += count*10;
            }

        count = 0;


            //Diagonal
            for(int j=0;j<get_board_size();j++){
                if(getButtons().get(j).get(j).getText().equals(sign))
                    count++;
            }
                if(count != 0)
                    result += count*10;


            //AntiDiagonal
            for(int i=0; i< get_board_size(); i++) {
                count = 0;
                for (int j = get_board_size() - 1; j >= 0; j--) {
                    if (getButtons().get(i).get(j).getText().equals(sign))
                        count++;
                }
                if(count != 0)
                    result += count*10;
            }

        return result;
    }



    public int minimax(int depth, boolean is_Maximizing, int alpha, int beta) {

        String result = ifWin();

        if (result != null) {
            if(result.equals(Ai))
                return hashMap.get(Ai)-depth;
            else if(result.equals(Player))
                return hashMap.get(Player)+depth;
            else
                return hashMap.get("draw");
        }

        if(depth == 5) {
            if (is_Maximizing)
                return Calculate_current_state(Ai);
            else
                return (-1) * Calculate_current_state(Player);
        }

        int bestResult;

        if (is_Maximizing) {
            bestResult = -INFINITY;
            for (int i = 0; i < get_board_size(); i++) {
                for (int j = 0; j < get_board_size(); j++) {
                    if (getButtons().get(i).get(j).getText().equals("")) {
                        getButtons().get(i).get(j).setText(Ai);
                        int score = minimax(depth + 1, false, alpha,beta);
                        getButtons().get(i).get(j).setText("");
                        bestResult = Math.max(score, bestResult);
                        alpha = Math.max(alpha,bestResult);
                        if(beta <= alpha)
                            break;
                    }
                }
            }
        }
        else {
            bestResult = INFINITY;
            for (int i = 0; i < get_board_size(); i++) {
                for (int j = 0; j < get_board_size(); j++) {
                    if (getButtons().get(i).get(j).getText().equals("")) {
                        getButtons().get(i).get(j).setText(Player);
                        int score = minimax(depth + 1, true,alpha,beta);
                        getButtons().get(i).get(j).setText("");
                        bestResult = Math.min(score, bestResult);
                        beta = Math.min(beta,bestResult);
                        if(beta <= alpha)
                            break;
                    }
                }
            }
        }
        return bestResult;
    }


    public void minimax_move() {
        int bestResult = -INFINITY;
        int[] move = new int[2];


        for (int i = 0; i < get_board_size(); i++) {
            for (int j = 0; j < get_board_size(); j++) {
                if (getButtons().get(i).get(j).getText().equals("")) {
                    getButtons().get(i).get(j).setText(Ai);
                    int score = minimax(0, false,-INFINITY,INFINITY);
                    getButtons().get(i).get(j).setText("");
                    if (score > bestResult) {
                        bestResult = score;
                        move[0] = i;
                        move[1] = j;
                    }
                }
            }
        }
        getButtons().get(move[0]).get(move[1]).setText(Ai);
        getButtons().get(move[0]).get(move[1]).setFont(new Font("Ink Free", Font.BOLD, 100));
        getButtons().get(move[0]).get(move[1]).setForeground(new Color(196, 24, 64));
    }
}




































