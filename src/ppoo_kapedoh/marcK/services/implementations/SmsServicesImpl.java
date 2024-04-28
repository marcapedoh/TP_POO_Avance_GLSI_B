/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ppoo_kapedoh.marcK.services.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ppoo_kapedoh.marcK.entities.Sms;
import ppoo_kapedoh.marcK.services.SmsServices;
import ppoo_kapedoh.marcK.utils.ConnectBD;

/**
 *
 * @author adral
 */
public class SmsServicesImpl implements SmsServices {

     

    
    
    private boolean VerifierDoublonSms(String libelle){
        boolean retour=false;
        String selectionUnique="select * from Sms where libelle=?";
        Connection connexion= ConnectBD.seConnecter();
        PreparedStatement ps=null;
        try {
            ps=connexion.prepareStatement(selectionUnique);
            ps.setString(1,libelle);
        } catch (SQLException ex) {
            Logger.getLogger(SmsServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SmsServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(connexion!=null){
            try {
                connexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(SmsServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(SmsServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(fetchallasPhp!=null){
            try {
                fetchallasPhp.close();
            } catch (SQLException ex) {
                Logger.getLogger(SmsServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retour;
    }
    @Override
    public void save(Sms sms,String nom) {
        Connection connexion= ConnectBD.seConnecter();
        PreparedStatement ps=null;
        if(!VerifierDoublonSms(sms.getLibelle())){
            String InsertSql="insert into Sms(idSms,idclient,libelle) "
                    + "values(?,(select idclient from client where nom=?),?)";
           try {
               ps=connexion.prepareStatement(InsertSql);
               ps.setInt(1,sms.getIdSms());
               ps.setString(2,nom);
               ps.setString(3,sms.getLibelle());
               ps.executeUpdate();
           } catch (SQLException ex) {
               Logger.getLogger(SmsServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
           }
        }else{
            String req="update sms set libelle=? where idSms=(select idSms from sms where libelle=?)";
           
           try {
               Scanner sc= new Scanner(System.in);
               System.out.println("on vous demandera un nouveau libelle sous peu!");
               ps=connexion.prepareStatement(req);
               ps.setString(1, sc.nextLine());
               ps.setString(2, sms.getLibelle());
               ps.executeUpdate();
               sc.close();
           } catch (SQLException ex) {
               Logger.getLogger(SmsServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
           } 
        }
        if(connexion!=null){
           try {
               connexion.close();
           } catch (SQLException ex) {
               Logger.getLogger(SmsServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        if(ps!=null){
           try {
               ps.close();
           } catch (SQLException ex) {
               Logger.getLogger(SmsServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
           }     
        }
        
    }

    @Override
    public List<Sms> findAll() {
        Connection connexion= ConnectBD.seConnecter();
        PreparedStatement ps=null;
        List<Sms> listeSms=null;
        String reqSql="select * from Sms";
        try {
            ps=connexion.prepareStatement(reqSql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SmsServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
         ResultSet rs=null;
        
        try {
            rs= ps.executeQuery();
            while(rs.next()){
                 listeSms.add(new Sms(rs.getString(1)));
             }
        } catch (SQLException ex) {
            Logger.getLogger(SmsServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(connexion!=null){
            try {
                connexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(SmsServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(SmsServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listeSms;
    }

    @Override
    public Sms findById(int id) {
        Connection connexion= ConnectBD.seConnecter();
        PreparedStatement ps=null;
        Sms s=new Sms();
        if(id!=0){
            String req="select * from sms where id=?";
            try {
                ps=connexion.prepareStatement(req);
                ps.setInt(1, id);
            } catch (SQLException ex) {
                Logger.getLogger(SmsServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            ResultSet rs=null;
           
            try {
                rs=ps.executeQuery();
                if(rs.next()){
                    s.setIdSms(rs.getInt(1));
                    s.setLibelle(rs.getString(2));
                }
            } catch (SQLException ex) {
                Logger.getLogger(SmsServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(connexion!=null){
                try {
                    connexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SmsServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SmsServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        return s;
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
               Logger.getLogger(SmsServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
           }
           if(connexion!=null){
               try {
                   connexion.close();
               } catch (SQLException ex) {
                   Logger.getLogger(SmsServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
               }  
           }
           if(ps!=null){
               try {
                   ps.close();
               } catch (SQLException ex) {
                   Logger.getLogger(SmsServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
               } 
           }
       }
    }
    @Override
    public List<Sms> findAllActif() {
        Connection connexion= ConnectBD.seConnecter();
        PreparedStatement ps=null;
         List<Sms> listeSms=null;
        String reqSql="select idSms,libelle from Sms s, Client c, Souscription sous "
                + "where c.idClient=s.idClient "
                + "and sous.idClient=c.idClient "
                + "and sous.actif='O'";
        try {
            ps=connexion.prepareStatement(reqSql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SmsServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
         ResultSet rs=null;
        
        try {
            rs= ps.executeQuery();
            while(rs.next()){
                 listeSms.add(new Sms(rs.getString(1)));
             }
        } catch (SQLException ex) {
            Logger.getLogger(SmsServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(connexion!=null){
            try {
                connexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(SmsServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(SmsServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listeSms;
    }

    @Override
    public List<Sms> findAllNotActif() {
        Connection connexion= ConnectBD.seConnecter();
        PreparedStatement ps=null;
         List<Sms> listeSms=null;
        String reqSql="select idSms,libelle from Sms s, Client c, Souscription sous "
                + "where c.idClient=s.idClient "
                + "and sous.idClient=c.idClient "
                + "and sous.actif='N'";
        try {
            ps=connexion.prepareStatement(reqSql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SmsServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
         ResultSet rs=null;
        
        try {
            rs= ps.executeQuery();
            while(rs.next()){
                 listeSms.add(new Sms(rs.getInt(1),rs.getString(2)));
             }
        } catch (SQLException ex) {
            Logger.getLogger(SmsServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(connexion!=null){
            try {
                connexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(SmsServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(SmsServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listeSms;
    }
    
}
