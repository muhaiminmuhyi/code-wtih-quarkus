package org.acme;


import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

@Path("/message")
public class MessageResource {
    List<String> msg = new ArrayList<>();

    @GET
    public List<String> getMsg(){
        return msg;
    }

    @GET
    @Path("{index}")
    public String getMsgById(Integer index) {
        return msg.get(index);
    }

    @POST
    public List<String> addMsg(String message){
        msg.add(message);
        return msg;
    }

    @PUT
    @Path("{index}")
    public List<String> changeWord(Integer index, String message){
        msg.set(index, message);
        return msg;
    }
}
