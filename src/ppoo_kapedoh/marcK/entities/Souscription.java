/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ppoo_kapedoh.marcK.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.Scanner;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author adral
 */
@Entity
@Table(name = "souscription")
@NamedQueries({
    @NamedQuery(name = "Souscription.findAll", query = "SELECT s FROM Souscription s"),
    @NamedQuery(name = "Souscription.findByIdSous", query = "SELECT s FROM Souscription s WHERE s.idSous = :idSous"),
    @NamedQuery(name = "Souscription.findByDateHeureSous", query = "SELECT s FROM Souscription s WHERE s.dateHeureSous = :dateHeureSous"),
    @NamedQuery(name = "Souscription.findByActif", query = "SELECT s FROM Souscription s WHERE s.actif = :actif")})
public class Souscription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idSous")
    private Integer idSous;
    @Column(name = "dateHeureSous")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeureSous;

    public Souscription(Date dateHeureSous, String actif) {
        this.dateHeureSous = dateHeureSous;
        this.actif = actif;
    }
    @Column(name = "actif")
    private String actif;
    @JoinColumn(name = "idProduit", referencedColumnName = "idProduit")
    @ManyToOne
    private Produit idProduit;

    public Souscription() {
    }

    
    public Souscription(Integer idSous,String actif) {
        Scanner sc= new Scanner(System.in);
        while(!actif.equalsIgnoreCase("O") && !actif.equalsIgnoreCase("N")){
            System.out.println("entrez (o/n) pour activer ou non la souscription");
            actif=sc.next();
        }
        this.idSous=idSous;
        this.dateHeureSous=Date.from(Instant.now());
        this.actif=actif;
    }

    public Souscription(Integer idSous) {
        this.idSous = idSous;
    }

    public Integer getIdSous() {
        return idSous;
    }

    public void setIdSous(Integer idSous) {
        this.idSous = idSous;
    }

    public Date getDateHeureSous() {
        return dateHeureSous;
    }

    public void setDateHeureSous(Date dateHeureSous) {
        this.dateHeureSous = dateHeureSous;
    }

    public String getActif() {
        return actif;
    }

    public void setActif(String actif) {
        this.actif = actif;
    }

    public Produit getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Produit idProduit) {
        this.idProduit = idProduit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSous != null ? idSous.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Souscription)) {
            return false;
        }
        Souscription other = (Souscription) object;
        if ((this.idSous == null && other.idSous != null) || (this.idSous != null && !this.idSous.equals(other.idSous))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ppoo_kapedoh.marcK.entities.Souscription[ idSous=" + idSous + " ]";
    }
    
}
