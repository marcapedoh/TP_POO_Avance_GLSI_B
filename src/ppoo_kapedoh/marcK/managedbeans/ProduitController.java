/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ppoo_kapedoh.marcK.managedbeans;

import java.util.ArrayList;
import java.util.List;
import ppoo_kapedoh.marcK.entities.Produit;
import ppoo_kapedoh.marcK.services.implementations.ProduitServicesImpl;

/**
 *
 * @author adral
 */
public class ProduitController {
    
    private ProduitServicesImpl mesService;

    public ProduitController() {
        this.mesService = new ProduitServicesImpl();
    }
    
    public void instances(){
        List<Produit> listProd= new ArrayList<>();
        listProd.add(new Produit(1,"Epargne","O"));
        listProd.add(new Produit(2,"Courant","N"));
        
        for(Produit p:listProd){
            mesService.save(p);
        }
    }
}
