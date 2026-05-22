package org.sebsy.composite;

public class TestComposite {
    public static void main(String[] args) {
        // Création des services
        Service dsin = new Service("DSIN");
        Service bigData = new Service("Big Data");
        Service javaDev = new Service("Java Dev");

        // Création des employés
        Employe cecile = new Employe("RASPEY", "Cécile", 10000);
        Employe bilel = new Employe("BECHKAR", "Bilel", 8000);
        Employe jb = new Employe("RANMEY", "JB", 7500);
        Employe jane = new Employe("DOE", "Jane", 3500);
        Employe kevin = new Employe("GUINEAU", "KEVIN", 7500);
        Employe paul = new Employe("MARTIN", "Paul", 3500);

        // Construction de la hiérarchie
        dsin.ajouterElement(cecile);
        dsin.ajouterElement(bilel);
        dsin.ajouterElement(bigData);
        dsin.ajouterElement(javaDev);

        bigData.ajouterElement(jb);
        bigData.ajouterElement(jane);

        javaDev.ajouterElement(kevin);
        javaDev.ajouterElement(paul);

        System.out.println("=== Organisation DSIN ===");
        System.out.println("Employés directs du service DSIN :");
        for (IElement element : dsin.getElements()) {
            if (element instanceof Employe) {
                System.out.println("  - " + element);
            } else if (element instanceof Service) {
                System.out.println("  - " + element);
            }
        }

        System.out.println("\n--- Service Big Data ---");
        System.out.println("Salaire total Big Data : " + bigData.calculerSalaire() + "€");
        System.out.println("Détail :");
        for (IElement element : bigData.getElements()) {
            System.out.println("  - " + element);
        }

        System.out.println("\n--- Service Java Dev ---");
        System.out.println("Salaire total Java Dev : " + javaDev.calculerSalaire() + "€");
        System.out.println("Détail :");
        for (IElement element : javaDev.getElements()) {
            System.out.println("  - " + element);
        }

        System.out.println("\n=== Total Organisation DSIN ===");
        System.out.println("Salaire total DSIN : " + dsin.calculerSalaire() + "€");
        System.out.println("Détail :");
        for (IElement element : dsin.getElements()) {
            if(element instanceof Service) {
               for (IElement e : ((Service) element).getElements()) {
                   System.out.println("  - " + e);
               }
            } else {
                System.out.println("  - " + element);
            }
        }
    }
}
