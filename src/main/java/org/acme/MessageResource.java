package org.acme;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/message")
public class MessageResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String message() {return "Halloooo gaissss";}

    @GET
    @Path("/admin_message")
    @Produces(MediaType.TEXT_PLAIN)
    public String adm_message() {return "Halloooo ini pesan dari admin";}
}
