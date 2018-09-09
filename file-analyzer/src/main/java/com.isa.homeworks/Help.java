package com.isa.homeworks;

public class Help implements AppOperator {

    public void takeCommand(){

        String bar = "---------------";
        String helpMsg = "Aplikacja służy do porównywania zapisanych danych, " +
                "\n\tpodczas aplikacji pamiętaj o wpisywaniu odpowiednich" +
                "\n\tkomend, zwracaj uwagi na wielkość znaków, " +
                "\n\tczytaj dokładnie wyświetlane instrukcje";

        System.out.println();
        System.out.printf(bar+bar+bar+bar);
        System.out.printf(helpMsg);
        System.out.printf(bar+bar+bar+bar);
        System.out.println();

    }
}
