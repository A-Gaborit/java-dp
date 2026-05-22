package org.sebsy.builder.models;

import java.util.Objects;

public class Marque {
    private final String nom;
 
    /**
     * Construit une marque.
     * 
     * @param nom le nom de la marque (non null, non vide)
     * @throws IllegalArgumentException si nom est null ou vide
     */
    public Marque(String nom) {
        if (nom == null || nom.isBlank()) {
            throw new IllegalArgumentException("Le nom de la marque ne peut pas être null ou vide");
        }
        this.nom = nom;
    }
 
    public String getNom() {
        return nom;
    }
 
    @Override
    public String toString() {
        return "Marque{nom='" + nom + "'}";
    }
}
