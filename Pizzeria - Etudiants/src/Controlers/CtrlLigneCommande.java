package Controlers;

import Tools.ConnexionBDD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlLigneCommande
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlLigneCommande() {
        cnx = ConnexionBDD.getCnx();
    }

    public void InsertLigneCommande(int numCommande, String numPizza,int quantite)
    {
        // A vous de jouer
        try {
            ps = cnx.prepareStatement("insert into lignescommandes values (?,?,?)");
            rs = ps.executeQuery();
            ps.setInt(1, numCommande);
            ps.setString(2, numPizza);
            ps.setInt(3, quantite);


            ps.executeUpdate();
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erreur requete sql4");
        }

    }
}
