/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calorietracker;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Harsh
 */
@Entity
@Table(name = "USERTABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usertable.findAll", query = "SELECT u FROM Usertable u")
    , @NamedQuery(name = "Usertable.findByUserid", query = "SELECT u FROM Usertable u WHERE u.userid = :userid")
    , @NamedQuery(name = "Usertable.findByFirstname", query = "SELECT u FROM Usertable u WHERE u.firstname = :firstname")
    , @NamedQuery(name = "Usertable.findByLastname", query = "SELECT u FROM Usertable u WHERE u.lastname = :lastname")
    , @NamedQuery(name = "Usertable.findByEmailid", query = "SELECT u FROM Usertable u WHERE u.emailid = :emailid")
    , @NamedQuery(name = "Usertable.findByDob", query = "SELECT u FROM Usertable u WHERE u.dob = :dob")
    , @NamedQuery(name = "Usertable.findByHeight", query = "SELECT u FROM Usertable u WHERE u.height = :height")
    , @NamedQuery(name = "Usertable.findByWeight", query = "SELECT u FROM Usertable u WHERE u.weight = :weight")
    , @NamedQuery(name = "Usertable.findByGender", query = "SELECT u FROM Usertable u WHERE u.gender = :gender")
    , @NamedQuery(name = "Usertable.findByAddress", query = "SELECT u FROM Usertable u WHERE u.address = :address")
    , @NamedQuery(name = "Usertable.findByPostcode", query = "SELECT u FROM Usertable u WHERE u.postcode = :postcode")
    , @NamedQuery(name = "Usertable.findByLevelofactivity", query = "SELECT u FROM Usertable u WHERE u.levelofactivity = :levelofactivity")
    , @NamedQuery(name = "Usertable.findByStepspermile", query = "SELECT u FROM Usertable u WHERE u.stepspermile = :stepspermile")})
public class Usertable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "USERID")
    private Integer userid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 20)
    @Column(name = "LASTNAME")
    private String lastname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAILID")
    private String emailid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HEIGHT")
    private double height;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WEIGHT")
    private double weight;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GENDER")
    private Character gender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "ADDRESS")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Column(name = "POSTCODE")
    private int postcode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LEVELOFACTIVITY")
    private int levelofactivity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STEPSPERMILE")
    private int stepspermile;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<Consumptiontable> consumptiontableCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<Reporttable> reporttableCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usertable")
    private Credentialtable credentialtable;

    public Usertable() {
    }

    public Usertable(Integer userid) {
        this.userid = userid;
    }

    public Usertable(Integer userid, String firstname, String emailid, Date dob, double height, double weight, Character gender, String address, int postcode, int levelofactivity, int stepspermile) {
        this.userid = userid;
        this.firstname = firstname;
        this.emailid = emailid;
        this.dob = dob;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.address = address;
        this.postcode = postcode;
        this.levelofactivity = levelofactivity;
        this.stepspermile = stepspermile;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public int getLevelofactivity() {
        return levelofactivity;
    }

    public void setLevelofactivity(int levelofactivity) {
        this.levelofactivity = levelofactivity;
    }

    public int getStepspermile() {
        return stepspermile;
    }

    public void setStepspermile(int stepspermile) {
        this.stepspermile = stepspermile;
    }

    @XmlTransient
    public Collection<Consumptiontable> getConsumptiontableCollection() {
        return consumptiontableCollection;
    }

    public void setConsumptiontableCollection(Collection<Consumptiontable> consumptiontableCollection) {
        this.consumptiontableCollection = consumptiontableCollection;
    }

    @XmlTransient
    public Collection<Reporttable> getReporttableCollection() {
        return reporttableCollection;
    }

    public void setReporttableCollection(Collection<Reporttable> reporttableCollection) {
        this.reporttableCollection = reporttableCollection;
    }

    @XmlTransient
    public Credentialtable getCredentialtable() {
        return credentialtable;
    }

    public void setCredentialtable(Credentialtable credentialtable) {
        this.credentialtable = credentialtable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usertable)) {
            return false;
        }
        Usertable other = (Usertable) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "calorietracker.Usertable[ userid=" + userid + " ]";
    }
    
}
