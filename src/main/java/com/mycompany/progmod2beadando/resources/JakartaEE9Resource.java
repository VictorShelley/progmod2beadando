package com.mycompany.progmod2beadando.resources;

import business.Lineup;
import business.MapEnum;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.json.JSONObject;
import access.XmlRead;
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
        JSONObject re = new JSONObject();
        Lineup L = new Lineup(MapEnum.Bind,"A","There","Crosshair");
        //re.put("Fa", "Somat");
        re.put("Map", L.getMap());
        re.put("Landing", L.getLandingLocation());
        re.put("Aim", L.getAimLocation());
        re.put("UI", L.getUI());
        //return Response.ok(re.toString());
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
}
