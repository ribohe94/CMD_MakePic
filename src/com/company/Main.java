package com.company;

import Control.Input;
import Control.ReadWrite;
import Control.State;
import Control.States;
import UI.MainWindow;
import shapes.Shape;

public class Main {

    public static void main(String[] args) {

        /*double[] array = {100,200,300};

        Shape sh = new Shape("circle", array);*/

        //System.out.println(in.getArrInput()[4]);

        //System.out.println(ReadWrite.isInt("1542"));

        MainWindow mw = new MainWindow();
        mw.init();

        /*Input in1 = new Input("circle 100 200 100");
        Input in2 = new Input("square 50 100 50");

        System.out.println(in1.getArrInput().length);
        System.out.println(in2.getArrInput().length);*/


    }
}
