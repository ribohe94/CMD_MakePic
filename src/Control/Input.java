package Control;

/**
 * Created by ribohe94 on 28/07/16.
 */
public class Input {

    public Input(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public String[] getArrInput() {
        return input.split(" ");
    }

    /**
     * Variables
     */
    private String input;
    private int current;

}
