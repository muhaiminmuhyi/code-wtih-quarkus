package org.acme.model;

import javax.validation.constraints.NotBlank;

public class Message {
    @NotBlank
    public String name;
    public Integer number;
    public String message;

    public Message(){

    }

    public Message(String name, Integer number, String message){
        this.name = name;
        this.number = number;
        this.message = message;
    }
}
