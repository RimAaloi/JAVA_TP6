package org.example.exercice2;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        DossierContact dossier = new DossierContact();
        Scanner scanner = new Scanner(System.in);
        boolean quitter = false;

        while (!quitter) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Rechercher un numéro de téléphone");
            System.out.println("2. Ajouter un nouveau contact");
            System.out.println("3. Supprimer un contact");
            System.out.println("4. Changer le numéro de téléphone d’un contact");
            System.out.println("5. Afficher tous les contacts");
            System.out.println("6. Quitter");
            System.out.print("Choisissez une option : ");
            int choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1 -> {
                    System.out.print("Entrez le nom du contact : ");
                    String nom = scanner.nextLine();
                    System.out.println("Numéro : " + dossier.rechercherContact(nom));
                }
                case 2 -> {
                    System.out.print("Entrez le nom du contact : ");
                    String nom = scanner.nextLine();
                    System.out.print("Entrez le numéro de téléphone : ");
                    String numero = scanner.nextLine();
                    dossier.ajouterContact(nom, numero);
                }
                case 3 -> {
                    System.out.print("Entrez le nom du contact à supprimer : ");
                    String nom = scanner.nextLine();
                    dossier.supprimerContact(nom);
                }
                case 4 -> {
                    System.out.print("Entrez le nom du contact : ");
                    String nom = scanner.nextLine();
                    System.out.print("Entrez le nouveau numéro de téléphone : ");
                    String nouveauNumero = scanner.nextLine();
                    dossier.modifierNumero(nom, nouveauNumero);
                }
                case 5 -> dossier.afficherContacts();
                case 6 -> {
                    quitter = true;
                    System.out.println("Au revoir !");
                }
                default -> System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
        scanner.close();
    }
}
