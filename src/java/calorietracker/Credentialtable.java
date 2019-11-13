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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Harsh
 */
@Entity
@Table(name = "CREDENTIALTABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Credentialtable.findAll", query = "SELECT c FROM Credentialtable c")
    , @NamedQuery(name = "Credentialtable.findByUserid", query = "SELECT c FROM Credentialtable c WHERE c.userid = :userid")
    , @NamedQuery(name = "Credentialtable.findByUsername", query = "SELECT c FROM Credentialtable c WHERE c.username = :username")
    , @NamedQuery(name = "Credentialtable.findByPasswordhash", query = "SELECT c FROM Credentialtable c WHERE c.passwordhash = :passwordhash")
    , @NamedQuery(name = "Credentialtable.findBySignupdate", query = "SELECT c FROM Credentialtable c WHERE c.signupdate = :signupdate")
    , @NamedQuery(name = "Credentialtable.findByPasswordAndUsername", query = "SELECT c FROM Credentialtable c WHERE c.username = :username AND c.passwordhash = :passwordhash")})
public class Credentialtable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USERID")
    private Integer userid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "PASSWORDHASH")
    private String passwordhash;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SIGNUPDATE")
    @Temporal(TemporalType.DATE)
    private Date signupdate;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usertable usertable;

    public Credentialtable() {
    }

    public Credentialtable(Integer userid) {
        this.userid = userid;
    }

    public Credentialtable(Integer userid, String username, String passwordhash, Date signupdate) {
        this.userid = userid;
        this.username = username;
        this.passwordhash = passwordhash;
        this.signupdate = signupdate;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordhash() {
        return passwordhash;
    }

    public void setPasswordhash(String passwordhash) {
        this.passwordhash = passwordhash;
    }

    public Date getSignupdate() {
        return signupdate;
    }

    public void setSignupdate(Date signupdate) {
        this.signupdate = signupdate;
    }

    public Usertable getUsertable() {
        return usertable;
    }

    public void setUsertable(Usertable usertable) {
        this.usertable = usertable;
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
        if (!(object instanceof Credentialtable)) {
            return false;
        }
        Credentialtable other = (Credentialtable) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "calorietracker.Credentialtable[ userid=" + userid + " ]";
    }
    
}
