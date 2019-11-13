    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calorietracker;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Harsh
 */
@Entity
@Table(name = "FOODTABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Foodtable.findAll", query = "SELECT f FROM Foodtable f")
    , @NamedQuery(name = "Foodtable.findByFoodid", query = "SELECT f FROM Foodtable f WHERE f.foodid = :foodid")
    , @NamedQuery(name = "Foodtable.findByFoodname", query = "SELECT f FROM Foodtable f WHERE f.foodname = :foodname")
    , @NamedQuery(name = "Foodtable.findByCategory", query = "SELECT f FROM Foodtable f WHERE f.category = :category")
    , @NamedQuery(name = "Foodtable.findByCalorie", query = "SELECT f FROM Foodtable f WHERE f.calorie = :calorie")
    , @NamedQuery(name = "Foodtable.findByServingunit", query = "SELECT f FROM Foodtable f WHERE f.servingunit = :servingunit")
    , @NamedQuery(name = "Foodtable.findByServingamount", query = "SELECT f FROM Foodtable f WHERE f.servingamount = :servingamount")
    , @NamedQuery(name = "Foodtable.findByFat", query = "SELECT f FROM Foodtable f WHERE f.fat = :fat")})
public class Foodtable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FOODID")
    private Integer foodid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "FOODNAME")
    private String foodname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CATEGORY")
    private String category;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CALORIE")
    private double calorie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "SERVINGUNIT")
    private String servingunit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SERVINGAMOUNT")
    private String servingamount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FAT")
    private double fat;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foodid")
    private Collection<Consumptiontable> consumptiontableCollection;

    public Foodtable() {
    }

    public Foodtable(Integer foodid) {
        this.foodid = foodid;
    }

    public Foodtable(Integer foodid, String foodname, String category, double calorie, String servingunit, String servingamount, double fat) {
        this.foodid = foodid;
        this.foodname = foodname;
        this.category = category;
        this.calorie = calorie;
        this.servingunit = servingunit;
        this.servingamount = servingamount;
        this.fat = fat;
    }

    public Integer getFoodid() {
        return foodid;
    }

    public void setFoodid(Integer foodid) {
        this.foodid = foodid;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getCalorie() {
        return calorie;
    }

    public void setCalorie(double calorie) {
        this.calorie = calorie;
    }

    public String getServingunit() {
        return servingunit;
    }

    public void setServingunit(String servingunit) {
        this.servingunit = servingunit;
    }

    public String getServingamount() {
        return servingamount;
    }

    public void setServingamount(String servingamount) {
        this.servingamount = servingamount;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    @XmlTransient
    public Collection<Consumptiontable> getConsumptiontableCollection() {
        return consumptiontableCollection;
    }

    public void setConsumptiontableCollection(Collection<Consumptiontable> consumptiontableCollection) {
        this.consumptiontableCollection = consumptiontableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (foodid != null ? foodid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Foodtable)) {
            return false;
        }
        Foodtable other = (Foodtable) object;
        if ((this.foodid == null && other.foodid != null) || (this.foodid != null && !this.foodid.equals(other.foodid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "calorietracker.Foodtable[ foodid=" + foodid + " ]";
    }
    
}
