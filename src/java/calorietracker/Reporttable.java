/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calorietracker;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Harsh
 */
@Entity
@Table(name = "REPORTTABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reporttable.findAll", query = "SELECT r FROM Reporttable r")
    , @NamedQuery(name = "Reporttable.findByReportid", query = "SELECT r FROM Reporttable r WHERE r.reportid = :reportid")
    , @NamedQuery(name = "Reporttable.findByReportdate", query = "SELECT r FROM Reporttable r WHERE r.reportdate = :reportdate")
    , @NamedQuery(name = "Reporttable.findByCalorieconsumed", query = "SELECT r FROM Reporttable r WHERE r.calorieconsumed = :calorieconsumed")
    , @NamedQuery(name = "Reporttable.findByCalorieburned", query = "SELECT r FROM Reporttable r WHERE r.calorieburned = :calorieburned")
    , @NamedQuery(name = "Reporttable.findByStepstaken", query = "SELECT r FROM Reporttable r WHERE r.stepstaken = :stepstaken")
    , @NamedQuery(name = "Reporttable.findByCaloriegoal", query = "SELECT r FROM Reporttable r WHERE r.caloriegoal = :caloriegoal")
    , @NamedQuery(name = "Reporttable.findByFirstnameANDCalorieburned", query = "SELECT r FROM Reporttable r WHERE r.userid.firstname = :firstname AND r.calorieburned = :calorieburned")})
public class Reporttable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "REPORTID")
    private Integer reportid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REPORTDATE")
    @Temporal(TemporalType.DATE)
    private Date reportdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CALORIECONSUMED")
    private double calorieconsumed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CALORIEBURNED")
    private double calorieburned;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STEPSTAKEN")
    private int stepstaken;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CALORIEGOAL")
    private double caloriegoal;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    @ManyToOne(optional = false)
    private Usertable userid;

    public Reporttable() {
    }

    public Reporttable(Integer reportid) {
        this.reportid = reportid;
    }

    public Reporttable(Integer reportid, Date reportdate, double calorieconsumed, double calorieburned, int stepstaken, double caloriegoal) {
        this.reportid = reportid;
        this.reportdate = reportdate;
        this.calorieconsumed = calorieconsumed;
        this.calorieburned = calorieburned;
        this.stepstaken = stepstaken;
        this.caloriegoal = caloriegoal;
    }

    public Integer getReportid() {
        return reportid;
    }

    public void setReportid(Integer reportid) {
        this.reportid = reportid;
    }

    public Date getReportdate() {
        return reportdate;
    }

    public void setReportdate(Date reportdate) {
        this.reportdate = reportdate;
    }

    public double getCalorieconsumed() {
        return calorieconsumed;
    }

    public void setCalorieconsumed(double calorieconsumed) {
        this.calorieconsumed = calorieconsumed;
    }

    public double getCalorieburned() {
        return calorieburned;
    }

    public void setCalorieburned(double calorieburned) {
        this.calorieburned = calorieburned;
    }

    public int getStepstaken() {
        return stepstaken;
    }

    public void setStepstaken(int stepstaken) {
        this.stepstaken = stepstaken;
    }

    public double getCaloriegoal() {
        return caloriegoal;
    }

    public void setCaloriegoal(double caloriegoal) {
        this.caloriegoal = caloriegoal;
    }

    public Usertable getUserid() {
        return userid;
    }

    public void setUserid(Usertable userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reportid != null ? reportid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reporttable)) {
            return false;
        }
        Reporttable other = (Reporttable) object;
        if ((this.reportid == null && other.reportid != null) || (this.reportid != null && !this.reportid.equals(other.reportid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "calorietracker.Reporttable[ reportid=" + reportid + " ]";
    }
    
}
