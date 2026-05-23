package org.sebsy.state;

public class CreationState implements CommandeState {
    @Override
    public void ajouterProduit(Commande commande, Produit produit) {
        if (produit == null) {
            throw new IllegalArgumentException("Le produit ne peut pas être null");
        }
        commande.getProduits().add(produit);
        System.out.println("Produit ajouté: " + produit.getNom());
    }
    
    @Override
    public void payer(Commande commande) {
        if (commande.getProduits().isEmpty()) {
            throw new IllegalStateException("Impossible de payer une commande vide");
        }
        double montant = commande.getProduits().size() * 0.5;
        commande.setMontant(montant);
        commande.setEtat(new PaiementState());
        System.out.println("Paiement effectué. Montant: " + montant + "€");
    }
    
    @Override
    public void livrer(Commande commande, String adresse) {
        throw new IllegalStateException("Impossible de livrer une commande qui n'a pas été payée");
    }
    
    @Override
    public void annuler(Commande commande) {
        commande.setEtat(new AnnuleeState());
    }
    
    @Override
    public String getNomEtat() {
        return "CREATION";
    }
}
