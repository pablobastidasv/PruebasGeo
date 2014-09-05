package ar.com.conexia.prueba.geo.constants;

/**
 * Created by pbastidas on 4/09/14.
 */
public enum GeneralsEnum {
    HEADER_ERROR("cnx-error");

    private final String valor;

    public String getValor() {
        return valor;
    }

    private GeneralsEnum(String valor) {
        this.valor = valor;
    }
}
