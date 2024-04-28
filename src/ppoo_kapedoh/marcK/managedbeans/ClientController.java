/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ppoo_kapedoh.marcK.managedbeans;

import java.util.ArrayList;
import java.util.List;
import ppoo_kapedoh.marcK.entities.Client;
import ppoo_kapedoh.marcK.services.implementations.ClientServicesImpl;

/**
 *
 * @author adral
 */
public class ClientController {
    private ClientServicesImpl monService;

    public ClientController(ClientServicesImpl monService) {
        this.monService = monService;
    }

    public ClientController() {
        this.monService=new ClientServicesImpl();
    }
    
    public void instances(){
        List<Client> clients=new ArrayList<>();
        clients.add(new Client(1,"APEDOH","Marc","+22870344482"));
        clients.add(new Client(2,"DEBM","Mrc&Bititi","+2289494745"));
        clients.add(new Client(3,"AGBA","Pam","+2287985143558"));
        clients.add(new Client(4,"LEMOU","laelae","+3376528155"));
        for(Client client: clients){
            monService.save(client);
        }
    }
}
