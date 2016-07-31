package model;

/**
 * Created by ribohe94 on 30/07/16.
 */
public enum Alphabet {

    square(4),
    rectangle(5),
    doughnut(5),
    triangle(7),
    circle(4),
    list(1);

    Alphabet(int arguments) {
        this.arguments = arguments;
    }

    public static Alphabet getExression(String arg) {
        for(Alphabet al : Alphabet.values()) {
            if(al.toString().equals(arg)) {
                return al;
            }
        }
        return null;
    }

    public int getArguments() {
        return arguments;
    }

    private int arguments;
}
