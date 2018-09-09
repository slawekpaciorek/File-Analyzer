package com.isa.homeworks;


import java.util.Scanner;

public class App {

    private static CommandFactory instruction = CommandFactory.init();

    public static void main(String[] args) {

        Scanner inputReader = new Scanner(System.in);
        boolean validation =false;

        while(!validation){

            instruction.follow("menu");

            System.out.println();
            System.out.print("Wybierz komendę : ");

            String input;
            input = inputReader.next();

            validation = input.equals("exit");


            System.out.println();
            instruction.follow(input);
            System.out.println();

        }

        inputReader.close();
    }
}