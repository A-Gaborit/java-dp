package org.sebsy.builder.models;

import java.util.Objects;

public class Additif {
    private final String nom;
    private final double qteMilligrammes;
 
    /**
     * Construit un additif.
     * 
     * @param nom le nom de l'additif (non null, non vide)
     * @param qteMilligrammes la quantité en milligrammes (doit être >= 0)
     * @throws IllegalArgumentException si nom est null/vide ou qteMilligrammes < 0
     */
    public Additif(String nom, double qteMilligrammes) {
        if (nom == null || nom.isBlank()) {
            throw new IllegalArgumentException("Le nom de l'additif ne peut pas être null ou vide");
        }
        if (qteMilligrammes < 0) {
            throw new IllegalArgumentException("La quantité ne peut pas être négative");
        }
        this.nom = nom;
        this.qteMilligrammes = qteMilligrammes;
    }
 
    public String getNom() {
        return nom;
    }
 
    public double getQteMilligrammes() {
        return qteMilligrammes;
    }
 
    @Override
    public String toString() {
        return "Additif{nom='" + nom + "', qteMilligrammes=" + qteMilligrammes + "}";
    }
}