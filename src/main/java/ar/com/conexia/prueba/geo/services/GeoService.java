package ar.com.conexia.prueba.geo.services;

import ar.com.conexia.prueba.geo.dtos.GeoPointDTO;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pbastidas on 4/09/14.
 */
@ApplicationScoped
@Path("geo")
@Produces("application/json")
@Consumes("application/json")
public class GeoService {

    private Map<Long, GeoPointDTO> storage;

    @PostConstruct
    public void init(){
        storage=new HashMap<>();
        storage.put(1L, new GeoPointDTO(1L, "Punto 1", 4.69904478078438F,-74.05132416305534F));
        storage.put(2L, new GeoPointDTO(2L, "Punto 2", 26.25732421875F,-32.54681317351514F));
    }

    @GET
    public Response getPoints(){
        return Response.ok()
                .entity(storage.values())
                .build();
    }

    @GET
    @Path("{pointID}")
    public Response getPoint( @PathParam("pointID") Long pointID ){
        return Response.ok()
                .entity(storage.get(pointID))
                .build();
    }

    @GET
    @Path("{pointID}/cercanos")
    public Response getCercanos( @PathParam("pointID") Long pointID){
        return Response.ok()
                .entity(storage.values())
                .build();
    }

    @POST
    public Response crear( GeoPointDTO point ){
        System.out.println(point);

        return Response.ok().build();
    }
}
