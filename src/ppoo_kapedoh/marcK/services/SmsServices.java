/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ppoo_kapedoh.marcK.services;

import java.util.List;
import ppoo_kapedoh.marcK.entities.Sms;

/**
 *
 * @author adral
 */
public interface SmsServices {
    void save(Sms t,String nom);
    List<Sms> findAll();
    Sms findById(int k);
    void deleteById(int k);
    List<Sms> findAllActif();
    List<Sms> findAllNotActif();
}
