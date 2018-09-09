package com.isa.homeworks;

import java.time.LocalDateTime;

public class Logs {

    LocalDateTime start_time;
    LocalDateTime end_time;
    int productivity;
    String activity_name;
    String category_name;
    int spent_time;

    public Logs(LocalDateTime start_time, LocalDateTime end_time, int productivity,String activity_name, String category_name, int spent_time){

        this.start_time = start_time;
        this.end_time = end_time;
        this.productivity = productivity;
        this.activity_name = activity_name;
        this.category_name = category_name;
        this.spent_time = spent_time;

    }

    public int getSpent_time() {
        return spent_time;
    }

    public String getActivity_name(){
        return activity_name;
    }

    public LocalDateTime getStart_time(){
        return start_time;
    }
    public int getHours(){
        return start_time.getHour();
    }

    @Override
    public String toString() {
        if (productivity >= 0) {
            return " Data [ " +
                    "Start time = " + start_time +
                    " |  End time = " + end_time +
                    " |  Productivity = " + productivity +
                    "  |  Activity name = " + activity_name +
                    " |  Category name = " + category_name +
                    " |  Spent time = " + spent_time +
                    " ]" +
                    "\n";
        } else {
            return " Data [ " +
                    "Start time = " + start_time +
                    " |  End time = " + end_time +
                    " |  Productivity = " + productivity +
                    " |  Activity name = " + activity_name +
                    " |  Category name = " + category_name +
                    " |  Spent time = " + spent_time +
                    " ]" +
                    "\n";
        }
    }

}
