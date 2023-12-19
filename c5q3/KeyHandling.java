import java.awt.*;    
import java.awt.event.*;

import javax.swing.JFrame;    

public class KeyHandling extends KeyAdapter {     
    Label l;    
    TextArea area;    
  
    KeyHandling() {    
        JFrame f = new JFrame("KeyAdapter");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l = new Label();    

        l.setBounds (20, 50, 200, 20);    

        area = new TextArea();  
  
        area.setBounds (20, 80, 300, 300);    
 
        area.addKeyListener(this);    
        f.add(l);  
        f.add(area);    
        f.setSize (400, 400);    
        f.setLayout (null);    
        f.setVisible (true);    
    }    
    
    
    public void keyReleased (KeyEvent e) {    
        String text = area.getText();    
        String words[] = text.split ("\\s");    
        l.setText ("Words: " + words.length + " Characters:" + text.length());    
    }    

    public static void main(String[] args) {    
        new KeyHandling();    
    }    
}    