package com.isa.homeworks;

public class Menu implements AppOperator {

    public void takeCommand(){

        String bar = "---------------";
        String welcomMsg = "\nWitamy w analizie pliku, wpisz którąś z poniższych komend " +
                "\n\taby rozpącząć lub zakończyć działanie programu :" +
                "\n\n\t\t1. 'start' - uruchamia działanie programu" +
                "\n\t\t2. 'exit' - kończy działanie programu" +
                "\n\t\t3. 'help' - wyświetla instrukcję obsługi" +
                "\n\t\t4. 'print-file' - wyświetla analizowany plik" +
                "\n";

        System.out.printf(bar+bar+bar+bar);
        System.out.println(welcomMsg);
        System.out.printf(bar+bar+bar+bar);


    }

}
