package com.isa.homeworks;

import java.util.Scanner;

public class InputExecutor {

    public static String inputReader(){

        Scanner inputReader = new Scanner(System.in);

        System.out.println();
        System.out.print("Wprowadź komendę : ");
        String input = inputReader.next();
        System.out.println();

        return input;
    }

}
