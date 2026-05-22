package org.sebsy.builder;

import org.junit.Test;
import org.sebsy.builder.models.*;
import static org.junit.Assert.*;

public class BuilderTest {

    @Test
    public void build_casNominal_retourneProduitComplet() {
        Produit produit = new ProduitBuilder()
                .nom("Nutella")
                .grade("E")
                .categorie("Pâtes à tartiner")
                .marque("Ferrero")
                .ajouterAdditif("Lécithine de soja", 50.0)
                .ajouterIngredient("Sucre", 570_000.0)
                .ajouterIngredient("Noisettes", 130_000.0 )
                .ajouterAllergene("Fruits à coque", 130_000.0)
                .build();

        assertNotNull(produit);
        assertEquals("Nutella", produit.getNom());
        assertEquals("E", produit.getGrade());
        assertEquals("Pâtes à tartiner", produit.getCategorie().getNom());
        assertEquals("Ferrero", produit.getMarque().getNom());

        assertEquals(1, produit.getAdditifs().size());
        assertEquals("Lécithine de soja", produit.getAdditifs().get(0).getNom());
        assertEquals(50.0, produit.getAdditifs().get(0).getQteMilligrammes(), 0.001);

        assertEquals(2, produit.getIngredients().size());
        assertEquals("Sucre", produit.getIngredients().get(0).getNom());

        assertEquals(1, produit.getAllergenes().size());
        assertEquals("Fruits à coque", produit.getAllergenes().get(0).getNom());
    }

    @Test
    public void build_sansList_retourneProduitAvecListesVides() {
        Produit produit = new ProduitBuilder()
                .nom("Eau minérale")
                .grade("A")
                .categorie("Boissons")
                .marque("Evian")
                .build();

        assertNotNull(produit);
        assertTrue(produit.getAdditifs().isEmpty());
        assertTrue(produit.getIngredients().isEmpty());
        assertEquals("A", produit.getGrade());
    }

    @Test
    public void build_sansGrade_retourneProduitAvecGradeNull() {
        Produit produit = new ProduitBuilder()
                .nom("Pain")
                .categorie("Boulangerie")
                .marque("Harry's")
                .build();

        assertNull(produit.getGrade());
    }

    @Test
    public void build_plusieursAdditifs_tousPresents() {
        Produit produit = new ProduitBuilder()
                .nom("Soda")
                .categorie("Boissons")
                .marque("Coca-Cola")
                .ajouterAdditif("Acide phosphorique", 10.0)
                .ajouterAdditif("Caramel E150d", 5.0)
                .build();

        assertEquals(2, produit.getAdditifs().size());
    }

    // ── Cas alternatifs (erreurs attendues) ──────────────────────────────────

    @Test(expected = IllegalStateException.class)
    public void build_sansNom_leveIllegalStateException() {
        new ProduitBuilder()
                .categorie("Boissons")
                .marque("Evian")
                .build();
    }

    @Test(expected = IllegalStateException.class)
    public void build_nomVide_leveIllegalStateException() {
        new ProduitBuilder()
                .nom("   ")
                .categorie("Boissons")
                .marque("Evian")
                .build();
    }

    @Test(expected = IllegalStateException.class)
    public void build_sansCategorie_leveIllegalStateException() {
        new ProduitBuilder()
                .nom("Nutella")
                .marque("Ferrero")
                .build();
    }

    @Test(expected = IllegalStateException.class)
    public void build_sansMarque_leveIllegalStateException() {
        new ProduitBuilder()
                .nom("Nutella")
                .categorie("Pâtes à tartiner")
                .build();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void build_listeImmutable_neDoitPasEtreModifiable() {
        Produit produit = new ProduitBuilder()
                .nom("Biscuit")
                .categorie("Snacks")
                .marque("Lu")
                .ajouterAdditif("Vanilline", 2.0)
                .build();

        produit.getAdditifs().add(new Additif("Test", 1.0));
    }
}