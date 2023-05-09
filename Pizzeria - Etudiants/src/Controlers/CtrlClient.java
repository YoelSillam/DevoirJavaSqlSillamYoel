package Controlers;

import Entities.Client;
import Tools.ConnexionBDD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlClient
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlClient() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<Client> getAllClients()
    {
        ArrayList<Client> lesClients = new ArrayList<>();

        // A vous de jouer
        String Nom = "";

        try {
            ps = cnx.prepareStatement("SELECT numCli, nomCli FROM `clients` ");
            rs = ps.executeQuery();
            if (rs.next()) {
                Nom = rs.getString(1);}
            ps.close();
        } catch (SQLException ex) {

        }

        return lesClients;
    }
    public int getIdClientByName(String nomCli)
    {
        int numCli = 0;

        // A vous de jouer

        try{
            ps = cnx.prepareStatement("SELECT nomCli +\n" +
                    "                    FROM `clients`");
            ps.setString(1, nomCli);
            rs = ps.executeQuery();
            if (rs.next()) {
                numCli = rs.getInt(1);}
            ps.close();
            rs.close();
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erreur requete sql3");
        }

        return numCli;
    }
}
