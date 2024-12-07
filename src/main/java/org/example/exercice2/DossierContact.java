package org.example.exercice2;
import java.io.*;
import java.util.*;

public class DossierContact {
    private final String directoryPath = "contacts";

    public DossierContact() {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

    public void ajouterContact(String nom, String numero) throws IOException {
        File file = new File(directoryPath + "/" + nom + ".txt");
        if (file.exists()) {
            System.out.println("Le contact existe déjà !");
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(numero);
        }
        System.out.println("Contact ajouté avec succès.");
    }

    public void supprimerContact(String nom) {
        File file = new File(directoryPath + "/" + nom + ".txt");
        if (file.delete()) {
            System.out.println("Contact supprimé avec succès.");
        } else {
            System.out.println("Le contact n'existe pas.");
        }
    }
    public String rechercherContact(String nom) throws IOException {
        File file = new File(directoryPath + "/" + nom + ".txt");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                return reader.readLine();    }
        } else {
            return "Contact introuvable.";
        }
    }
    public void modifierNumero(String nom, String nouveauNumero) throws IOException {
        File file = new File(directoryPath + "/" + nom + ".txt");
        if (!file.exists()) {
            System.out.println("Le contact n'existe pas.");
            return;  }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(nouveauNumero);    }
        System.out.println("Numéro modifié avec succès.");
    }

    public void afficherContacts() throws IOException {
        File directory = new File(directoryPath);
        String[] files = directory.list();
        if (files == null || files.length == 0) {
            System.out.println("Aucun contact à afficher.");
            return;
        }
        System.out.println("Liste des contacts :");
        for (String fileName : files) {
            String nom = fileName.replace(".txt", "");
            System.out.println("- " + nom + ": " + rechercherContact(nom));
        }
    }
}
