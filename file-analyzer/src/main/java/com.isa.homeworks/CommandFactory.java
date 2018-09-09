package com.isa.homeworks;

import java.util.Map;
import java.util.HashMap;

public class CommandFactory {

    private final Map<String, AppOperator> instruction;

    public static CommandFactory init(){

        CommandFactory command = new CommandFactory();

        command.instruction.put("menu", new Menu());
        command.instruction.put("exit", ()-> System.out.println("Dziękujemy za skorzystanie z aplikacji"));
        command.instruction.put("start", new StatisticHandler());
        command.instruction.put("print-file", new LogsHandler());
        command.instruction.put("error", ()-> System.out.println("Błędna komenda, spróbuj ponownie"));
        command.instruction.put("help", new Help());

        return command;
    }

    private CommandFactory(){
        instruction = new HashMap<>();
    }

    public void follow(String inputCommand){

        if(!instruction.containsKey(inputCommand))
            inputCommand = "error";

        instruction.get(inputCommand).takeCommand();
    }

}
