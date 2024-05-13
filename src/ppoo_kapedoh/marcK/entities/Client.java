/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ppoo_kapedoh.marcK.entities;

import java.util.List;

/**
 *
 * @author HP
 */
public class Client{

  
    private Integer idClient;
   
    private String nom;
    
    private String prenom;
   
    private String telephone;
    
    private List<Sms> smsCollection;
    
    private List<Souscription> souscriptionCollection;

    public Client() {
    }

    public Client(Integer idClient) {
        this.idClient = idClient;
    }

    public Client(Integer idClient, String nom, String prenom, String telephone) {
        this.idClient = idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }

    public Client(String nom, String prenom, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }
    

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Sms> getSmsCollection() {
        return smsCollection;
    }

    public void setSmsCollection(List<Sms> smsCollection) {
        this.smsCollection = smsCollection;
    }

    public List<Souscription> getSouscriptionCollection() {
        return souscriptionCollection;
    }

    public void setSouscriptionCollection(List<Souscription> souscriptionCollection) {
        this.souscriptionCollection = souscriptionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClient != null ? idClient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.idClient == null && other.idClient != null) || (this.idClient != null && !this.idClient.equals(other.idClient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ppoo_kApedoh.marcK.entities.Client[ idClient=" + idClient + " ]";
    }
    
}

