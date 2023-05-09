package Controlers;

import Tools.ConnexionBDD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlCommande
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlCommande() {
        cnx = ConnexionBDD.getCnx();
    }

    public int getDernierNumeroDeCommande()
    {
        int maxNumero = 0;

        // A vous de jouer
        try{
            ps = cnx.prepareStatement("SELECT MAX(numCde), numCli, numLiv FROM `commandes` GROUP BY numCde");
            //ps.setInt(1, maxNumero);
            rs = ps.executeQuery();
            if (rs.next()) {
                maxNumero = rs.getInt(1);}
            ps.close();
            rs.close();
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erreur requete sql6");
        }

        return maxNumero;
    }
    public void InsertConsultation(int numCde, int numClient,int numLivreur)
    {
        // A vous de jouer
        try {
            ps = cnx.prepareStatement("insert into commandes values (?,?,?)");
            rs = ps.executeQuery();
            ps.setInt(1, numCde);
            ps.setInt(2, numClient);
            ps.setInt(3, numLivreur);


            ps.executeUpdate();
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erreur requete sql7");
        }

    }
}
