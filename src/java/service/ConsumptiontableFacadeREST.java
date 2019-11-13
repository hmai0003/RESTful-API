 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import calorietracker.Consumptiontable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Harsh
 */
@Stateless
@Path("calorietracker.consumptiontable")
public class ConsumptiontableFacadeREST extends AbstractFacade<Consumptiontable> {

    @PersistenceContext(unitName = "Assignment1PU")
    private EntityManager em;

    public ConsumptiontableFacadeREST() {
        super(Consumptiontable.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Consumptiontable entity) {
        entity.setConsumptiondate(new Date());
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Consumptiontable entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Consumptiontable find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Consumptiontable> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Consumptiontable> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @GET
    @Path("findByConsumptiondate/{consumptiondate}")
    @Produces({"application/json"})
    public List<Consumptiontable> findByConsumptiondate(@PathParam("consumptiondate") String
    consumptiondate)throws ParseException {
        Query query = em.createNamedQuery("Consumptiontable.findByConsumptiondate");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        query.setParameter("consumptiondate", format.parse(consumptiondate));
        return query.getResultList();
 }
    
    @GET
    @Path("findByQuantity/{quantity}")
    @Produces({"application/json"})
    public List<Consumptiontable> findByQuantity(@PathParam("quantity") Double
    quantity) {
        Query query = em.createNamedQuery("Consumptiontable.findByQuantity");
        query.setParameter("quantity", quantity);
        return query.getResultList();
 }
    
    @GET
    @Path("totalCaloriesConsumed/{userid}/{consumptiondate}")
    @Produces({"application/json"})
    public String totalCaloriesConsumed(@PathParam("userid") Integer userid,
    @PathParam("consumptiondate") String consumptiondate) throws ParseException  { 
        TypedQuery<Consumptiontable> q = em.createQuery("SELECT r FROM Consumptiontable r WHERE r.userid.userid = :userid AND r.consumptiondate = :consumptiondate", Consumptiontable.class);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        q.setParameter("consumptiondate", format.parse(consumptiondate));
        q.setParameter("userid", userid);
        List<Consumptiontable> con = q.getResultList();
        double totalCalories = 0;
        for (Consumptiontable c : con) {
            totalCalories += (c.getQuantity() * c.getFoodid().getCalorie());
        }
        
        return Double.toString(totalCalories);
    }
    
    
    
    
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
