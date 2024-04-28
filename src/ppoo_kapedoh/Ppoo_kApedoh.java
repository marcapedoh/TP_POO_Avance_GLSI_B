/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ppoo_kapedoh;

import ppoo_kapedoh.marcK.managedbeans.ClientController;
import ppoo_kapedoh.marcK.managedbeans.ProduitController;
import ppoo_kapedoh.marcK.managedbeans.SmsController;
import ppoo_kapedoh.marcK.managedbeans.SouscriptionController;

/**
 *
 * @author adral
 */
public class Ppoo_kApedoh {
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       /*ClientController controller = new ClientController();
        controller.instances();*
        /*ProduitController controllerProduit= new ProduitController();
        controllerProduit.instances();*/
        /*SouscriptionController sousC=new SouscriptionController();
        sousC.instances();*/
        
        SmsController smsC=new SmsController();
        smsC.instance();
    }
    
}
