package UI;

import java.awt.*;
import javax.swing.JFrame;

/**
 * Created by ribohe94 on 24/07/16.
 */
public class mainWindow extends JFrame{

    public mainWindow() throws HeadlessException {
        initialSetup(this.getContentPane());
        configurePanel(this.getContentPane());
    }

    public void init() {
        setVisible(true);
    }

    private void initialSetup(Container c) {
        this.setSize(640, 480);
        this.setTitle("Crea Figuras CMDLine");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void configurePanel(Container c) {
        can = new Canvas();
        c.add(can);
    }

    /**
     * Variables
     */

    Canvas can;
}
