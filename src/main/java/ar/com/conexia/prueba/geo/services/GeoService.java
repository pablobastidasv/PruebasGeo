package ar.com.conexia.prueba.geo.services;

import ar.com.conexia.prueba.geo.dtos.GeoPointDTO;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        storage.put(1L, new GeoPointDTO(1L, "Punto", 4.69904478078438F,-74.05132416305534F));
    }

    @GET
    public Response getPoints(){
        return Response.ok()
                .entity(storage.values())
                .header("Access-Control-Allow-Origin", "*")
                .build();
    }

    @GET
    @Path("{pointID}")
    public Response getPoint( @PathParam("pointID") Long pointID ){
        return Response.ok()
                .entity(storage.get(pointID))
                .header("Access-Control-Allow-Origin", "*")
                .build();
    }
}
