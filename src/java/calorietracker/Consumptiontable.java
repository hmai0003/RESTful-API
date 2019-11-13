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
@Table(name = "CONSUMPTIONTABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consumptiontable.findAll", query = "SELECT c FROM Consumptiontable c")
    , @NamedQuery(name = "Consumptiontable.findByConsumptionid", query = "SELECT c FROM Consumptiontable c WHERE c.consumptionid = :consumptionid")
    , @NamedQuery(name = "Consumptiontable.findByConsumptiondate", query = "SELECT c FROM Consumptiontable c WHERE c.consumptiondate = :consumptiondate")
    , @NamedQuery(name = "Consumptiontable.findByQuantity", query = "SELECT c FROM Consumptiontable c WHERE c.quantity = :quantity")})
public class Consumptiontable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CONSUMPTIONID")
    private Integer consumptionid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONSUMPTIONDATE")
    @Temporal(TemporalType.DATE)
    private Date consumptiondate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY")
    private double quantity;
    @JoinColumn(name = "FOODID", referencedColumnName = "FOODID")
    @ManyToOne(optional = false)
    private Foodtable foodid;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    @ManyToOne(optional = false)
    private Usertable userid;

    public Consumptiontable() {
    }

    public Consumptiontable(Integer consumptionid) {
        this.consumptionid = consumptionid;
    }

    public Consumptiontable(Integer consumptionid, Date consumptiondate, double quantity) {
        this.consumptionid = consumptionid;
        this.consumptiondate = consumptiondate;
        this.quantity = quantity;
    }

    public Integer getConsumptionid() {
        return consumptionid;
    }

    public void setConsumptionid(Integer consumptionid) {
        this.consumptionid = consumptionid;
    }

    public Date getConsumptiondate() {
        return consumptiondate;
    }

    public void setConsumptiondate(Date consumptiondate) {
        this.consumptiondate = consumptiondate;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Foodtable getFoodid() {
        return foodid;
    }

    public void setFoodid(Foodtable foodid) {
        this.foodid = foodid;
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
        hash += (consumptionid != null ? consumptionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consumptiontable)) {
            return false;
        }
        Consumptiontable other = (Consumptiontable) object;
        if ((this.consumptionid == null && other.consumptionid != null) || (this.consumptionid != null && !this.consumptionid.equals(other.consumptionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "calorietracker.Consumptiontable[ consumptionid=" + consumptionid + " ]";
    }
    
}
