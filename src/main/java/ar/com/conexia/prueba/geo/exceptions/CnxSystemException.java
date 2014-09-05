package ar.com.conexia.prueba.geo.exceptions;

import javax.ejb.ApplicationException;

/**
 * Created by pbastidas on 4/09/14.
 */
@ApplicationException(rollback = true)
public class CnxSystemException extends Exception{
    public CnxSystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
