import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class board implements ActionListener
{
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

    board(int size) {
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

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public int get_board_size() {
        return _board_size;
    }

    public void set_board_size(int _board_size) {
        this._board_size = _board_size;
    }

    public boolean isX_turn() {
        return X_turn;
    }

    public void setX_turn(boolean x_turn) {
        X_turn = x_turn;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getText_panel() {
        return text_panel;
    }

    public void setText_panel(JPanel text_panel) {
        this.text_panel = text_panel;
    }

    public JPanel getButton_panel() {
        return button_panel;
    }

    public void setButton_panel(JPanel button_panel) {
        this.button_panel = button_panel;
    }

    public JPanel getAdditional_panel() {
        return additional_panel;
    }

    public void setAdditional_panel(JPanel additional_panel) {
        this.additional_panel = additional_panel;
    }

    public JButton getReset() {
        return reset;
    }

    public void setReset(JButton reset) {
        this.reset = reset;
    }

    public ArrayList<JButton> getGame_type_buttons() {
        return game_type_buttons;
    }

    public void setGame_type_buttons(ArrayList<JButton> game_type_buttons) {
        this.game_type_buttons = game_type_buttons;
    }

    public JLabel getText_label() {
        return text_label;
    }

    public void setText_label(JLabel text_label) {
        this.text_label = text_label;
    }

    public ArrayList<ArrayList<JButton>> getButtons() {
        return buttons;
    }

    public void setButtons(ArrayList<ArrayList<JButton>> buttons) {
        this.buttons = buttons;
    }
}
