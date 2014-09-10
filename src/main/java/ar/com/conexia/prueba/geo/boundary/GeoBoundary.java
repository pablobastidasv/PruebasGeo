package ar.com.conexia.prueba.geo.boundary;

import ar.com.conexia.prueba.geo.dtos.GeoPointDTO;
import ar.com.conexia.prueba.geo.entities.Geometries;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by pbastidas on 4/09/14.
 */
@Stateless
public class GeoBoundary {

    @PersistenceContext(unitName = "geometryPU")
    private EntityManager em;

    public List<GeoPointDTO> listarPuntos() {
        return em.createNamedQuery("Geometries.findAll", GeoPointDTO.class)
                .getResultList();
    }

    public GeoPointDTO findById(Long pointID) {
        return em.createNamedQuery("Geometries.findById", GeoPointDTO.class)
                .setParameter("id", pointID)
                .getSingleResult();
    }

    public List<GeoPointDTO> findCercanos(Long pointID, int cantidadCercanos) {

        Geometry punto =  new GeometryFactory().createPoint(new Coordinate(10, 15));

        return em.createNamedQuery("Geometries.findCercanos", GeoPointDTO.class)
                .setParameter("id", pointID)
                .setMaxResults(cantidadCercanos)
                .getResultList();
    }

    public Long crear(GeoPointDTO point) {
        Point punto =  new GeometryFactory().createPoint(new Coordinate(point.getLat(), point.getLng()));

        Geometries geo = new Geometries(point.getNombre(), punto);

        em.persist(geo);

        return geo.getId();
    }
}
