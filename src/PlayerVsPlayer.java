import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class PlayerVsPlayer implements ActionListener {

        private int _board_size;
        private boolean X_turn;

        private JFrame frame = new JFrame();
        private JPanel text_panel = new JPanel();
        private JPanel button_panel = new JPanel();

        private JPanel additional_panel = new JPanel();
        private JButton reset = new JButton();
        private ArrayList<JButton> game_type_buttons = new ArrayList<JButton>();

        private JLabel text_label = new JLabel();
        private ArrayList<ArrayList<JButton>> buttons = new ArrayList<>();

        PlayerVsPlayer(int size) {
                _board_size = size;

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(900,900);
                frame.setLayout(new BorderLayout());
                frame.setVisible(true);

                text_label.setForeground(new Color(179, 14, 14));
                text_label.setBackground(new Color(10, 10, 10));
                text_label.setFont(new Font("Ink Free",Font.BOLD,90));
                text_label.setHorizontalAlignment(JLabel.CENTER);
                text_label.setText("Tic-Tac-Toe");
                text_label.setOpaque(true);

                reset.setFont(new Font("Ink Free",Font.BOLD,30));
                reset.setFocusable(true);
                reset.setText("Restart the game!");
                reset.addActionListener(this);

                additional_panel.setLayout(new GridLayout(4,1));
                additional_panel.add(reset);

                for(int i =0;i<3;i++)
                {
                    game_type_buttons.add(new JButton());
                    additional_panel.add(game_type_buttons.get(i));
                    game_type_buttons.get(i).setFont(new Font("Ink Free",Font.BOLD,30));
                    game_type_buttons.get(i).setFocusable(true);
                    game_type_buttons.get(i).addActionListener(this);
                }

                game_type_buttons.get(0).setText("Player Vs Player");
                game_type_buttons.get(1).setText("Player Vs Ai");
                game_type_buttons.get(2).setText("Ai Vs Ai");

                text_panel.setLayout(new BorderLayout());
                button_panel.setLayout(new GridLayout(_board_size,_board_size));

                for(int i=0;i < _board_size;i++)
                    buttons.add(new ArrayList());

                for(int i=0; i< _board_size; i++) {
                    for(int j=0;j<_board_size;j++) {
                        buttons.get(i).add(new JButton());
                        button_panel.add(buttons.get(i).get(j));
                        buttons.get(i).get(j).setFont(new Font("Ink Free", Font.BOLD, 120));
                        buttons.get(i).get(j).setFocusable(true);
                        buttons.get(i).get(j).addActionListener(this);
                    }
                }

                text_panel.add(text_label);
                frame.add(text_panel,BorderLayout.NORTH);
                frame.add(additional_panel, BorderLayout.EAST);
                frame.add(button_panel);

                FirstTurn();

        }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < _board_size; i++) {
            for(int j=0;j<_board_size;j++) {
                if (e.getSource() == buttons.get(i).get(j)) {
                    if (buttons.get(i).get(j).getText() == "") {
                        if (X_turn == true) {
                            text_label.setText("O turn");
                            buttons.get(i).get(j).setForeground(new Color(17, 36, 172));
                            buttons.get(i).get(j).setText("X");
                            X_turn = false;
                            ifWin();
                        } else {
                            text_label.setText("X turn");
                            buttons.get(i).get(j).setForeground(new Color(17, 36, 172));
                            buttons.get(i).get(j).setText("O");
                            X_turn = true;
                            ifWin();
                        }
                    }
                }
            }
        }
            if(e.getSource() == reset){
                Restart();
            }
    }

    public void ifWin()
        {
            int[][] tmp_array = new int[_board_size][_board_size];

            for(int i=0;i<_board_size;i++){
                for(int j=0; j< _board_size; j++){
                    if(buttons.get(i).get(j).getText() == "O") {
                        tmp_array[i][j] = 0;
                    }

                    else if(buttons.get(i).get(j).getText() == "X"){
                        tmp_array[i][j] = 1;
                    }
                }
            }
         }



    public void FirstTurn()
    {
        Random rand = new Random();
        int randomValue = rand.nextInt() % 2;
        if(randomValue == 0) {
            X_turn = false;
        }
        else {
            X_turn = true;
        }
    }

    public void Restart(){
            for(int i=0; i < _board_size; i++) {
                for (int j = 0; j < _board_size; j++) {
                    buttons.get(i).get(j).setText("");
                    buttons.get(i).get(j).setBackground(null);
                }
            }
        text_label.setText("Tic-Tac-Toe");
    }

    public void Xwins(){




    }

    public void Ywins(){


    }



}
