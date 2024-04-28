/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ppoo_kapedoh.marcK.services.implementations;

import java.util.List;
import java.sql.*;
import java.util.Scanner;
import ppoo_kapedoh.marcK.entities.Client;
import ppoo_kapedoh.marcK.services.ClientServices;
import ppoo_kapedoh.marcK.utils.ConnectBD;

/**
 *
 * @author adral
 */
public class ClientServicesImpl implements ClientServices {
    
    
     private boolean VerifierDoublonClient(String nom_client){
        boolean retour=false;
         PreparedStatement ps=null;
         Connection connexion= ConnectBD.seConnecter();
        String selectionUnique="select * from client where nom=?";
         try {
             ps=connexion.prepareStatement(selectionUnique);
             ps.setString(1,nom_client);
         } catch (SQLException ex) {
             java.util.logging.Logger.getLogger(ClientServicesImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
           
        
        ResultSet fetchallasPhp=null;
         try {
             fetchallasPhp=ps.executeQuery();
             if(fetchallasPhp.next()){
                retour=true;
            }
            else{
                retour=false;
            }
         } catch (SQLException ex) {
             java.util.logging.Logger.getLogger(ClientServicesImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
        if(connexion!=null){
            try {
                connexion.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(ClientServicesImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(ClientServicesImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
        
        if(fetchallasPhp!=null){
            try {
                fetchallasPhp.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(ClientServicesImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
           
        }
        return retour;
    }
    @Override
    public void save(Client client) {
        PreparedStatement ps=null;
         Connection connexion= ConnectBD.seConnecter();
        if(!VerifierDoublonClient(client.getNom())){
            String InsertSql="insert into Client(idClient,nom,prenom,telephone) values(?,?,?,?)";
           
            try {
                ps=connexion.prepareStatement(InsertSql);
                ps.setInt(1,client.getIdClient());
                ps.setString(2,client.getNom());
                ps.setString(3,client.getPrenom());
                ps.setString(4,client.getTelephone());
                ps.executeUpdate();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(ClientServicesImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            
            
        }else{
            String req="update client set nom=? , prenom=? , telephone=? where idClient=(select idClient from client where nom=?)";
                Scanner sc= new Scanner(System.in);
            try {
                ps=connexion.prepareStatement(req);
                 System.out.println(" un nouveau nom sous peu pour modifier le client!");
                ps.setString(1, sc.nextLine());
                System.out.println("un nouveau preom");
                ps.setString(2, sc.nextLine());
                System.out.println("un nouveau telephone");
                ps.setString(3, sc.nextLine());
                ps.setString(4, client.getNom());
                ps.executeUpdate();
                
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(ClientServicesImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
             
        }
        if(connexion!=null){
                try {
                    connexion.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(ClientServicesImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(ClientServicesImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
           
        
    }

    @Override
    public List<Client> findAll() {
        PreparedStatement ps=null;
         Connection connexion= ConnectBD.seConnecter();
        List<Client> listClient=null;
        String reqSql="select * from Client";
         try {
             ps=connexion.prepareStatement(reqSql);
             
         } catch (SQLException ex) {
             java.util.logging.Logger.getLogger(ClientServicesImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
         ResultSet rs=null;
         try {
             rs= ps.executeQuery();
             while(rs.next()){
                 listClient.add(new Client(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
             }
         } catch (SQLException ex) {
             java.util.logging.Logger.getLogger(ClientServicesImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
          if(connexion!=null){
         
            try {
                connexion.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(ClientServicesImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
           
        }
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(ClientServicesImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
           
        }
        return listClient;
    }

    @Override
    public Client findById(int k) {
        PreparedStatement ps=null;
         Connection connexion= ConnectBD.seConnecter();
        Client cl=new Client();
        if(k!=0){
            String req="select * from Client where id=?";
            try {
                ps=connexion.prepareStatement(req);
                ps.setInt(1, k);
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(ClientServicesImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            ResultSet rs=null;
            try {
                rs=ps.executeQuery();
                if(rs.next()){
                    cl.setIdClient(rs.getInt(1));
                    cl.setNom(rs.getString(2));
                    cl.setPrenom(rs.getString(3));
                    cl.setTelephone(rs.getString(4));
                }
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(ClientServicesImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            
            if(connexion!=null){
                try {
                    connexion.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(ClientServicesImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(ClientServicesImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
            
        }
        return cl;
       
    }

    @Override
    public void deleteById(int k) {
        PreparedStatement ps=null;
         Connection connexion= ConnectBD.seConnecter();
       if(k!=0){
           String req="delete from Client where idClient=?";
           try {
               ps=connexion.prepareStatement(req);
               ps.setInt(1, k);
               ps.executeUpdate();
           }catch (SQLException ex) {
               java.util.logging.Logger.getLogger(ClientServicesImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
           }
           
           if(connexion!=null){
               try {
                   connexion.close();
               } catch (SQLException ex) {
                   java.util.logging.Logger.getLogger(ClientServicesImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
               }
           }
           
           if(ps!=null){
               try {
                   ps.close();
               } catch (SQLException ex) {
                   java.util.logging.Logger.getLogger(ClientServicesImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
               }
           }
       }
    }
    
}
