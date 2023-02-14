package org.acme;

public class ModelMessage {
    public String name;
    public Integer number;
    public String message;

    public ModelMessage(){

    }

    public ModelMessage(String name, Integer number, String message){
        this.name = name;
        this.number = number;
        this.message = message;
    }
}
