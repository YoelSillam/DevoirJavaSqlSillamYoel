package Entities;


public class Livreur
{
    private String nomLiv;
    private int numLiv;

    public Livreur(String nomLiv,  int numLiv) {
        this.nomLiv = nomLiv;
        this.numLiv = numLiv;

    }

    public String getNomLiv() {
        return nomLiv;
    }


    public int getNumLiv() {
        return numLiv;
    }
}
