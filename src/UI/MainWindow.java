package UI;

import java.awt.*;
import javax.swing.*;

/**
 * Created by ribohe94 on 24/07/16.
 */
public class MainWindow extends JFrame {

    public MainWindow() throws HeadlessException {
        initialSetup(this.getContentPane());
        configurePanel(this.getContentPane());
    }

    public void init() {
        setVisible(true);
    }

    private void initialSetup(Container c) {
        this.setSize(1280, 720);
        this.setTitle("Crea Figuras CMDLine");
        this.setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void configurePanel(Container c) {
        can = new Canvas();
        JScrollPane scrollPane = new JScrollPane(can);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(50, 30, 300, 50);
        c.add(scrollPane);
    }
    /**
     * Mutators
     */

    /**
     * Variables
     */

    Canvas can;
}
