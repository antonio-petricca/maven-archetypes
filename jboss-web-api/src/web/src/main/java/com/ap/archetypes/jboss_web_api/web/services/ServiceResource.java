package com.ap.archetypes.jboss_web_api.web.services;


import com.ap.archetypes.jboss_web_api.ejb.session.SessionBean;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("resource")
public class ServiceResource {

    @EJB
    SessionBean ejb;

    @GET
    @Path("getTablesList")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getTablesList() {
        return ejb.getTablesList();
    }

    @GET
    @Path("sayHello")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return ejb.sayHello();
    }
}
