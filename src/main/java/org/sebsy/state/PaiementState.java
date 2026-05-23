package org.sebsy.state;

public class PaiementState implements CommandeState {
    @Override
    public void ajouterProduit(Commande commande, Produit produit) {
        throw new IllegalStateException("Impossible d'ajouter un produit à une commande déjà payée");
    }
    
    @Override
    public void payer(Commande commande) {
        throw new IllegalStateException("La commande a déjà été payée");
    }
    
    @Override
    public void livrer(Commande commande, String adresse) {
        if (adresse == null || adresse.trim().isEmpty()) {
            throw new IllegalArgumentException("L'adresse ne peut pas être vide");
        }
        commande.setAdresse(adresse);
        commande.setEtat(new EnLivraisonState());
        System.out.println("Commande en livraison à: " + adresse);
    }
    
    @Override
    public void annuler(Commande commande) {
        commande.setEtat(new AnnuleeState());
        System.out.println("Commande annulée depuis l'état PAIEMENT");
    }
    
    @Override
    public String getNomEtat() {
        return "PAIEMENT";
    }
}
