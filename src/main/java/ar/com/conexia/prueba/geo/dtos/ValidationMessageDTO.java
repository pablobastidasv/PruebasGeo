package ar.com.conexia.prueba.geo.dtos;

import ar.com.conexia.prueba.geo.constants.ErrorLevelEnum;

/**
 * Created by pbastidas on 4/09/14.
 */
public class ValidationMessageDTO {

    private ErrorLevelEnum level;
    private String mensaje;

    public ValidationMessageDTO() {
    }

    public ValidationMessageDTO(ErrorLevelEnum level, String mensaje) {
        this.level = level;
        this.mensaje = mensaje;
    }

    public ErrorLevelEnum getLevel() {
        return level;
    }

    public void setLevel(ErrorLevelEnum level) {
        this.level = level;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
