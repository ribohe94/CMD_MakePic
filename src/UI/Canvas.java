package UI;

import Control.ReadWrite;
import Control.States;
import model.Alphabet;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by ribohe94 on 24/07/16.
 */
public class Canvas extends JPanel {

    public Canvas() {
        this.setBackground(new Color(40, 40, 40));
        shapeList = States.shapeList;
        br = new BufferedReader(new InputStreamReader(System.in));
        s = States.Init;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2 = (Graphics2D) g;
        g2.setPaint(Color.white);
        shapeList.clear();
        String cmd = "";
        try {
            cmd = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(cmd.trim().equals("exit")) {
            System.exit(0);
        }

        ReadWrite.loadFile("input.txt", s);
        ReadWrite.writeFile("input.txt", cmd, s);

        repaint();

        for (int i = 0; i < shapeList.size(); i++) {
            if (Alphabet.circle.toString().equals(shapeList.get(i).getName())) {
                paintCircle(shapeList.get(i).getAttributes()[0], shapeList.get(i).getAttributes()[1], shapeList.get(i).getAttributes()[2]);
            } else {
                if (Alphabet.square.toString().equals(shapeList.get(i).getName())) {
                    paintSquare(shapeList.get(i).getAttributes()[0], shapeList.get(i).getAttributes()[1], shapeList.get(i).getAttributes()[2]);
                } else {
                    if (Alphabet.rectangle.toString().equals(shapeList.get(i).getName())) {
                        paintRectangle(shapeList.get(i).getAttributes()[0], shapeList.get(i).getAttributes()[1], shapeList.get(i).getAttributes()[2], shapeList.get(i).getAttributes()[3]);
                    } else {
                        if (Alphabet.triangle.toString().equals(shapeList.get(i).getName())) {
                            paintTriangle((int) shapeList.get(i).getAttributes()[0], (int) shapeList.get(i).getAttributes()[1], (int) shapeList.get(i).getAttributes()[2],
                                    (int) shapeList.get(i).getAttributes()[3], (int) shapeList.get(i).getAttributes()[4], (int) shapeList.get(i).getAttributes()[5], g);
                        } else {
                            if (Alphabet.doughnut.toString().equals(shapeList.get(i).getName())) {
                                paintDoughnut(shapeList.get(i).getAttributes()[0], shapeList.get(i).getAttributes()[1], shapeList.get(i).getAttributes()[2], shapeList.get(i).getAttributes()[3]);
                            }
                        }
                    }
                }
            }
        }
    }

    public void paintCircle(double posX, double posY, double radius) {
        g2.draw(new Ellipse2D.Double(posX, posY, radius, radius));
    }

    public void paintSquare(double posX, double posY, double side) {
        g2.draw(new Rectangle2D.Double(posX, posY, side, side));
    }

    public void paintTriangle(int posX1, int posY1, int posX2, int posY2, int posX3, int posY3, Graphics g) {
        int xpoints[] = {posX1, posX2, posX3};
        int ypoints[] = {posY1, posY2, posY3};
        g.drawPolygon(xpoints, ypoints, 3);
    }

    public void paintRectangle(double posX, double posY, double width, double height) {
        g2.draw(new Rectangle2D.Double(posX, posY, width, height));
    }

    public void paintDoughnut(double posX, double posY, double minorR, double mayorR) {
        Area donut = new Area(new Ellipse2D.Double(posX, posY, mayorR, mayorR));
        Area hole = new Area(new Ellipse2D.Double((posX + (mayorR / 2)) - (minorR / 2), (posY + (mayorR / 2)) - (minorR / 2), minorR, minorR));
        donut.subtract(hole);
        g2.fill(donut);
    }

    /**
     * Variables
     */

    private Graphics2D g2;
    private ArrayList<model.Shape> shapeList;
    BufferedReader br;
    States s;
}
