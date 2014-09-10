package ar.com.conexia.prueba.geo.services;

import ar.com.conexia.prueba.geo.boundary.GeoBoundary;
import ar.com.conexia.prueba.geo.dtos.GeoPointDTO;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pbastidas on 4/09/14.
 */
@Path("geo")
@Produces("application/json")
@Consumes("application/json")
public class GeoService {

    @EJB
    private GeoBoundary geoBoundary;

    @GET
    public Response getPoints(){
        return Response.ok()
                .entity(geoBoundary.listarPuntos())
                .build();
    }

    @GET
    @Path("{pointID}")
    public Response getPoint( @PathParam("pointID") Long pointID ){
        return Response.ok()
                .entity(geoBoundary.findById(pointID))
                .build();
    }

    @GET
    @Path("{pointID}/cercanos")
    public Response getCercanos( @PathParam("pointID") Long pointID){
        return Response.ok()
                .entity(geoBoundary.findCercanos(pointID, 5))
                .build();
    }

    @POST
    public Response crear( GeoPointDTO point, @Context UriInfo uriInfo ){
        Long pointId = geoBoundary.crear(point);

        URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(pointId)).build();

        return Response.created(uri).build();
    }
}
