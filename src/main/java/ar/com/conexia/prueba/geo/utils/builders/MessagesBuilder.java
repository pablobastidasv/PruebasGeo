package ar.com.conexia.prueba.geo.utils.builders;

import ar.com.conexia.prueba.geo.constants.ErrorLevelEnum;
import ar.com.conexia.prueba.geo.dtos.MessagesDTO;
import ar.com.conexia.prueba.geo.dtos.ValidationMessageDTO;

/**
 * Created by pbastidas on 4/09/14.
 */
public class MessagesBuilder {
    private MessagesDTO messages;

    private MessagesBuilder() {
        messages = new MessagesDTO();
    }

    public static MessagesBuilder getInstance() {
        return new MessagesBuilder();
    }

    public MessagesDTO build() {
        return messages;
    }

    public MessagesBuilder addMessages(ValidationMessageDTO... messages) {
        if (messages != null) {
            for (ValidationMessageDTO message : messages) {
                this.messages.getMensajes().add(message);
            }
        }

        return this;
    }

    public MessagesBuilder addError(String mensaje) {
        messages.getMensajes().add(new ValidationMessageDTO(ErrorLevelEnum.ERROR, mensaje));
        return this;
    }

    public MessagesBuilder addWarning(String mensaje) {
        messages.getMensajes().add(new ValidationMessageDTO(ErrorLevelEnum.WARN, mensaje));
        return this;
    }

    public MessagesBuilder addInformation(String mensaje) {
        messages.getMensajes().add(new ValidationMessageDTO(ErrorLevelEnum.INFO, mensaje));
        return this;
    }
}
