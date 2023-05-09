package Controlers;

import Entities.Livreur;
import Entities.Pizza;
import Tools.ConnexionBDD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlLivreur
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlLivreur() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<Livreur> getAllLivreurs()
    {
        ArrayList<Livreur> lesLivreurs = new ArrayList<>();

        // A vous de jouer
        try {
            ps = cnx.prepareStatement("SELECT nomLiv, numLiv FROM `livreurs`");
            rs = ps.executeQuery();
            while (rs.next()) {
                Livreur livreur = new Livreur(rs.getString("nomLiv"),rs.getInt("numLiv"));
                lesLivreurs.add(livreur);
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erreur requete sql1");
        }

        return lesLivreurs;
    }
    public int getIdLivreurByName(String nomLiv)
    {
        int numLiv = 0;

        // A vous de jouer
        try{
            ps = cnx.prepareStatement("SELECT nomLiv +\n" +
                    "                    FROM `livreurs`");
            ps.setString(1, nomLiv);
            rs = ps.executeQuery();
            if (rs.next()) {
                numLiv = rs.getInt("nomCli");}
            ps.close();
            rs.close();
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erreur requete sql5");
        }

        return numLiv;
    }
}
