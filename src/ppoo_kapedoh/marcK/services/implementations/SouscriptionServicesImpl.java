/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ppoo_kapedoh.marcK.services.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ppoo_kapedoh.marcK.entities.Souscription;
import ppoo_kapedoh.marcK.services.SouscriptionServices;
import ppoo_kapedoh.marcK.utils.ConnectBD;

/**
 *
 * @author adral
 */
public class SouscriptionServicesImpl implements SouscriptionServices{

    
    
    private boolean VerifierDoublonSouscription(int id){
        boolean retour=false;
         Connection connexion= ConnectBD.seConnecter();
        PreparedStatement ps=null;
        String selectionUnique="select * from Souscription where idSous=?";
        try {
            
            ps=connexion.prepareStatement(selectionUnique);
            ps.setInt(1, id);
        } catch (SQLException ex) {
            Logger.getLogger(SouscriptionServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SouscriptionServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(connexion!=null){
            try {
                connexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(SouscriptionServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(SouscriptionServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(fetchallasPhp!=null){
            try {
                fetchallasPhp.close();
            } catch (SQLException ex) {
                Logger.getLogger(SouscriptionServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retour;
    }
    @Override
    public void save(Souscription souscription,String nomClient,String libelleProduit) {
         Connection connexion= ConnectBD.seConnecter();
        PreparedStatement ps=null;
        if(!VerifierDoublonSouscription(souscription.getIdSous())){
            String InsertSql="insert into Souscription(idSous,idProduit,idClient,dateHeureSous,actif) "
                    + "values(?,(select idProduit from produit where libelle=?),"
                    + "(select idClient from client where nom=?),?,?)";
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedDate = formatter.format(Date.from(Instant.now()));
                ps=connexion.prepareStatement(InsertSql);
                ps.setInt(1, souscription.getIdSous());
                ps.setString(2, libelleProduit);
                ps.setString(3, nomClient);
                ps.setString(4, formattedDate);
                ps.setString(5, souscription.getActif());
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(SouscriptionServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            String req="update souscription set dateHeureSous=?, actif=? where idSous=(select idSous from sms where dateHeureSous=?)";
            System.out.println("une nouvelle date a été ajouté pour modifier l'objet existant!");
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedDate = formatter.format(Date.from(Instant.now()));
                ps=connexion.prepareStatement(req); 
                ps.setString(1, formattedDate);
                ps.setString(2, souscription.getActif());
                ps.setString(3, String.valueOf(souscription.getDateHeureSous()));
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(SouscriptionServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
           if(connexion!=null){
            try {
                connexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(SouscriptionServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(SouscriptionServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }   
           
        }
        
        
    }

    @Override
    public List<Souscription> findAll() {
         List<Souscription> listeSouscription=null;
        String reqSql="select * from Souscription";
         Connection connexion= ConnectBD.seConnecter();
        PreparedStatement ps=null;
        try {
            ps=connexion.prepareStatement(reqSql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SouscriptionServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs=null;
        try {
            rs= ps.executeQuery();
            while(rs.next()){
                 listeSouscription.add(new Souscription(rs.getDate(1),rs.getString(2)));
             }
        } catch (SQLException ex) {
            Logger.getLogger(SouscriptionServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        if(connexion!=null){
             try {
                 connexion.close();
             } catch (SQLException ex) {
                 Logger.getLogger(SouscriptionServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        if(rs!=null){
             try {
                 rs.close();
             } catch (SQLException ex) {
                 Logger.getLogger(SouscriptionServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        return listeSouscription;
    }

    @Override
    public Souscription findById(int id) {
        Souscription sous=new Souscription();
         Connection connexion= ConnectBD.seConnecter();
        PreparedStatement ps=null;
        if(id!=0){
            String req="select * from souscription where id=?";
            
            try {
                ps=connexion.prepareStatement(req);
                 ps.setInt(1, id);
            } catch (SQLException ex) {
                Logger.getLogger(SouscriptionServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            ResultSet rs=null;
            try {
                rs=ps.executeQuery();
                if(rs.next()){
                    sous.setDateHeureSous(rs.getDate(1));
                    sous.setActif(rs.getString(2));
                }
            } catch (SQLException ex) {
                Logger.getLogger(SouscriptionServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(connexion!=null){
                try {
                    connexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SouscriptionServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SouscriptionServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        return sous;
    }

    @Override
    public void deleteById(int k) {
         Connection connexion= ConnectBD.seConnecter();
        PreparedStatement ps=null;
        if(k!=0){
           String req="delete from sms where idSms=?";
            try {
                ps=connexion.prepareStatement(req);
                ps.setInt(1, k);
               ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(SouscriptionServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
           if(connexion!=null){
               try {
                   connexion.close();
               } catch (SQLException ex) {
                   Logger.getLogger(SouscriptionServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
               }  
           }
           if(ps!=null){
               try {
                   ps.close();
               } catch (SQLException ex) {
                   Logger.getLogger(SouscriptionServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       }
    }
    
}
