package org.example.exercice3.models;
import java.io.Serializable;

public class Produit implements Serializable {
    private String nom;
    private String marque;
    private double prix;
    private String description;
    private int nombreEnStock;

    public Produit(String nom, String marque, double prix, String description, int nombreEnStock) {
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.nombreEnStock = nombreEnStock;
    }
    public String getNom() {
        return nom;
    }
    public String getMarque() {
        return marque;
    }
    public double getPrix() {
        return prix;
    }
    public String getDescription() {
        return description;
    }
    public int getNombreEnStock() {
        return nombreEnStock;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setNombreEnStock(int nombreEnStock) {
        this.nombreEnStock = nombreEnStock;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "nom='" + nom + '\'' +
                ", marque='" + marque + '\'' +
                ", prix=" + prix +
                ", description='" + description + '\'' +
                ", nombreEnStock=" + nombreEnStock +
                '}';
    }
}
