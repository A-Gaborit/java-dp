package org.sebsy.builder;

import org.sebsy.builder.models.*;

import java.util.ArrayList;
import java.util.List;

public class ProduitBuilder {

    private String nom;
    private String grade;
    private String categorieNom;
    private String marqueNom;
    private final List<Additif> additifs = new ArrayList<>();
    private final List<Ingredient> ingredients = new ArrayList<>();
    private final List<Allergene> allergenes = new ArrayList<>();

    /**
     * Définit le nom du produit.
     * 
     * @param nom le nom du produit
     * @return ce builder pour chaînage
     */
    public ProduitBuilder nom(String nom) {
        this.nom = nom;
        return this;
    }

    /**
     * Définit le grade du produit.
     * 
     * @param grade le grade/note du produit
     * @return ce builder pour chaînage
     */
    public ProduitBuilder grade(String grade) {
        this.grade = grade;
        return this;
    }

    /**
     * Définit la catégorie du produit.
     * 
     * @param nomCategorie le nom de la catégorie
     * @return ce builder pour chaînage
     */
    public ProduitBuilder categorie(String nomCategorie) {
        this.categorieNom = nomCategorie;
        return this;
    }

    /**
     * Définit la marque du produit.
     * 
     * @param nomMarque le nom de la marque
     * @return ce builder pour chaînage
     */
    public ProduitBuilder marque(String nomMarque) {
        this.marqueNom = nomMarque;
        return this;
    }

    /**
     * Ajoute un additif au produit.
     * 
     * @param nom le nom de l'additif (non null, non vide)
     * @param qteMilligrammes la quantité en milligrammes (doit être >= 0)
     * @return ce builder pour chaînage
     * @throws IllegalArgumentException si la quantité est négative
     */
    public ProduitBuilder ajouterAdditif(String nom, double qteMilligrammes) {
        if (qteMilligrammes < 0) {
            throw new IllegalArgumentException("La quantité d'additif ne peut pas être négative");
        }
        this.additifs.add(new Additif(nom, qteMilligrammes));
        return this;
    }

    /**
     * Ajoute un ingrédient au produit.
     * 
     * @param nom le nom de l'ingrédient (non null, non vide)
     * @param qteMilligrammes la quantité en milligrammes (doit être >= 0)
     * @return ce builder pour chaînage
     * @throws IllegalArgumentException si la quantité est négative
     */
    public ProduitBuilder ajouterIngredient(String nom, double qteMilligrammes) {
        if (qteMilligrammes < 0) {
            throw new IllegalArgumentException("La quantité d'ingrédient ne peut pas être négative");
        }
        this.ingredients.add(new Ingredient(nom, qteMilligrammes));
        return this;
    }

    /**
     * Ajoute un allergène au produit.
     * 
     * @param nom le nom de l'allergène (non null, non vide)
     * @param qteMilligrammes la quantité en milligrammes (doit être >= 0)
     * @return ce builder pour chaînage
     * @throws IllegalArgumentException si la quantité est négative
     */
    public ProduitBuilder ajouterAllergene(String nom, double qteMilligrammes) {
        if (qteMilligrammes < 0) {
            throw new IllegalArgumentException("La quantité d'allergène ne peut pas être négative");
        }
        this.allergenes.add(new Allergene(nom, qteMilligrammes));
        return this;
    }

    /**
     * Construit le produit en validant tous les champs obligatoires.
     * 
     * @return un nouveau {@link Produit} avec les paramètres définis
     * @throws IllegalStateException si un champ obligatoire est null ou vide
     */
    public Produit build() {
        if (nom == null || nom.isBlank()) {
            throw new IllegalStateException("Le nom du produit est obligatoire.");
        }
        if (categorieNom == null || categorieNom.isBlank()) {
            throw new IllegalStateException("La catégorie du produit est obligatoire.");
        }
        if (marqueNom == null || marqueNom.isBlank()) {
            throw new IllegalStateException("La marque du produit est obligatoire.");
        }

        return new Produit(
            nom,
            grade,
            new Categorie(categorieNom),
            new Marque(marqueNom),
            additifs,
            ingredients,
            allergenes
        );
    }
}