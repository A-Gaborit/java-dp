package org.sebsy.state;

public interface CommandeState {
    /**
     * Adds a product to the order.
     * Only allowed in CREATION state.
     * 
     * @param commande the order to add the product to
     * @param produit the product to add
     * @throws IllegalStateException if the operation is not allowed in the current state
     */
    void ajouterProduit(Commande commande, Produit produit);
    
    /**
     * Processes payment for the order.
     * Only allowed in CREATION state.
     * 
     * @param commande the order to process payment for
     * @throws IllegalStateException if the operation is not allowed in the current state
     */
    void payer(Commande commande);
    
    /**
     * Sets the delivery address for the order.
     * Only allowed in PAIEMENT state.
     * 
     * @param commande the order to set delivery address for
     * @param adresse the delivery address
     * @throws IllegalStateException if the operation is not allowed in the current state
     */
    void livrer(Commande commande, String adresse);
    
    /**
     * Cancels the order.
     * Allowed in CREATION and PAIEMENT states.
     * 
     * @param commande the order to cancel
     * @throws IllegalStateException if the operation is not allowed in the current state
     */
    void annuler(Commande commande);
    
    /**
     * Returns the name of the state for display purposes.
     * 
     * @return the state name
     */
    String getNomEtat();
}
