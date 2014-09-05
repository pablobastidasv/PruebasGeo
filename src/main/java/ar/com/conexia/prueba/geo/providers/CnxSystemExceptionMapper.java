package ar.com.conexia.prueba.geo.providers;

import ar.com.conexia.prueba.geo.exceptions.CnxSystemException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by pbastidas on 4/09/14.
 */
@Provider
public class CnxSystemExceptionMapper implements ExceptionMapper<CnxSystemException> {

    @Override
    public Response toResponse(CnxSystemException e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .header("cnx-error", e.getMessage())
                .build();
    }
}
