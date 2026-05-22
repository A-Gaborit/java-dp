package org.sebsy.composite;

import java.util.ArrayList;
import java.util.List;

public class Service implements IElement {
    private String nom;
    private List<IElement> elements;

    public Service(String nom) {
        this.nom = nom;
        this.elements = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void ajouterElement(IElement element) {
        elements.add(element);
    }

    public void supprimerElement(IElement element) {
        elements.remove(element);
    }

    public List<IElement> getElements() {
        return elements;
    }

    @Override
    public double calculerSalaire() {
        double total = 0;
        for (IElement element : elements) {
            total += element.calculerSalaire();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Service: " + nom;
    }
}
