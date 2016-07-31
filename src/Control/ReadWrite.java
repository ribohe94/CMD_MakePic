package Control;

import java.io.*;

/**
 * Created by ribohe94 on 28/07/16.
 */
public class ReadWrite {

    public static void writeFile(String filename, String text, State s) {
        if(text.trim().equals("list")) {
            loadCommand(text.trim(), s);
            return;
        }

        if (!text.equals("")) {
            PrintWriter printWriter = null;
            try {
                printWriter = new PrintWriter(new FileOutputStream(new File(filename), true));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            printWriter.println(text);
            printWriter.close();
        }
    }

    public static void loadFile(String filename, State s) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            Input in;
            while (line != null) {
                in = new Input(line);
                s = States.Init;
                while(s != null) {
                    s = s.next(in);
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    public static void loadCommand(String cmd, State s) {
        s = States.Init;
        while(s != null) {
            s = s.next(new Input(cmd));
        }
    }


    /**
     *
     */

}
