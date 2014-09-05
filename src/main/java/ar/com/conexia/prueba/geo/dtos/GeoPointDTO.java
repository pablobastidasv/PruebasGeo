package ar.com.conexia.prueba.geo.dtos;

/**
 * Created by pbastidas on 5/09/14.
 */
public class GeoPointDTO {
    private Long pointId;
    private String nombre;
    private Float lat;
    private Float lng;

    public GeoPointDTO() {
    }

    public GeoPointDTO(Long pointId) {
        this.pointId = pointId;
    }

    public GeoPointDTO(Long pointId, String nombre, Float lat, Float lng) {
        this.pointId = pointId;
        this.nombre = nombre;
        this.lat = lat;
        this.lng = lng;
    }

    public Long getPointId() {
        return pointId;
    }

    public void setPointId(Long pointId) {
        this.pointId = pointId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLng() {
        return lng;
    }

    public void setLng(Float lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "Point{" +
                "nombre='" + nombre + '\'' +
                ", lng=" + lng +
                ", lat=" + lat +
                '}';
    }
}
