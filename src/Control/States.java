package Control;

import model.Alphabet;
import model.Shape;

import java.util.ArrayList;

/**
 * Created by ribohe94 on 28/07/16.
 */
public enum States implements State {

    Init {
        @Override
        public State next(Input value) {
            if (value.getInput() != null) {
                if (Alphabet.list.toString().equals(value.getArrInput()[0])) {
                    return list;
                }
                /**
                 * Loops through {@link Alphabet} to verify the command is present
                 */
                boolean isInAlphabet = false;
                for (Alphabet al : Alphabet.values()) {
                    if (al.toString().equals(value.getArrInput()[0])) {
                        isInAlphabet = true;
                    }
                }
                /**
                 * If word is in alphabet, then it checks how many arguments it is receiving
                 */
                if (isInAlphabet) {

                    if (Alphabet.getExression(value.getArrInput()[0]).getArguments() < value.getArrInput().length) {
                        return tooManyArg;
                    } else {
                        if (Alphabet.getExression(value.getArrInput()[0]).getArguments() > value.getArrInput().length) {
                            return missingArg;
                        } else {
                            return inNum1;
                        }
                    }
                } else {
                    return alienName;
                }
            }
            return null;
        }
    },
    /**
     * It goes through each parameter to check it is actually an {@link Integer}
     */
    inNum1 {
        @Override
        public State next(Input value) {
            if (ReadWrite.isInt(value.getArrInput()[1])) {
                return inNum2;
            } else {
                return notNum;
            }
        }
    },
    inNum2 {
        @Override
        public State next(Input value) {
            if (ReadWrite.isInt(value.getArrInput()[2])) {
                return inNum3;
            } else {
                return notNum;
            }
        }
    },
    inNum3 {
        @Override
        public State next(Input value) {
            if (ReadWrite.isInt(value.getArrInput()[3])) {
                if ("circle".equals(value.getArrInput()[0]) || "square".equals(value.getArrInput()[0])) {
                    double[] array = {Double.parseDouble(value.getArrInput()[1]), Double.parseDouble(value.getArrInput()[2]),
                            Double.parseDouble(value.getArrInput()[3])};
                    Shape sh = new Shape(value.getArrInput()[0], array);

                    if (!isDuplicate(sh)) {
                        shapeList.add(sh);
                    } else {
                        return null;
                    }
                    return null;
                }
                return inNum4;
            } else {
                return notNum;
            }
        }
    },
    inNum4 {
        @Override
        public State next(Input value) {
            if (ReadWrite.isInt(value.getArrInput()[4])) {
                if ("rectangle".equals(value.getArrInput()[0]) || "doughnut".equals(value.getArrInput()[0])) {
                    double[] array = {Double.parseDouble(value.getArrInput()[1]), Double.parseDouble(value.getArrInput()[2]),
                            Double.parseDouble(value.getArrInput()[3]), Double.parseDouble(value.getArrInput()[4])};
                    Shape sh = new Shape(value.getArrInput()[0], array);

                    if (!isDuplicate(sh)) {
                        shapeList.add(sh);
                    } else {
                        return null;
                    }
                    return null;
                }
                return inNum5;
            } else {
                return notNum;
            }
        }
    },
    inNum5 {
        @Override
        public State next(Input value) {
            if (ReadWrite.isInt(value.getArrInput()[5])) {
                return inNum6;
            } else {
                return notNum;
            }
        }
    },
    inNum6 {
        @Override
        public State next(Input value) {
            if (ReadWrite.isInt(value.getArrInput()[6])) {
                double[] array = {Double.parseDouble(value.getArrInput()[1]), Double.parseDouble(value.getArrInput()[2]),
                        Double.parseDouble(value.getArrInput()[3]), Double.parseDouble(value.getArrInput()[4]),
                        Double.parseDouble(value.getArrInput()[5]), Double.parseDouble(value.getArrInput()[6])};
                Shape sh = new Shape(value.getArrInput()[0], array);
                if (!isDuplicate(sh)) {
                    shapeList.add(sh);
                } else {
                    return null;
                }
                return null;
            } else {
                return notNum;
            }
        }
    },
    /**
     * Error States
     */
    missingArg {
        @Override
        public State next(Input value) {
            System.err.println("ERROR: Missing arguments");
            return null;
        }
    },
    tooManyArg {
        @Override
        public State next(Input value) {
            System.err.println("ERROR: too many arguments");
            return null;
        }
    },
    alienName {
        @Override
        public State next(Input value) {
            System.err.println("ERROR: Unrecognized name");
            return null;
        }
    },
    notNum {
        @Override
        public State next(Input value) {
            System.err.println("ERROR: Value is not a number");
            return null;
        }
    },
    /**
     * Other commands
     */
    list {
        @Override
        public State next(Input value) {
            for (int i = 0; i < shapeList.size(); i++) {
                System.out.print("Figura " + i + ": " + shapeList.get(i).getName() + " ");
                for (int j = 0; j < shapeList.get(i).getAttributes().length; j++) {
                    System.out.print(shapeList.get(i).getAttributes()[j] + " ");
                }
                System.out.println("");
            }
            return null;
        }
    };

    private static boolean isDuplicate(Shape sh) {
        for (Shape shape : shapeList) {
            if (shape.getName().equals(sh.getName()) && shape.getAttributes().equals(sh.getAttributes())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Variables
     */

    public static ArrayList<Shape> shapeList = new ArrayList<>();

}
