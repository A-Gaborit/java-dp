package org.sebsy.state;

public class EnLivraisonState implements CommandeState {
    @Override
    public void ajouterProduit(Commande commande, Produit produit) {
        throw new IllegalStateException("Impossible d'ajouter un produit à une commande en livraison");
    }
    
    @Override
    public void payer(Commande commande) {
        throw new IllegalStateException("La commande est déjà en livraison");
    }
    
    @Override
    public void livrer(Commande commande, String adresse) {
        throw new IllegalStateException("La commande est déjà en livraison");
    }
    
    @Override
    public void annuler(Commande commande) {
        throw new IllegalStateException("La commande est déjà en cours de livraison, l'annulation est impossible");
    }
    
    @Override
    public String getNomEtat() {
        return "EN_LIVRAISON";
    }
}
