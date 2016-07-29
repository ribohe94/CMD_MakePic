package Control;

import shapes.Shape;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ribohe94 on 28/07/16.
 */
public enum States implements State {

    Init {
        @Override
        public State next(Input value) {
            if (value.getInput() != null) {
                if("list".equals(value.getArrInput()[0])){
                    return list;
                }
                if ("square".equals(value.getArrInput()[0]) || "circle".equals(value.getArrInput()[0]) ||
                        "rectangle".equals(value.getArrInput()[0]) || "triangle".equals(value.getArrInput()[0]) ||
                        "doughnut".equals(value.getArrInput()[0])) {
                    if(("square".equals(value.getArrInput()[0]) || "circle".equals(value.getArrInput()[0])) &&
                            value.getArrInput().length > 4){
                        return tooManyArg;
                    } else {
                        if(("square".equals(value.getArrInput()[0]) || "circle".equals(value.getArrInput()[0])) &&
                                value.getArrInput().length < 4) {
                            return missingArg;
                        } else {
                            if(("rectangle".equals(value.getArrInput()[0]) || "doughnut".equals(value.getArrInput()[0])) &&
                                    value.getArrInput().length < 5) {
                                return missingArg;
                            } else {
                                if(("rectangle".equals(value.getArrInput()[0]) || "doughnut".equals(value.getArrInput()[0])) &&
                                        value.getArrInput().length > 5) {
                                    return tooManyArg;
                                } else {
                                    if("triangle".equals(value.getArrInput()[0]) &&
                                            value.getArrInput().length > 7) {
                                        return tooManyArg;
                                    } else {
                                        if("triangle".equals(value.getArrInput()[0]) &&
                                                value.getArrInput().length < 7) {
                                            return missingArg;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    return inNum1;
                } else {
                    return alienName;
                }
            }
            return null;
        }
    },
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

                    shapeList.add(sh);
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

                    shapeList.add(sh);
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
                shapeList.add(sh);
                return null;
            } else {
                return notNum;
            }
        }
    },
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
    list {
        @Override
        public State next(Input value) {
            for (int i = 0; i < shapeList.size(); i++) {
                System.out.print("Figura " + i + ": " + shapeList.get(i).getName() + " ");
                for(int j = 0; j < shapeList.get(i).getAttributes().length; j++) {
                    System.out.print(shapeList.get(i).getAttributes()[j] + " ");
                }
                System.out.println("");
            }
            return null;
        }
    };

    /**
     * Variables
     */

    public static int x;
    public static ArrayList<Shape> shapeList = new ArrayList<>();

}
