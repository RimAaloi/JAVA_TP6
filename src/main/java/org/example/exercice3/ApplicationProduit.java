package org.example.exercice3;
import org.example.exercice3.impl.MetierProduitImpl;
import org.example.exercice3.models.Produit;
import java.util.Scanner;
public class ApplicationProduit {
    public static void main(String[] args) {
        MetierProduitImpl metierProduit = new MetierProduitImpl();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Menu Gestion des Produits ---");
            System.out.println("1. Afficher la liste des produits");
            System.out.println("2. Rechercher un produit par son nom");
            System.out.println("3. Ajouter un nouveau produit");
            System.out.println("4. Supprimer un produit par nom");
            System.out.println("5. Quitter");
            System.out.print("Choisissez une option : ");
            int choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    System.out.println("\nListe des produits :");
                    var produits = metierProduit.getAll();
                    if (produits.isEmpty()) {
                        System.out.println("Aucun produit trouvé.");
                    } else {
                        produits.forEach(System.out::println);
                    }
                    break;

                case 2:
                    System.out.print("Entrez le nom du produit à rechercher : ");
                    String nomRecherche = scanner.nextLine();
                    Produit produitTrouve = metierProduit.findByNom(nomRecherche);
                    if (produitTrouve != null) {
                        System.out.println("Produit trouvé : " + produitTrouve);
                    } else {
                        System.out.println("Aucun produit trouvé avec ce nom.");
                    }
                    break;
                case 3:
                    System.out.print("Entrez le nom du produit : ");
                    String nom = scanner.nextLine();
                    System.out.print("Entrez la marque : ");
                    String marque = scanner.nextLine();
                    System.out.print("Entrez le prix : ");
                    double prix = scanner.nextDouble();
                    scanner.nextLine(); // Consomme la ligne restante
                    System.out.print("Entrez la description : ");
                    String description = scanner.nextLine();
                    System.out.print("Entrez le nombre en stock : ");
                    int stock = scanner.nextInt();
                    Produit nouveauProduit = new Produit(nom, marque, prix, description, stock);
                    metierProduit.add(nouveauProduit);
                    System.out.println("Produit ajouté avec succès !");
                    break;

                case 4:
                    System.out.print("Entrez le nom du produit à supprimer : ");
                    String nomASupprimer = scanner.nextLine();
                    metierProduit.delete(nomASupprimer);
                    System.out.println("Produit supprimé avec succès !");
                    break;

                case 5:
                    System.out.println("Fermeture du programme...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }
}
