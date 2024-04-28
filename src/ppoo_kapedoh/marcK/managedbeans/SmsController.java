/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ppoo_kapedoh.marcK.managedbeans;

import ppoo_kapedoh.marcK.entities.Sms;
import ppoo_kapedoh.marcK.services.implementations.SmsServicesImpl;

/**
 *
 * @author adral
 */
public class SmsController {
    
    private SmsServicesImpl mesService;

    public SmsController() {
        this.mesService= new SmsServicesImpl();
    }
    
    
    public void instance(){
        Sms sms=new Sms(1,"cher client votre suscription est validé");
        Sms sms1=new Sms(2,"cher client votre suscription est en attente");
        mesService.save(sms, "APEDOH");
        mesService.save(sms1, "DEBM");
    }
    public void listeSmsEnvoyé(){
        System.out.println("collections des sms envoyé! ");
        mesService.findAllActif();
    }
    
    public void listeSmsEnAttente(){
        System.out.println("collections des sms en attente");
        mesService.findAllNotActif();
    }
}
