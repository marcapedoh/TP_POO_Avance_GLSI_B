/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ppoo_kapedoh.marcK.services;

import java.util.List;
import ppoo_kapedoh.marcK.entities.Produit;

/**
 *
 * @author adral
 */
public interface ProduitServices {
    void save(Produit t);
    List<Produit> findAll();
    Produit findById(int id);
    void deleteById(int id);
}
