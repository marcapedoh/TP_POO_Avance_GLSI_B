/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ppoo_kapedoh.marcK.entities;

import java.time.Instant;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author adral
 */
public class Souscription {

  
    private Integer idSous;
   
    private Date dateHeureSous;

    public Souscription(Date dateHeureSous, String actif) {
        this.dateHeureSous = dateHeureSous;
        this.actif = actif;
    }
    
    private String actif;
   
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
