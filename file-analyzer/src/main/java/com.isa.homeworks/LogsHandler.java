package com.isa.homeworks;


import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Map;


public class LogsHandler implements AppOperator {


    List<Logs> dataHandler = new ArrayList<>();


    public List readFile() {


        Scanner scan;

        try (InputStream activitiesStream = LogsHandler.class.getClassLoader().getResourceAsStream("activities.csv")) {
            scan = new Scanner(activitiesStream).useDelimiter("\n");

            DateTimeFormatter stringToLocalDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            scan.nextLine();

            while (scan.hasNext()) {

                    String line = scan.nextLine();

                    String[] dataField = line.split(",");
                    LocalDateTime startTime = LocalDateTime.parse(dataField[0], stringToLocalDate);
                    LocalDateTime endTime = LocalDateTime.parse(dataField[1], stringToLocalDate);
                    int productivity = Integer.parseInt(dataField[2]);
                    String activityName = dataField[3];
                    String categoryName = dataField[4];
                    int spentTime = Integer.parseInt(dataField[5]);

                    Logs data = new Logs(startTime, endTime, productivity, activityName, categoryName, spentTime);

                    dataHandler.add(data);

            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return dataHandler;
    }

    public int getNumberOfActivities() {

        int numberOfActivities = (int) dataHandler.stream().count();
        return numberOfActivities;
    }

    public int lowestActivity() {

        int lowestActivity = dataHandler.stream().mapToInt(x->x.getSpent_time()).min().getAsInt();
        return lowestActivity;
    }

    public int highestActivity () {

        int highestActivity = dataHandler.stream().mapToInt(x -> x.getSpent_time()).max().getAsInt();
        return highestActivity;
    }

    public String averageActivity(){

        String averageActivityStr;

            double averageActivity = dataHandler.stream().mapToDouble(x -> x.getSpent_time()).average().getAsDouble();
            averageActivityStr = String.format("%.2f", averageActivity);

        return averageActivityStr;
    }

    public String workingTime(){

        int workingTimeInt = dataHandler.stream().mapToInt(x->x.getSpent_time()).sum();
        String workingTime = LocalTime.ofSecondOfDay(workingTimeInt).toString();

        return workingTime;

    }

    public String timesLogsToFB(){

        List timesLogsToFB = dataHandler.stream().filter(x->x.getActivity_name().equals("facebook.com")).map(x->x.getStart_time().getHour()).distinct().collect(Collectors.toList());

        return timesLogsToFB.toString();
    }

    public int mostIntensiveHour(){

        Map<Integer, Integer> hoursAndIntesiviti = dataHandler.stream().collect(Collectors.groupingBy(Logs::getHours, Collectors.summingInt(Logs::getSpent_time)));

        int mostIntensiveHour = hoursAndIntesiviti.entrySet().stream().max((x1, x2) -> x1.getValue() > x2.getValue() ? 1 : -1).get().getKey();

        return mostIntensiveHour;
    }

    public void takeCommand(){

        LogsHandler logsHandler = new LogsHandler();

        System.out.println(logsHandler.readFile());

    }



}



