package ar.com.conexia.prueba.geo.exceptions;

import ar.com.conexia.prueba.geo.dtos.MessagesDTO;
import ar.com.conexia.prueba.geo.dtos.ValidationMessageDTO;

import javax.ejb.ApplicationException;

/**
 * Created by pbastidas on 4/09/14.
 */
@ApplicationException(rollback = true)
public class CnxBusinessException extends Exception {
    MessagesDTO messages;

    public CnxBusinessException(MessagesDTO messages) {
        this.messages = messages;
    }

    public CnxBusinessException(ValidationMessageDTO... messages) {
        this.messages = MessagesDTO.getBuilder().addMessages(messages).build();
    }

    public MessagesDTO getMessages() {
        return messages;
    }
}
