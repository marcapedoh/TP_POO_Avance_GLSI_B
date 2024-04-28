/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ppoo_kapedoh.marcK.services;

import java.util.List;
import ppoo_kapedoh.marcK.entities.Souscription;

/**
 *
 * @author adral
 */
public interface SouscriptionServices {
     void save(Souscription t,String nomClient,String libelleProduit);
    List<Souscription> findAll();
    Souscription findById(int k);
    void deleteById(int k);
}
