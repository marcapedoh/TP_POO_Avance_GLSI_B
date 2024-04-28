/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ppoo_kapedoh.marcK.managedbeans;

import java.util.ArrayList;
import java.util.List;
import ppoo_kapedoh.marcK.entities.Souscription;
import ppoo_kapedoh.marcK.services.implementations.SouscriptionServicesImpl;

/**
 *
 * @author adral
 */
public class SouscriptionController {
    
    private SouscriptionServicesImpl souscriptionService;

    public SouscriptionController() {
        this.souscriptionService = new SouscriptionServicesImpl();
    }
    
    public void instances(){
        Souscription sous=new Souscription(1,"o");
        Souscription sous1=new Souscription(2,"n");
        souscriptionService.save(sous, "APEDOH", "Epargne");
        souscriptionService.save(sous1, "DEBM", "Courant");
    }
}
