package ar.com.conexia.prueba.geo.dtos;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by pbastidas on 5/09/14.
 */
public class GeoPointDTO {
    private Long pointId;
    private String nombre;
    private Double lat;
    private Double lng;

    public GeoPointDTO() {
    }

    public GeoPointDTO(Long pointId) {
        this.pointId = pointId;
    }

    public GeoPointDTO(Long pointId, String nombre, Geometry geometry) {
        Point localizacion = geometry.getFactory().createPoint(geometry.getCoordinate());
        this.pointId =pointId;
        this.nombre = nombre;
        this.lat = localizacion.getX();
        this.lng = localizacion.getY();
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

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
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
