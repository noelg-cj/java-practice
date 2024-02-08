import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class radiobutton extends JFrame implements ActionListener {
    JFrame f;
    JRadioButton rb1, rb2;

    radiobutton() {
        f = new JFrame("Gender checker");
        rb1 = new JRadioButton("Male");
        rb2 = new JRadioButton("Female");
        rb1.setBounds(100, 100, 100, 20);
        rb2.setBounds(100, 130, 100, 20);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        f.add(rb1);
        f.add(rb2);

        JButton button = new JButton("Check Gender");
        button.addActionListener(this);
        button.setBounds(100, 180, 150, 30);
        f.add(button);

        f.setLayout(null);
        f.setSize(500, 500);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (rb1.isSelected()) {
            JOptionPane.showMessageDialog(this, "You are a male");
        }
        else {
            JOptionPane.showMessageDialog(this, "You are a female");
        }
    }

    public static void main(String[] args) {
        new radiobutton();
    }
}