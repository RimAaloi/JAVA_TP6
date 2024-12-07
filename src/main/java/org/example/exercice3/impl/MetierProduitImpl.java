package org.example.exercice3.impl;
import org.example.exercice3.interfaces.IMetier;
import org.example.exercice3.models.Produit;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetier<Produit> {
    private final File dossierProduits = new File("data/produits");
    private List<Produit> produits;

    public MetierProduitImpl() {
        if (!dossierProduits.exists()) {
            dossierProduits.mkdirs();
        }
    }

    @Override
    public Produit add(Produit p) {
        try {
            File fichierProduit = new File(dossierProduits, p.getNom() + ".dat");
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichierProduit))) {
                oos.writeObject(p); // Sauvegarde le produit dans un fichier
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public List<Produit> getAll() {
        List<Produit> produits = new ArrayList<>();
        if (dossierProduits.exists() && dossierProduits.isDirectory()) {
            for (File fichier : dossierProduits.listFiles((dir, name) -> name.endsWith(".dat"))) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier))) {
                    Produit produit = (Produit) ois.readObject();
                    produits.add(produit);
                } catch (InvalidClassException e) {
                    System.err.println("Fichier incompatible détecté : " + fichier.getName() + ", suppression en cours...");
                    fichier.delete();
                } catch (Exception e) {
                    System.err.println("Erreur lors de la lecture du fichier : " + fichier.getName());
                    e.printStackTrace();
                }        }          }
        return produits;                        }
    @Override
    public Produit findByNom(String nom) {
        File fichierProduit = new File(dossierProduits, nom + ".dat");
        if (fichierProduit.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichierProduit))) {
                return (Produit) ois.readObject();
            } catch (Exception e) {
                System.err.println("Erreur lors de la lecture du fichier pour le produit : " + nom);
                e.printStackTrace();
            }          }
        return null;
    }

    @Override
    public void delete(String nom) {
        File fichierProduit = new File(dossierProduits, nom + ".dat");
        if (fichierProduit.exists()) {
            if (fichierProduit.delete()) {
                System.out.println("Produit supprimé : " + nom);
            } else {
                System.err.println("Impossible de supprimer le fichier du produit : " + nom);
            }
        } else {
            System.err.println("Produit introuvable pour suppression : " + nom);
        }
    }

    @Override
    public void saveAll() {
        for (Produit produit : produits) {
            String fichierProduit = "produits/" + produit.getNom() + ".dat";  // Crée un fichier par produit
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichierProduit))) {
                oos.writeObject(produit);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
           }
}
