package ar.com.conexia.prueba.geo.dtos;

import ar.com.conexia.prueba.geo.utils.builders.MessagesBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pbastidas on 4/09/14.
 */
public class MessagesDTO {
    private List<ValidationMessageDTO> mensajes;

    public MessagesDTO() {
        mensajes = new ArrayList<>();
    }

    public List<ValidationMessageDTO> getMensajes() {
        return mensajes;
    }

    public static MessagesBuilder getBuilder(){
        return MessagesBuilder.getInstance();
    }
}
