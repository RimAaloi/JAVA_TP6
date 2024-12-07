package org.example.exercice3;
import org.example.exercice3.impl.MetierClientImpl;
import org.example.exercice3.models.Client;
import org.example.exercice3.interfaces.IMetier;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ApplicationClient {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        IMetier<Client> metierClient = new MetierClientImpl();
        Scanner scanner = new Scanner(System.in);

        int choix;
        do {
            System.out.println("\n=== Menu Gestion des Clients ===");
            System.out.println("1. Afficher tous les clients");
            System.out.println("2. Rechercher un client par nom");
            System.out.println("3. Ajouter un nouveau client");
            System.out.println("4. Supprimer un client par nom");
            System.out.println("5. Quitter");
            System.out.print("Entrez votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la ligne vide

            switch (choix) {
                case 1 -> {
                    List<Client> clients = metierClient.getAll();
                    if (!clients.isEmpty()) {
                        clients.forEach(System.out::println);
                    } else {
                        System.out.println("Aucun client trouvé.");
                    }
                }
                case 2 -> {
                    System.out.print("Entrez le nom du client à rechercher : ");
                    String nom = scanner.nextLine();
                    Client client = metierClient.findByNom(nom);
                    if (client != null) {
                        System.out.println(client);
                    } else {
                        System.out.println("Client introuvable.");
                    }
                }
                case 3 -> {
                    System.out.print("Entrez le nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Entrez le prénom : ");
                    String prenom = scanner.nextLine();
                    System.out.print("Entrez l'adresse : ");
                    String adresse = scanner.nextLine();
                    System.out.print("Entrez le téléphone : ");
                    String tel = scanner.nextLine();
                    System.out.print("Entrez l'email : ");
                    String email = scanner.nextLine();
                    Client client = new Client(nom, prenom, adresse, tel, email);
                    metierClient.add(client);
                    System.out.println("Client ajouté avec succès.");
                }
                case 4 -> {
                    System.out.print("Entrez le nom du client à supprimer : ");
                    String nom = scanner.nextLine();
                    metierClient.delete(nom);
                    System.out.println("Client supprimé.");
                }
                case 5 -> System.out.println("Au revoir !");
                default -> System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 5);

        scanner.close();
    }
}
