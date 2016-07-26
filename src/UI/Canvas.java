package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ribohe94 on 24/07/16.
 */
public class Canvas extends JPanel {

    public Canvas() {
        this.setBackground(new Color(40, 40, 40));
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2 = (Graphics2D) g;
        paintCircle(100, 150, 200, 300);
        paintRectangle(100, 150, 200, 300);
        String cmd = "";
        try {
            cmd = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if ("circle".equals(cmd)) {
            paintCircle(100, 150, 200, 300);
        } else {
            if ("rectangle".equals(cmd)) {
                paintRectangle(100, 150, 200, 300);
            }
        }


    }

    public void paintCircle(int posX, int posY, int width, int height) {
        g2.draw(new Ellipse2D.Double(posX, posY, width, height));
    }

    public void paintRectangle(int posX, int posY, int width, int height) {
        g2.draw(new Rectangle2D.Double(posX, posY, width, height));
    }

    Graphics2D g2;
    BufferedReader br;

}
