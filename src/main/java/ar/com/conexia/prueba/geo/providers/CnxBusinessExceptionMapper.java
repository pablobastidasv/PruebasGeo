package ar.com.conexia.prueba.geo.providers;


import ar.com.conexia.prueba.geo.constants.GeneralsEnum;
import ar.com.conexia.prueba.geo.exceptions.CnxBusinessException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Created by pbastidas on 4/09/14.
 */
public class CnxBusinessExceptionMapper implements ExceptionMapper<CnxBusinessException> {
    @Override
    public Response toResponse(CnxBusinessException e) {
        return Response.status(401)
                       .header(GeneralsEnum.HEADER_ERROR.getValor(), "Business error")
                       .entity(e.getMessages())
                       .build();
    }
}
