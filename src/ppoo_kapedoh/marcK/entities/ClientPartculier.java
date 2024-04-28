/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ppoo_kapedoh.marcK.entities;

import java.util.Date;

/**
 *
 * @author adral
 */
public class ClientPartculier extends Client{

   
    private Date dateNais;
    private String lieuDeNais;

    public ClientPartculier(Date dateNais, String lieuDeNais) {
        this.dateNais = dateNais;
        this.lieuDeNais = lieuDeNais;
    }

    public ClientPartculier(Date dateNais, String lieuDeNais, Integer idClient) {
        super(idClient);
        this.dateNais = dateNais;
        this.lieuDeNais = lieuDeNais;
    }

    public ClientPartculier(Date dateNais, String lieuDeNais, Integer idClient, String nom, String prenom, String telephone) {
        super(idClient, nom, prenom, telephone);
        this.dateNais = dateNais;
        this.lieuDeNais = lieuDeNais;
    }

    public ClientPartculier(Date dateNais, String lieuDeNais, String nom, String prenom, String telephone) {
        super(nom, prenom, telephone);
        this.dateNais = dateNais;
        this.lieuDeNais = lieuDeNais;
    }

    
    public Date getDateNais() {
        return dateNais;
    }

    public void setDateNais(Date dateNais) {
        this.dateNais = dateNais;
    }

    public String getLieuDeNais() {
        return lieuDeNais;
    }

    public void setLieuDeNais(String lieuDeNais) {
        this.lieuDeNais = lieuDeNais;
    }

    @Override
    public String toString() {
        return "ClientPartculier{" + "dateNais=" + dateNais + ", lieuDeNais=" + lieuDeNais + '}';
    }
    
}
