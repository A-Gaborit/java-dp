package org.sebsy.builder.models;

import java.util.Objects;

public class Categorie {
    private final String nom;
 
    /**
     * Construit une catégorie.
     * 
     * @param nom le nom de la catégorie (non null, non vide)
     * @throws IllegalArgumentException si nom est null ou vide
     */
    public Categorie(String nom) {
        if (nom == null || nom.isBlank()) {
            throw new IllegalArgumentException("Le nom de la catégorie ne peut pas être null ou vide");
        }
        this.nom = nom;
    }
 
    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Categorie{nom='" + nom + "'}";
    }
}
