import java.util.*;
import javax.swing.*;

public class swing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Clicker");
        JButton button = new JButton("Click me");
        button.setBounds(130, 100, 100, 40);
        frame.add(button);
        
        JLabel label = new JLabel("");
        button.addActionListener(e ->  {
            label.setText("You have pressed the button!");
        });
        label.setBounds(50, 50, 100, 100);
        frame.add(label);

        frame.setSize(300, 400);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}