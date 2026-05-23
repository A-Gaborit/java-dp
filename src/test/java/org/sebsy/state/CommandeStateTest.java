package org.sebsy.state;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CommandeStateTest {
    
    private Commande commande;
    private Produit produit1;
    private Produit produit2;
    private Produit produit3;
    
    @Before
    public void setUp() {
        commande = new Commande();
        produit1 = new Produit("Pomme", "Grade A");
        produit2 = new Produit("Banane", "Grade B");
        produit3 = new Produit("Orange", "Grade C");
    }
    
    // ========== Tests for CREATION state ==========
    @Test
    public void testInitialStateIsCreation() {
        assertEquals("CREATION", commande.getEtat().getNomEtat());
    }
    
    @Test
    public void testAddProductInCreation() {
        commande.ajouterProduit(produit1);
        assertEquals(1, commande.getProduits().size());
        assertEquals(produit1, commande.getProduits().get(0));
    }
    
    @Test
    public void testAddMultipleProductsInCreation() {
        commande.ajouterProduit(produit1);
        commande.ajouterProduit(produit2);
        commande.ajouterProduit(produit3);
        assertEquals(3, commande.getProduits().size());
    }
    
    @Test(expected = IllegalStateException.class)
    public void testPayEmptyOrderThrowsException() {
        commande.payer();
    }
    
    @Test
    public void testPayOrderWithProducts() {
        commande.ajouterProduit(produit1);
        commande.ajouterProduit(produit2);
        commande.payer();
        
        assertEquals(2 * 0.5, commande.getMontant(), 0.01);
        assertEquals("PAIEMENT", commande.getEtat().getNomEtat());
    }
    
    @Test
    public void testCancelOrderFromCreation() {
        commande.ajouterProduit(produit1);
        commande.annuler();
        
        assertEquals("ANNULEE", commande.getEtat().getNomEtat());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testAddNullProductThrowsException() {
        commande.ajouterProduit(null);
    }
    
    // ========== Tests for PAIEMENT state ==========
    @Test(expected = IllegalStateException.class)
    public void testAddProductAfterPaymentThrowsException() {
        commande.ajouterProduit(produit1);
        commande.payer();
        commande.ajouterProduit(produit2);
    }
    
    @Test(expected = IllegalStateException.class)
    public void testPayTwiceThrowsException() {
        commande.ajouterProduit(produit1);
        commande.payer();
        commande.payer();
    }
    
    @Test
    public void testDeliverOrderFromPaiement() {
        commande.ajouterProduit(produit1);
        commande.payer();
        commande.livrer("123 Rue de la Paix, 75000 Paris");
        
        assertEquals("EN_LIVRAISON", commande.getEtat().getNomEtat());
        assertEquals("123 Rue de la Paix, 75000 Paris", commande.getAdresse());
    }
    
    @Test
    public void testCancelOrderFromPaiement() {
        commande.ajouterProduit(produit1);
        commande.payer();
        commande.annuler();
        
        assertEquals("ANNULEE", commande.getEtat().getNomEtat());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testDeliverWithNullAddressThrowsException() {
        commande.ajouterProduit(produit1);
        commande.payer();
        commande.livrer(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testDeliverWithEmptyAddressThrowsException() {
        commande.ajouterProduit(produit1);
        commande.payer();
        commande.livrer("");
    }
    
    // ========== Tests for EN_LIVRAISON state ==========
    @Test(expected = IllegalStateException.class)
    public void testAddProductDuringDeliveryThrowsException() {
        commande.ajouterProduit(produit1);
        commande.payer();
        commande.livrer("123 Rue test");
        commande.ajouterProduit(produit2);
    }
    
    @Test(expected = IllegalStateException.class)
    public void testPayDuringDeliveryThrowsException() {
        commande.ajouterProduit(produit1);
        commande.payer();
        commande.livrer("123 Rue test");
        commande.payer();
    }
    
    @Test(expected = IllegalStateException.class)
    public void testCancelDuringDeliveryThrowsException() {
        commande.ajouterProduit(produit1);
        commande.payer();
        commande.livrer("123 Rue test");
        commande.annuler();
    }
    
    @Test(expected = IllegalStateException.class)
    public void testDeliverAgainDuringDeliveryThrowsException() {
        commande.ajouterProduit(produit1);
        commande.payer();
        commande.livrer("123 Rue test");
        commande.livrer("456 Avenue autre");
    }
    
    // ========== Tests for ANNULEE state ==========
    @Test(expected = IllegalStateException.class)
    public void testAddProductToAnnuledOrderThrowsException() {
        commande.ajouterProduit(produit1);
        commande.annuler();
        commande.ajouterProduit(produit2);
    }
    
    @Test(expected = IllegalStateException.class)
    public void testPayAnnuledOrderThrowsException() {
        commande.ajouterProduit(produit1);
        commande.annuler();
        commande.payer();
    }
    
    @Test(expected = IllegalStateException.class)
    public void testDeliverAnnuledOrderThrowsException() {
        commande.ajouterProduit(produit1);
        commande.annuler();
        commande.livrer("123 Rue test");
    }
    
    @Test(expected = IllegalStateException.class)
    public void testCancelAnnuledOrderThrowsException() {
        commande.ajouterProduit(produit1);
        commande.annuler();
        commande.annuler();
    }
    
    // ========== Integration tests ==========
    
    @Test
    public void testCompleteWorkflow() {
        assertEquals("CREATION", commande.getEtat().getNomEtat());
        commande.ajouterProduit(produit1);
        commande.ajouterProduit(produit2);
        commande.ajouterProduit(produit3);
        assertEquals(3, commande.getProduits().size());
        
        commande.payer();
        assertEquals("PAIEMENT", commande.getEtat().getNomEtat());
        assertEquals(3 * 0.5, commande.getMontant(), 0.01);
        
        commande.livrer("10 Avenue des Champs, 75008 Paris");
        assertEquals("EN_LIVRAISON", commande.getEtat().getNomEtat());
        assertEquals("10 Avenue des Champs, 75008 Paris", commande.getAdresse());
    }
    
    @Test
    public void testCancelFromCreationWorkflow() {
        assertEquals("CREATION", commande.getEtat().getNomEtat());
        commande.ajouterProduit(produit1);
        assertEquals(1, commande.getProduits().size());
        
        commande.annuler();
        assertEquals("ANNULEE", commande.getEtat().getNomEtat());
    }
    
    @Test
    public void testCancelFromPaiementWorkflow() {
        commande.ajouterProduit(produit1);
        commande.ajouterProduit(produit2);
        
        commande.payer();
        assertEquals("PAIEMENT", commande.getEtat().getNomEtat());
        
        commande.annuler();
        assertEquals("ANNULEE", commande.getEtat().getNomEtat());
    }
    
    @Test
    public void testProductCountCalculation() {
        commande.ajouterProduit(produit1);
        commande.payer();
        
        assertEquals(1, commande.getProduits().size());
        assertEquals(1 * 0.5, commande.getMontant(), 0.01);
    }
    
    @Test
    public void testMultipleProductCountCalculation() {
        commande.ajouterProduit(produit1);
        commande.ajouterProduit(produit2);
        commande.ajouterProduit(produit3);
        commande.payer();
        
        assertEquals(3, commande.getProduits().size());
        assertEquals(3 * 0.5, commande.getMontant(), 0.01);
    }
}
