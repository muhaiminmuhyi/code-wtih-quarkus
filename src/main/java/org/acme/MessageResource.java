package org.acme;


import org.acme.model.Message;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Path("/message")
public class MessageResource {
    List<Message> msg = new ArrayList<>();

    @Inject
    Validator validator;

    @GET
    public List<Message> getMsg(){
        return msg;
    }

    @GET
    @Path("{angka}")
    public Message getMsgById(@PathParam("angka") Integer index) {
        return msg.get(index);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Result addMsg(Message message){
        Set<ConstraintViolation<Message>> violations = validator.validate(message);
        if (violations.isEmpty()){
            msg.add(message);
            return new Result("Pesan berhasil terkirim");
        } else {
            return new Result(violations);
        }
    }

    @POST
    @Path("batch")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> addMsg(List<Message> lotOfMessage){
        for (org.acme.model.Message Message : lotOfMessage) {
            msg.add(Message);
        }
        return lotOfMessage;
    }

    @PUT
    @Path("{index}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Message editMsg(@PathParam("index") Integer index, Message newMessage){
        msg.set(index, newMessage);
        return newMessage;
    }

    @DELETE
    @Path("{index}")
    public String deleteMsg(@PathParam("index") Integer index){
        msg.remove(index.intValue());
        return "Successfully deleted!!";
    }
}
