package UI;

import Control.Control;

import java.awt.*;
import javax.swing.*;

/**
 * Created by ribohe94 on 24/07/16.
 */
public class MainWindow extends JFrame{

    public MainWindow() throws HeadlessException {
        con = new Control(can);
        initialSetup(this.getContentPane());
        configurePanel(this.getContentPane());
    }

    public void init() {
        setVisible(true);
    }

    private void initialSetup(Container c) {
        this.setSize(640, 480);
        this.setTitle("Crea Figuras CMDLine");
        this.setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void configurePanel(Container c) {
        can = new Canvas();
        c.add(can);
    }

    /**
     * Mutators
     */

    /**
     * Variables
     */

    Canvas can;
    Control con;
}
