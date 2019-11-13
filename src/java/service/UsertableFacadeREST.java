/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import calorietracker.Usertable;
import static com.sun.xml.bind.util.CalendarConv.formatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
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
@Path("calorietracker.usertable")
public class UsertableFacadeREST extends AbstractFacade<Usertable> {

    @PersistenceContext(unitName = "Assignment1PU")
    private EntityManager em;

    public UsertableFacadeREST() {
        super(Usertable.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Usertable entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Usertable entity) {
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
    public Usertable find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Usertable> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Usertable> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
   
    @GET
    @Path("findByFirstname/{firstname}")
    @Produces({"application/json"})
    public List<Usertable> findByFirstname(@PathParam("firstname") String
    firstname) {
        Query query = em.createNamedQuery("Usertable.findByFirstname");
        query.setParameter("firstname", firstname);
        return query.getResultList();
 }
    
    @GET
    @Path("findByLastname/{lastname}")
    @Produces({"application/json"})
    public List<Usertable> findByLastname(@PathParam("lastname") String
    lastname) {
        Query query = em.createNamedQuery("Usertable.findByLastname");
        query.setParameter("lastname", lastname);
        return query.getResultList();
 }
    
    @GET
    @Path("findByEmailid/{emailid}")
    @Produces({"application/json"})
    public List<Usertable> findByEmailid(@PathParam("emailid") String
    emailid) {
        Query query = em.createNamedQuery("Usertable.findByEmailid");
        query.setParameter("emailid", emailid);
        return query.getResultList();
 }
    
    @GET
    @Path("findByDob/{dob}")
    @Produces({"application/json"})
    public List<Usertable> findByDob(@PathParam("dob") String
    dob) throws ParseException {
        Query query = em.createNamedQuery("Usertable.findByDob");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        query.setParameter("dob", format.parse(dob));
        return query.getResultList();
 }
    
    @GET
    @Path("findByHeight/{height}")
    @Produces({"application/json"})
    public List<Usertable> findByHeight(@PathParam("height") Double
    height) {
        Query query = em.createNamedQuery("Usertable.findByHeight");
        query.setParameter("height", height);
        return query.getResultList();
 }
    @GET
    @Path("findByWeight/{weight}")
    @Produces({"application/json"})
    public List<Usertable> findByWeight(@PathParam("weight") Double
    weight) {
        Query query = em.createNamedQuery("Usertable.findByWeight");
        query.setParameter("weight", weight);
        return query.getResultList();
 }

    @GET
    @Path("findByGender/{gender}")
    @Produces({"application/json"})
    public List<Usertable> findByGender(@PathParam("gender") String
    gender) {
        Query query = em.createNamedQuery("Usertable.findByGender");
        query.setParameter("gender", gender.charAt(0));
        return query.getResultList();
 }
    
    @GET
    @Path("findByAddress/{address}")
    @Produces({"application/json"})
    public List<Usertable> findByAddress(@PathParam("address") String
    address) {
        Query query = em.createNamedQuery("Usertable.findByAddress");
        query.setParameter("address", address);
        return query.getResultList();
 }
    
    @GET
    @Path("findByPostcode/{postcode}")
    @Produces({"application/json"})
    public List<Usertable> findByPostcode(@PathParam("postcode") Integer
    postcode) {
        Query query = em.createNamedQuery("Usertable.findByPostcode");
        query.setParameter("postcode", postcode);
        return query.getResultList();
 }
    
    @GET
    @Path("findByLevelofactivity/{levelofactivity}")
    @Produces({"application/json"})
    public List<Usertable> findByLevelofactivity(@PathParam("levelofactivity") Integer
    levelofactivity) {
        Query query = em.createNamedQuery("Usertable.findByLevelofactivity");
        query.setParameter("levelofactivity", levelofactivity);
        return query.getResultList();
 }
    
    @GET
    @Path("findByStepspermile/{stepspermile}")
    @Produces({"application/json"})
    public List<Usertable> findByStepspermile(@PathParam("stepspermile") Integer
    stepspermile) {
        Query query = em.createNamedQuery("Usertable.findByStepspermile");
        query.setParameter("stepspermile", stepspermile);
        return query.getResultList();
 }
    //4A
    @GET
    @Path("findCalorieperstep/{userid}")
    @Produces({"application/json"})
    public String findCalorieperstep(@PathParam("userid") Integer
    userid) {
        Query query = em.createNamedQuery("Usertable.findByUserid");
        query.setParameter("userid", userid); 
        Usertable user = (Usertable)query.getSingleResult();
        int x = user.getStepspermile();
        double y = user.getWeight();       
        return Double.toString((y*2.20462*0.49)/x);
    }
    
    
    //4B
    @GET
    @Path("findBMR/{userid}")
    @Produces({"application/json"})
    public String findBMR(@PathParam("userid") Integer
    userid){
        Query query = em.createNamedQuery("Usertable.findByUserid");
        query.setParameter("userid", userid); 
        Usertable user = (Usertable)query.getSingleResult();
        char  gen = user.getGender();
        double wei = user.getWeight();
        Date dob = user.getDob();
        double hei = user.getHeight();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
        LocalDate dob1 = dob.toInstant().atZone(defaultZoneId).toLocalDate();        
        int age = Period.between(dob1,localDate).getYears();
        if (gen == 'M')
            return Double.toString((13.75*wei)+(5.003*hei)-(6.755*age)+66.5);
        else
            return Double.toString((9.563*wei)+(1.85*hei)-(4.676*age)+  655.1);                                      
    }
    
    //4C
    @GET
    @Path("findLevelOfActivity/{userid}")
    @Produces({"application/json"})
    public String findLevelOfActivity(@PathParam("userid") Integer
    userid){
        Query query = em.createNamedQuery("Usertable.findByUserid");
        query.setParameter("userid", userid); 
        Usertable user = (Usertable)query.getSingleResult();
        int levelofActivity = user.getLevelofactivity();
        double bmr = Double.parseDouble(findBMR(userid));
        switch(levelofActivity)
        {
            case 1: return Double.toString(bmr * 1.2);
            case 2: return Double.toString(bmr * 1.375);
            case 3: return Double.toString(bmr * 1.55);
            case 4: return Double.toString(bmr * 1.725);
            case 5: return Double.toString(bmr * 1.9);
            default: return "invalid input";
        } 
    }
        
    @Override
    protected EntityManager getEntityManager() 
    {
        return em;
    }
    
}
