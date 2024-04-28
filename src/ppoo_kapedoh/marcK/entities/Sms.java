/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ppoo_kapedoh.marcK.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author adral
 */
@Entity
@Table(name = "sms")
@NamedQueries({
    @NamedQuery(name = "Sms.findAll", query = "SELECT s FROM Sms s"),
    @NamedQuery(name = "Sms.findByIdSms", query = "SELECT s FROM Sms s WHERE s.idSms = :idSms"),
    @NamedQuery(name = "Sms.findByLibelle", query = "SELECT s FROM Sms s WHERE s.libelle = :libelle")})
public class Sms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idSms")
    private Integer idSms;
    @Column(name = "libelle")
    private String libelle;

    public Sms() {
    }

    
    public Sms(Integer idSms) {
        this.idSms = idSms;
    }

    public Sms(Integer idSms, String libelle) {
        this.idSms = idSms;
        this.libelle = libelle;
    }
    

    public Integer getIdSms() {
        return idSms;
    }

    public void setIdSms(Integer idSms) {
        this.idSms = idSms;
    }

    public String getLibelle() {
        return libelle;
    }

    public Sms(String libelle) {
        this.libelle = libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSms != null ? idSms.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sms)) {
            return false;
        }
        Sms other = (Sms) object;
        if ((this.idSms == null && other.idSms != null) || (this.idSms != null && !this.idSms.equals(other.idSms))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ppoo_kapedoh.marcK.entities.Sms[ idSms=" + idSms + " ]";
    }
    
}
