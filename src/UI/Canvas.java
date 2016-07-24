package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Created by ribohe94 on 24/07/16.
 */
public class Canvas extends JPanel {

    public Canvas() {
        this.setBackground(new Color(41,41,41));
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(new Line2D.Double(100, 150, 100, 200));
    }



}
