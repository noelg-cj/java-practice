import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class draw2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Drawing App");
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            DrawingPanel dpanel = new DrawingPanel();
            frame.add(dpanel, BorderLayout.CENTER);

            JToggleButton lineButton = new JToggleButton("Line");
            JToggleButton rectangleButton = new JToggleButton("Rectangle");
            JToggleButton ovalButton = new JToggleButton("Oval");

            ButtonGroup buttonGroup = new ButtonGroup();
            buttonGroup.add(lineButton);
            buttonGroup.add(rectangleButton);
            buttonGroup.add(ovalButton);

            JPanel tooPanel = new JPanel();
            tooPanel.add(lineButton);
            tooPanel.add(rectangleButton);
            tooPanel.add(ovalButton);

            frame.add(tooPanel, BorderLayout.NORTH);
            frame.setVisible(true);
        });
    }
}
