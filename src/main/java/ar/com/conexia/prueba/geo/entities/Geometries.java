package ar.com.conexia.prueba.geo.entities;

import org.hibernate.annotations.Type;
import com.vividsolutions.jts.geom.Point;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by pbastidas on 9/09/14.
 */
@Entity
@Table(name = "geometries")
@NamedQueries({
        @NamedQuery(name="Geometries.findAll", query = "SELECT new ar.com.conexia.prueba.geo.dtos.GeoPointDTO(g.id, g.nombre, g.location) FROM Geometries g")
      , @NamedQuery(name="Geometries.findById", query = "SELECT new ar.com.conexia.prueba.geo.dtos.GeoPointDTO(g.id, g.nombre, g.location) FROM Geometries g WHERE g.id = :id")
      , @NamedQuery(name="Geometries.findCercanos", query = "SELECT new ar.com.conexia.prueba.geo.dtos.GeoPointDTO(g.id, g.nombre, g.location) FROM Geometries g WHERE g.id <> :id ORDER BY distance(g.location, (select g2.location from Geometries g2 where g2.id = :id))")
})
public class Geometries implements Serializable{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String nombre;

    @Column(name = "geom")
    @Type(type="org.hibernate.spatial.GeometryType")
    private Point location;

    public Geometries() {
    }

    public Geometries(Long id) {
        this.id = id;
    }

    public Geometries(String nombre, Point location) {
        this.nombre = nombre;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
}
