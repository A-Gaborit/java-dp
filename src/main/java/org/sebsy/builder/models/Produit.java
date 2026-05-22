package org.sebsy.builder.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Produit {
    private final String nom;
    private final String grade;
    private final Categorie categorie;
    private final Marque marque;
    private final List<Additif> additifs;
    private final List<Ingredient> ingredients;
    private final List<Allergene> allergenes;
 
    /**
     * Construit un produit avec ses composants.
     * 
     * @param nom le nom du produit (non null, non vide)
     * @param grade le grade/note du produit (peut être null)
     * @param categorie la catégorie du produit (non null)
     * @param marque la marque du produit (non null)
     * @param additifs liste des additifs (non null, peut être vide)
     * @param ingredients liste des ingrédients (non null, peut être vide)
     * @param allergenes liste des allergènes (non null, peut être vide)
     */
    public Produit(
        String nom,
        String grade,
        Categorie categorie,
        Marque marque,
        List<Additif> additifs,
        List<Ingredient> ingredients,
        List<Allergene> allergenes
    ) {
        this.nom = nom;
        this.grade = grade;
        this.categorie = categorie;
        this.marque = marque;
        this.additifs = Collections.unmodifiableList(new ArrayList<>(additifs));
        this.ingredients = Collections.unmodifiableList(new ArrayList<>(ingredients));
        this.allergenes = Collections.unmodifiableList(new ArrayList<>(allergenes));
    }
 
    public String getNom() {
        return nom;
    }
 
    public String getGrade() {
        return grade;
    }
 
    public Categorie getCategorie() {
        return categorie;
    }
 
    public Marque getMarque() {
        return marque;
    }
 
    public List<Additif> getAdditifs() {
        return additifs;
    }
 
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<Allergene> getAllergenes() {
        return allergenes;
    }
 
    @Override
    public String toString() {
        return "Produit{"
                + "nom='" + nom + '\''
                + ", grade='" + grade + '\''
                + ", categorie=" + categorie
                + ", marque=" + marque
                + ", additifs=" + additifs
                + ", ingredients=" + ingredients
                + ", allergenes=" + allergenes
                + '}';
    }
}