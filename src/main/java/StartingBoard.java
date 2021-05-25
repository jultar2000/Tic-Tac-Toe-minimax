
/*
This class states for implementing the starting board for the user, where
he can pass the winning number and the size of the board
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartingBoard implements ActionListener {

    private final JFrame frame = new JFrame();
    private final JButton button_one;
    private final JTextField textField_one;
    private final JTextField textField_two;

    StartingBoard() {

        button_one = new JButton("Submit Values and start the game!");

        textField_one = new JTextField();
        textField_two = new JTextField();


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 1));


        textField_one.setPreferredSize(new Dimension(280, 40));
        textField_two.setPreferredSize(new Dimension(280, 40));

        textField_one.setForeground(new Color(0, 0, 0));
        textField_one.setBackground(new Color(17, 220, 48));

        textField_two.setForeground(new Color(0, 0, 0));
        textField_two.setBackground(new Color(17, 220, 48));

        textField_one.setText("Pass here board size (integer number)");
        textField_two.setText("Pass here winning number in a row (integer number)");

        button_one.addActionListener(this);
        button_one.setBackground(new Color(227, 41, 50));
        button_one.setFocusable(true);
        button_one.setFocusPainted(false);

        frame.add(textField_one);
        frame.add(textField_two);
        frame.add(button_one);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button_one) {
            int size = Integer.parseInt(textField_one.getText().trim());
            int winning_num = Integer.parseInt(textField_two.getText().trim());

            if (winning_num > size) {
                JOptionPane.showMessageDialog(null, "Size of the board must be higher than winning number!\n Change numbers!", "Error!", JOptionPane.WARNING_MESSAGE);
            }
            else {
                this.frame.dispose();
                new board(size, winning_num);

            }

        }
    }
}