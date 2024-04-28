/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ppoo_kapedoh.marcK.services;

import java.util.List;
import ppoo_kapedoh.marcK.entities.Client;

/**
 *
 * @author adral
 */
public interface ClientServices {
     void save(final Client t);
    List<Client> findAll();
    Client findById(int k);
    
    void deleteById(int k);
}
