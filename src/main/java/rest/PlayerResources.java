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

@Path("/players")
@Stateless
public class PlayerResources {

    Mapper mapper = new DozerBeanMapper();

    @PersistenceContext
    EntityManager entityManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        List<PlayerDto> result = new ArrayList<PlayerDto>();
        for(Player p: entityManager.createNamedQuery("player.all",Player.class).getResultList()){
            result.add(mapper.map(p, PlayerDto.class));
        }
        return Response.ok(new GenericEntity<List<PlayerDto>>(result){}).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        Player result = entityManager.createNamedQuery("player.id", Player.class)
                .setParameter("id", id)
                .getSingleResult();
        if (result == null) {
            return Response.status(404).build();
        }
        return Response.ok(result).build();
    }

}
