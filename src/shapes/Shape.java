package shapes;

/**
 * Created by ribohe94 on 29/07/16.
 */
public class Shape {

    public Shape(String name, double[] attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public double[] getAttributes() {
        return attributes;
    }

    private String name;
    private double[] attributes;
}
