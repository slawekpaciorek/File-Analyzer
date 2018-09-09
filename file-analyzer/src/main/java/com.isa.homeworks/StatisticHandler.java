package com.isa.homeworks;
import java.util.List;
import java.util.Scanner;

class StatisticHandler implements AppOperator {

    String separator = "" +
            "\n---------------------------------------------" +
            "\n";
    LogsHandler logsHandler = new LogsHandler();
    List displayFile = logsHandler.readFile();
    Scanner inputReader = new Scanner(System.in);
    boolean loopValidation = false;

    @Override
    public void takeCommand() {


        ;


        System.out.println();
        System.out.print("Witamy w analizie danych, jeśli chcesz zobaczyć analizowany plik wpisze 'display'" +
                "\n\t jeśli chcesz przejść do wybranych statystyk wpisz 'dalej' : ");
        String input;

        while (!loopValidation) {
            input = inputReader.next();
            System.out.println();


            if(input.equals("display")){
                System.out.println(displayFile);

                System.out.println(separator);
                System.out.print("Jeśli chcesz zobaczyć statysyki wpisz 'dalej' : ");

                while(!loopValidation){

                    input = inputReader.next();
                    System.out.println();

                    if(input.equals("dalej")){
                        displyStatistic();
                        loopValidation = true;
                    }
                    else
                        System.out.println("Błędna komenda, wpisz jeszcze raz.");

                }
            }
            else if(input.equals("dalej")){

                displyStatistic();

                loopValidation = true;

            }else {
                System.out.println("Spróbuj pnownie, wpisz poprawnie komendę");
            }


        }



        System.out.println("Aplikacja powróci do menu glównego aby wyjść, wpisz exit");

    }

    public void displyStatistic(){
        System.out.println("Poniżej znajdują się przykładowe statystyki : ");
        System.out.println(separator + "\n");
        System.out.println("Łączna liczba wszystkich zdarzeń : " + logsHandler.getNumberOfActivities());
        System.out.println(separator);
        System.out.println("Najkrótsza aktywność [s] : " + logsHandler.lowestActivity());
        System.out.println(separator);
        System.out.println("Najdłuższa aktywność [s] : " + logsHandler.highestActivity());
        System.out.println(separator);
        System.out.println("Średni czas aktywności [s] : " + logsHandler.averageActivity());
        System.out.println(separator);
        System.out.println("Łączny czaspracy : " + logsHandler.workingTime());
        System.out.println(separator);
        System.out.println("Godziny logowania na facebook.com : " + logsHandler.timesLogsToFB());
        System.out.println(separator);
        System.out.println("Najbardziej inntensywna godzina : " + logsHandler.mostIntensiveHour());
        System.out.println();
        System.out.println(separator);

    }
}
