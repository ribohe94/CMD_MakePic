package Control;

import UI.Canvas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ribohe94 on 24/07/16.
 */
public class Control {

    public Control(Canvas can) {
        this.can = can;
    }

    /*public void loop() {
        String cmd = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (!"exit".equals(cmd)) {
            try {
                cmd = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if ("circle".equals(cmd)) {
                can.paintCircle(100, 150, 200, 300);
            }
        }
    }*/

    /**
     * Variables
     */

    Canvas can;

}
