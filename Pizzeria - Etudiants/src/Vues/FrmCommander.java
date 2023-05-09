package Vues;

import Controlers.*;
import Entities.Client;
import Entities.Livreur;
import Entities.Pizza;
import Tools.ConnexionBDD;
import Tools.ModelJTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class FrmCommander extends JFrame{
    private JPanel pnlRoot;
    private JLabel lblTitre;
    private JLabel lblNumCommande;
    private JTextField txtNumCommande;
    private JLabel lblClients;
    private JComboBox cboClients;
    private JLabel lblLivreurs;
    private JTable tblPizzas;
    private JComboBox cboLivreurs;
    private JButton btnCommander;
    ConnexionBDD cnx;
    ConnexionBDD maCnx;
    private CtrlClient ctrlClient;
    private  ModelJTable mdl;
    private CtrlPizza ctrlPizza ;
    private CtrlCommande ctrlCommande;
    private CtrlLivreur ctrlLivreur;
    private CtrlLigneCommande ctrlLigneCommande;

    public FrmCommander() throws SQLException, ClassNotFoundException {
        this.setTitle("Commander");
        this.setContentPane(pnlRoot);
        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        ConnexionBDD maCnx = new ConnexionBDD();
        cnx = new ConnexionBDD();
        int numClient = Integer.parseInt(tblPizzas.getValueAt(tblPizzas.getSelectedRow(), 0).toString());
        ctrlClient = new CtrlClient();
        mdl = new ModelJTable();
        //mdl.loadDatasPizzas(ctrlClient.getAllClients());
        ctrlPizza = new CtrlPizza();
        mdl = new ModelJTable();
        mdl.loadDatasPizzas(ctrlPizza.getAllPizzas());
        tblPizzas.setModel(mdl);
        txtNumCommande.setText(String.valueOf(ctrlClient.getIdClientByName(String.valueOf(numClient))));
        for (Client client:ctrlClient.getAllClients())
        {
            cboClients.addItem(client.getNomCli());
        }
        for (Livreur livreur:ctrlLivreur.getAllLivreurs())
        {
            cboLivreurs.addItem(livreur.getNomLiv());
        }
        // A vous de jouer
        tblPizzas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ctrlPizza = new CtrlPizza();
                mdl = new ModelJTable();
                mdl.loadDatasPizzas(ctrlPizza.getAllPizzas());
                tblPizzas.setModel(mdl);




            }
        });

        btnCommander.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // A vous de jouer

                if(tblPizzas.getSelectedRowCount() == 0)
                {
                    JOptionPane.showMessageDialog(null, "Sélectionner une Pizza","Choix de la pizza",JOptionPane.WARNING_MESSAGE);
                }
                else {
                    // Récupérer la quantité
                    int qte = ctrlLigneCommande.InsertLigneCommande();


                    if (ctrlLigneCommande.InsertLigneCommande(qte, tblPizzas.getValueAt(tblPizzas.getSelectedRow(), 5).toString());) {
                        ctrlPizza.(txtTitreArticle.getText(), Integer.parseInt(spNbFeuillets.getValue().toString()), numPigiste, Integer.parseInt(tblMagazines.getValueAt(tblMagazines.getSelectedRow(), 0).toString()));
                        InfosArticles();
                    }

                }

            }
        });
    }
}
