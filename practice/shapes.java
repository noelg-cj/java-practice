import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.*;
import java.util.*;

class DrawingPanel extends JPanel {
    public ArrayList<Shape> shapes = new ArrayList<>();
    private Shape currentShape;

    public DrawingPanel() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (currentShape == null) {
                    return;
                }

                currentShape.setStartPoint(e.getPoint());
                shapes.add(currentShape);
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (currentShape != null) {
                    currentShape.setEndPoint(e.getPoint());
                    repaint();
                }
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (currentShape != null) {
                    currentShape.setEndPoint(e.getPoint());
                    repaint();
                }
            }
        });
    }

    public void setCurrentShape(Shape shape) {
        this.currentShape = shape;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Shape shape : shapes) {
            shape.draw(g);
        } 

        if (currentShape != null) {
            currentShape.draw(g);
        }
    }
}

abstract class Shape {
    protected Point startPoint;
    protected Point endPoint;

    public void setStartPoint(Point starPoint) {
        this.startPoint = starPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    public abstract void draw(Graphics g);
}

class Line extends Shape {
    @Override
    public void draw(Graphics g) {
        if (startPoint != null && endPoint != null) {
            g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
        }
    }
}

class Rectangle extends Shape {
    @Override
    public void draw(Graphics g) {
        if (startPoint != null && endPoint != null) {
            int width = Math.abs(endPoint.x - startPoint.x);
            int height = Math.abs(endPoint.y - startPoint.y);
            int x = Math.min(startPoint.x, endPoint.x);
            int y = Math.min(startPoint.y, endPoint.y);
            g.drawRect(x, y, width, height);
        }
    }
}

class Oval extends Shape {
    @Override
    public void draw(Graphics g) {
        int width = Math.abs(endPoint.x - startPoint.x);
        int height = Math.abs(endPoint.y - startPoint.y);
        int x = Math.min(startPoint.x, endPoint.x);
        int y = Math.min(startPoint.y, endPoint.y);
        g.drawOval(x, y, width, height);
    }
}

public class shapes {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Draw");
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            DrawingPanel drawingPanel = new DrawingPanel();
            frame.add(drawingPanel, BorderLayout.CENTER);

            JToggleButton b1 = new JToggleButton("Line");
            JToggleButton b2 = new JToggleButton("Rectangle");
            JToggleButton b3 = new JToggleButton("Oval");

            ButtonGroup buttonGroup = new ButtonGroup();
            buttonGroup.add(b1);
            buttonGroup.add(b2);
            buttonGroup.add(b3);

            b1.addActionListener(e -> drawingPanel.setCurrentShape(new Line()));
            b2.addActionListener(e -> drawingPanel.setCurrentShape(new Rectangle()));
            b3.addActionListener(e -> drawingPanel.setCurrentShape(new Oval()));

            JPanel toolPanel = new JPanel();
            toolPanel.add(b1);
            toolPanel.add(b2);
            toolPanel.add(b3);

            frame.add(toolPanel, BorderLayout.NORTH);
            frame.setVisible(true);
        });
    }
}