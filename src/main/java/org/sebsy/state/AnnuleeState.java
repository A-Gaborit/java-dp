package org.sebsy.state;

public class AnnuleeState implements CommandeState {
    
    @Override
    public void ajouterProduit(Commande commande, Produit produit) {
        throw new IllegalStateException("Impossible d'ajouter un produit à une commande annulée");
    }
    
    @Override
    public void payer(Commande commande) {
        throw new IllegalStateException("La commande a été annulée");
    }
    
    @Override
    public void livrer(Commande commande, String adresse) {
        throw new IllegalStateException("La commande a été annulée");
    }
    
    @Override
    public void annuler(Commande commande) {
        throw new IllegalStateException("La commande a déjà été annulée");
    }
    
    @Override
    public String getNomEtat() {
        return "ANNULEE";
    }
}
