package com.mycompany.progmod2beadando.resources;

import business.Lineup;
import business.MapEnum;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.json.JSONObject;
import controller.XmlRead;
import controller.XmlWrite;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Produces;
import org.json.JSONArray;
import model.Convert;
/**
 *
 * @author 
 */
@Path("jakartaee9")
public class JakartaEE9Resource {
    
    @GET
    public Response ping(){
        return Response
                .ok("ping Jakarta EE")
                .build();
    }
    
    @GET
    @Path("Example")
    public Response example(){
        JSONArray re = new JSONArray();
        Lineup L = new Lineup(MapEnum.Bind,"A","There","Crosshair");
        re.put("A szöveget '-'-vel válassza el. Pl.:Bind-A-There-Crosshair=");
        re.put("Map: " + L.getMap());
        re.put("Landing Location: " + L.getLandingLocation());
        re.put("Aim Location: " + L.getAimLocation());
        re.put("UI: " + L.getUI());
        return Response.ok(re.toString())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
    
    @GET
    @Path("ReadAll")
    public Response All(){
        XmlRead read = new XmlRead();
        return Response.ok(read.ReadAll().toString())
        //JSONObject re = read.ReadAll();
        //return Response.ok(re.toString())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
    
    @POST
    @Path("WriteAdd")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response WriteAdd(String be){
        JSONArray ki = new JSONArray();
        ki = Convert.StringToLineup(be);
        
        XmlWrite ir = new XmlWrite();
        ir.Add(ki);
        
        return Response
                .ok("Hozzáadva")
                .build();
    }
}
