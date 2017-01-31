package rest;

import model.*;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import rest.dto.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/statistics")
@Stateless
public class StatisticsResources {

    Mapper mapper = new DozerBeanMapper();

    @PersistenceContext
    EntityManager entityManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        List<StatisticsDto> result = new ArrayList<StatisticsDto>();
        for(Statistics s: entityManager.createNamedQuery("statistics.all",Statistics.class).getResultList()){
            result.add(mapper.map(s, StatisticsDto.class));
        }
        return Response.ok(new GenericEntity<List<StatisticsDto>>(result){}).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        Statistics result = entityManager.createNamedQuery("statistics.id", Statistics.class)
                .setParameter("id", id)
                .getSingleResult();
        if (result == null) {
            return Response.status(404).build();
        }
        return Response.ok(result).build();
    }

}
