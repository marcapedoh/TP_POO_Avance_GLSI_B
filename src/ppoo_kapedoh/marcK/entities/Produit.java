/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ppoo_kapedoh.marcK.entities;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author adral
 */
public class Produit {

   
    private Integer idProduit;
    private String libelle;
    private String actif;
    private List<Souscription> souscriptionList;

    public Produit(String libelle, String actif) {
        Scanner sc= new Scanner(System.in);
        System.out.println("debut");
       while (!actif.equalsIgnoreCase("O") && !actif.equalsIgnoreCase("N")) {
        System.out.println("Vous devez fournir (O/N)\n"
                + "O - Oui actif\n"
                + "N - Non actif");
        actif = sc.next().toLowerCase();
        }
        System.out.println("fin");
        this.libelle = libelle;
        this.actif = actif;
    }

    public Produit() {
    }

    public Produit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public Produit(Integer idProduit, String libelle, String actif) {
        this.idProduit = idProduit;
        this.libelle = libelle;
        this.actif = actif;
    }
    

    public Integer getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getActif() {
        return actif;
    }

    public void setActif(String actif) {
        this.actif = actif;
    }

    public List<Souscription> getSouscriptionList() {
        return souscriptionList;
    }

    public void setSouscriptionList(List<Souscription> souscriptionList) {
        this.souscriptionList = souscriptionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduit != null ? idProduit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.idProduit == null && other.idProduit != null) || (this.idProduit != null && !this.idProduit.equals(other.idProduit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ppoo_kapedoh.marcK.entities.Produit[ idProduit=" + idProduit + " ]";
    }
    
}
