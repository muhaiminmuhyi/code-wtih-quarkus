package org.acme;


import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

@Path("/message")
public class MessageResource {
    List<ModelMessage> msg = new ArrayList<>();

    @GET
    public List<ModelMessage> getMsg(){
        return msg;
    }

    @GET
    @Path("{angka}")
    public ModelMessage getMsgById(@PathParam("angka") Integer index) {
        return msg.get(index);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ModelMessage addMsg(ModelMessage message){
        msg.add(message);
        return message;
    }

    @POST
    @Path("batch")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<ModelMessage> addMsg(List<ModelMessage> lotOfMessage){
        for (ModelMessage Message : lotOfMessage) {
            msg.add(Message);
        }
        return lotOfMessage;
    }

    @PUT
    @Path("{index}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ModelMessage editMsg(@PathParam("index") Integer index, ModelMessage newMessage){
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
