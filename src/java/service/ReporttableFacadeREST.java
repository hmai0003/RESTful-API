/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import calorietracker.ReportDate;
import calorietracker.Reporttable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
@Path("calorietracker.reporttable")
public class ReporttableFacadeREST extends AbstractFacade<Reporttable> {

    @PersistenceContext(unitName = "Assignment1PU")
    private EntityManager em;

    public ReporttableFacadeREST() {
        super(Reporttable.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Reporttable entity) {
        entity.setReportdate(new Date());
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Reporttable entity) {
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
    public Reporttable find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Reporttable> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Reporttable> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    //3(A)
    @GET
    @Path("findByReportdate/{reportdate}")
    @Produces({"application/json"})
    public List<Reporttable> findByReportdate(@PathParam("reportdate") String
    reportdate) throws ParseException {
        Query query = em.createNamedQuery("Reporttable.findByReportdate");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        query.setParameter("reportdate", format.parse(reportdate));
        return query.getResultList();
 }
    
    @GET
    @Path("findByCalorieconsumed/{calorieconsumed}")
    @Produces({"application/json"})
    public List<Reporttable> findByCalorieconsumed(@PathParam("calorieconsumed") Double
    calorieconsumed){
        Query query = em.createNamedQuery("Reporttable.findByCalorieconsumed");
        query.setParameter("calorieconsumed", calorieconsumed);
        return query.getResultList();
 }
    
    @GET
    @Path("findByCalorieburned/{calorieburned}")
    @Produces({"application/json"})
    public List<Reporttable> findByCalorieburned(@PathParam("calorieburned") Double
    calorieburned){
        Query query = em.createNamedQuery("Reporttable.findByCalorieburned");
        query.setParameter("calorieburned", calorieburned);
        return query.getResultList();
 }
    
    @GET
    @Path("findByStepstaken/{stepstaken}")
    @Produces({"application/json"})
    public List<Reporttable> findByStepstaken(@PathParam("stepstaken") Integer
    stepstaken){
        Query query = em.createNamedQuery("Reporttable.findByStepstaken");
        query.setParameter("stepstaken", stepstaken);
        return query.getResultList();
 }
    
    @GET
    @Path("findByCaloriegoal/{caloriegoal}")
    @Produces({"application/json"})
    public List<Reporttable> findByCaloriegoal(@PathParam("caloriegoal") Double
    caloriegoal){
        Query query = em.createNamedQuery("Reporttable.findByCaloriegoal");
        query.setParameter("caloriegoal", caloriegoal);
        return query.getResultList();
 }
  
    //3(B)
    @GET
    @Path("findByCalorieburnedANDCaloriegoal/{calorieburned}/{caloriegoal}")
    @Produces({"application/json"})
    public List<Reporttable> findByCalorieburnedANDCaloriegoal(@PathParam("calorieburned") Double calorieburned,
    @PathParam("caloriegoal") Double caloriegoal) {
    TypedQuery<Reporttable> q = em.createQuery("SELECT r FROM Reporttable r WHERE r.calorieburned = :calorieburned AND r.caloriegoal = :caloriegoal", Reporttable.class);
    q.setParameter("calorieburned", calorieburned);
    q.setParameter("caloriegoal", caloriegoal);
    return q.getResultList(); }
    
    
    //3(C)
    @GET
    @Path("findByFirstnameANDCaloriegoal/{firstname}/{caloriegoal}")
    @Produces({"application/json"})
    public List<Reporttable> findByFirstNameANDCaloriegoal(@PathParam("firstname") String firstname,
            @PathParam("caloriegoal")Double caloriegoal) {
    TypedQuery<Reporttable> q = em.createQuery("SELECT s FROM Reporttable s WHERE s.userid.firstname = :firstname AND s.caloriegoal = :caloriegoal",Reporttable.class);
    q.setParameter("firstname", firstname);
    q.setParameter("caloriegoal",caloriegoal);
    return q.getResultList();
 }
    
    //3(D)
    
    @GET
    @Path("findByFirstnameANDCalorieburned/{firstname}/{calorieburned}")
    @Produces({"application/json"})
    public List<Reporttable> findByFirstnameANDCalorieburned(@PathParam("firstname") String firstname,
            @PathParam("calorieburned")Double calorieburned) {
    Query q = em.createNamedQuery("Reporttable.findByFirstnameANDCalorieburned");
    q.setParameter("firstname", firstname);
    q.setParameter("calorieburned",calorieburned);
    return q.getResultList();
 }
    

    @GET
    @Path("calorieReport/{userid}/{reportdate}")
    @Produces({"application/json"})
    public String calorieReport(@PathParam("userid") Integer userid,
    @PathParam("reportdate") String reportdate) throws ParseException  { 
        TypedQuery<Reporttable> q = em.createQuery("SELECT r FROM Reporttable r WHERE r.userid.userid = :userid AND r.reportdate = :reportdate", Reporttable.class);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        q.setParameter("reportdate", format.parse(reportdate));
        q.setParameter("userid", userid);
        Reporttable report = (Reporttable)q.getSingleResult();
        double totalCaloriesConsumed = report.getCalorieconsumed() ;
        double totalCaloriesBurned = report.getCalorieburned();
        double finalCalorieGoal = report.getCaloriegoal();
        String remaining = Double.toString(finalCalorieGoal + totalCaloriesConsumed - totalCaloriesBurned);
        ArrayList<String> list = new ArrayList<>();
        
        list.add(Double.toString(totalCaloriesConsumed));
        list.add(Double.toString(totalCaloriesBurned));
        list.add(remaining);
       
        return list.toString();
    }
    
    @GET
    @Path("getTotalCaloriesTotalStepsTaken/{userid}/{startdate}/{enddate}")
    @Produces({"application/json"})
    public String getTotalCaloriesTotalStepsTaken(@PathParam("userid") Integer userid, @PathParam("startdate") String startdate, @PathParam("enddate") String enddate) throws ParseException {
        TypedQuery<Reporttable> query = em.createQuery("SELECT r FROM Reporttable r WHERE r.userid.userid = :userid AND r.reportdate BETWEEN :startdate AND :enddate", Reporttable.class);
        query.setParameter("userid", userid);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        query.setParameter("startdate", format.parse(startdate));
        query.setParameter("enddate", format.parse(enddate));
        List<Reporttable> reports = query.getResultList();
        
        HashMap<String, String> returnValue = new HashMap<>();
        double totalCalorieConsumed = 0.0;
        double totalCalorieBurned = 0.0;
        int totalStepsTaken = 0;
        for (Reporttable report : reports) {
            totalCalorieConsumed += report.getCalorieconsumed();
            totalCalorieBurned += report.getCalorieburned();
            totalStepsTaken += report.getStepstaken();
        }
        returnValue.put("Total Calories Consumed", Double.toString(totalCalorieConsumed));
        returnValue.put("Total Calories Burned", Double.toString(totalCalorieBurned));
        returnValue.put("Total Steps Taken", Integer.toString(totalStepsTaken));
        return returnValue.toString();
    }

    @GET
    @Path("filterByDateRange/{userid}/{startdate}/{enddate}")
    @Produces({"application/json"})
    public List<ReportDate> filterByDateRange(@PathParam("userid") Integer userid, @PathParam("startdate") String startdate, @PathParam("enddate") String enddate) throws ParseException {
        return getCalsConsumedANDBurned(userid,startdate,enddate);
    }
    private List<ReportDate> getCalsConsumedANDBurned(@PathParam("userId") Integer userid, @PathParam("startdate") String startdate, @PathParam("enddate") String enddate) throws ParseException {
        TypedQuery<Reporttable> query = em.createQuery("SELECT r FROM Reporttable r WHERE r.userid.userid = :userid AND r.reportdate BETWEEN :startdate AND :enddate", Reporttable.class);
        query.setParameter("userid", userid);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        query.setParameter("startdate", format.parse(startdate));
        query.setParameter("enddate", format.parse(enddate));
        List<Reporttable> reports = query.getResultList();
  
        SimpleDateFormat formaat = new SimpleDateFormat("dd/MM/yyyy");
        List<ReportDate> report = new ArrayList<>();
        for (Reporttable eachReport : reports) {
            report.add(new ReportDate(eachReport.getCalorieconsumed(), eachReport.getCalorieburned(), formaat.format(eachReport.getReportdate())));
        }
        return report;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
