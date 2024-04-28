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
import ppoo_kapedoh.marcK.entities.Produit;
import ppoo_kapedoh.marcK.services.ProduitServices;
import ppoo_kapedoh.marcK.utils.ConnectBD;

/**
 *
 * @author adral
 */
public class ProduitServicesImpl implements ProduitServices {
    
    
    private boolean VerifierDoublonProduit(String libelle){
        boolean retour=false;
        String selectionUnique="select * from Produit where libelle=?";
         Connection connexion= ConnectBD.seConnecter();
         PreparedStatement ps=null;
        try {
            ps=connexion.prepareStatement(selectionUnique);
            ps.setString(1, libelle);
        } catch (SQLException ex) {
            Logger.getLogger(ProduitServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ProduitServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(connexion!=null){
            try {
                connexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProduitServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProduitServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(fetchallasPhp!=null){
            try {
                fetchallasPhp.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProduitServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retour;
    }

    @Override
    public void save(Produit produit) {
         Connection connexion= ConnectBD.seConnecter();
         PreparedStatement ps=null;
        if(!VerifierDoublonProduit(produit.getLibelle())){
            String InsertSql="insert into Produit(idProduit,actif,libelle) values(?,?,?)";
           try {
               ps=connexion.prepareStatement(InsertSql);
               ps.setInt(1,produit.getIdProduit());
               ps.setString(2,produit.getActif());
                ps.setString(3,produit.getLibelle());
                ps.executeUpdate();
           } catch (SQLException ex) {
               Logger.getLogger(ProduitServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
           }
        }else{
            String req="update produit set actif=? ,libelle=? where idProduit=(select idProduit from produit where libelle=?)";
           try {
              Scanner sc= new Scanner(System.in);
               System.out.println("on vous demandera un nouveau libelle sous peu!");
               ps=connexion.prepareStatement(req);
               ps.setString(1, sc.nextLine());
               ps.setString(2, sc.nextLine());
                ps.setString(3, produit.getLibelle());
                ps.executeUpdate();
                sc.close();
           } catch (SQLException ex) {
               Logger.getLogger(ProduitServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
           } 
           if(connexion!=null){
            try {
                connexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProduitServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            } 
         }
            if(ps!=null){
               try {
                   ps.close();
               } catch (SQLException ex) {
                   Logger.getLogger(ProduitServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
               }

            }
        }
        
        
    }

    @Override
    public List<Produit> findAll() {
        List<Produit> listeProduit=null;
        String reqSql="select * from Produit";
        Connection connexion= ConnectBD.seConnecter();
         PreparedStatement ps=null;
        try {
            ps=connexion.prepareStatement(reqSql);
        } catch (SQLException ex) {
            Logger.getLogger(ProduitServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
         ResultSet rs=null;
         
        try {
            rs= ps.executeQuery();
            while(rs.next()){
                 listeProduit.add(new Produit(rs.getString(2),rs.getString(3)));
             }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(connexion!=null){
            try {
                connexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProduitServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProduitServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        return listeProduit;
    }

    @Override
    public Produit findById(int id) {
       Produit p1=new Produit();
       Connection connexion= ConnectBD.seConnecter();
         PreparedStatement ps=null;
        if(id!=0){
            String req="select * from Produit where idProduit=?";
            
           try {
               ps=connexion.prepareStatement(req);
               ps.setInt(1, id);
           } catch (SQLException ex) {
               Logger.getLogger(ProduitServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
           }
            
            ResultSet rs=null;
            
           try {
               rs=ps.executeQuery();
                if(rs.next()){
                    p1.setIdProduit(rs.getInt(1));
                    p1.setActif(rs.getString(2));
                    p1.setLibelle(rs.getString(3));
                }
           } catch (SQLException ex) {
               Logger.getLogger(ProduitServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
           }
            if(connexion!=null){
                try {
                    connexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProduitServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProduitServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        return p1;
       
    }

    @Override
    public void deleteById(int k) {
        Connection connexion= ConnectBD.seConnecter();
         PreparedStatement ps=null;
        if(k!=0){
           String req="delete from produit where idProduit=?";
           
            try {
                ps=connexion.prepareStatement(req);
                ps.setInt(1, k);
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ProduitServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
           if(connexion!=null){
               try {
                   connexion.close();
               } catch (SQLException ex) {
                   Logger.getLogger(ProduitServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
               }
               
           }
           if(ps!=null){
               try {
                   ps.close();
               } catch (SQLException ex) {
                   Logger.getLogger(ProduitServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
               }
               
           }
       }
    }
    
}
