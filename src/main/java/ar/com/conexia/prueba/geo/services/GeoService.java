package ar.com.conexia.prueba.geo.services;

import ar.com.conexia.prueba.geo.boundary.GeoBoundary;
import ar.com.conexia.prueba.geo.dtos.GeoPointDTO;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.json.*;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.ByteArrayInputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
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
    public JsonObject getCercanos( @PathParam("pointID") Long pointID){
        JsonObject centro = geoPointToJson( geoBoundary.findById(pointID));

        JsonArrayBuilder cercanos = Json.createArrayBuilder();
        for (GeoPointDTO cercano : geoBoundary.findCercanos(pointID, 5)) {
            cercanos.add(geoPointToJson(cercano));
        }

        return Json.createObjectBuilder()
                .add("centro", centro)
                .add("cercanos", cercanos)
                .build();
    }

    private JsonObject geoPointToJson(GeoPointDTO centro) {
        return Json.createObjectBuilder()
                .add("nombre", centro.getNombre())
                .add("lat", centro.getLat())
                .add("lng", centro.getLng())
                .build();
    }

    @POST
    public Response crear( GeoPointDTO point, @Context UriInfo uriInfo ){
        Long pointId = geoBoundary.crear(point);

        URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(pointId)).build();

        return Response.created(uri).build();
    }
}
