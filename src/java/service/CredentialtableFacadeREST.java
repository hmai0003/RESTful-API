/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import calorietracker.Credentialtable;
import calorietracker.Usertable;
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
@Path("calorietracker.credentialtable")
public class CredentialtableFacadeREST extends AbstractFacade<Credentialtable> {

    @PersistenceContext(unitName = "Assignment1PU")
    private EntityManager em;

    public CredentialtableFacadeREST() {
        super(Credentialtable.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Credentialtable entity) {
        entity.setSignupdate(new Date());
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Credentialtable entity) {
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
    public Credentialtable find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Credentialtable> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Credentialtable> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @GET
    @Path("findByUsername/{username}")
    @Produces({"application/json"})
    public List<Credentialtable> findByUsername(@PathParam("username") String
    username) {
        Query query = em.createNamedQuery("Credentialtable.findByUsername");
        query.setParameter("username", username);
        return query.getResultList();
 }
  
     @GET
    @Path("findByPasswordhash/{passwordhash}")
    @Produces({"application/json"})
    public List<Credentialtable> findByPasswordhash(@PathParam("passwordhash") String
    passwordhash) {
        Query query = em.createNamedQuery("Credentialtable.findByPasswordhash");
        query.setParameter("passwordhash", passwordhash);
        return query.getResultList();
 }
    
    @GET
    @Path("findBySignupdate/{signupdate}")
    @Produces({"application/json"})
    public List<Credentialtable> findByDob(@PathParam("signupdate") String
    signupdate) throws ParseException {
        Query query = em.createNamedQuery("Credentialtable.findBySignupdate");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        query.setParameter("signupdate", format.parse(signupdate));
        return query.getResultList();
 }
    
  @GET
    @Path("findByPasswordAndUsername/{username}/{passwordhash}")
    @Produces({"application/json"})
    public List<Credentialtable> findByPasswordAndUsername(@PathParam("username") String username,
            @PathParam("passwordhash")String passwordhash) {
    Query q = em.createNamedQuery("Credentialtable.findByPasswordAndUsername");
    q.setParameter("username", username);
    q.setParameter("passwordhash",passwordhash);
    return q.getResultList();
 }
    



    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
