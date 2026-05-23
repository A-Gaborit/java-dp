
package org.sebsy.state;

import java.util.ArrayList;
import java.util.List;

public class Commande {
    private CommandeState etat;
    private List<Produit> produits;
    private double montant;
    private String adresse;

    public Commande() {
        this.etat = new CreationState();
        this.produits = new ArrayList<>();
    }

    public void ajouterProduit(Produit produit) {
        etat.ajouterProduit(this, produit);
    }

    public void payer() {
        etat.payer(this);
    }

    public void livrer(String adresse) {
        etat.livrer(this, adresse);
    }

    public void annuler() {
        etat.annuler(this);
    }

    public CommandeState getEtat() {
        return etat;
    }

    public void setEtat(CommandeState etat) {
        this.etat = etat;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}