package org.example.exercice3.impl;
import org.example.exercice3.interfaces.IMetier;
import org.example.exercice3.models.Client;
import org.example.exercice3.models.Client;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MetierClientImpl implements IMetier<Client> {
    private final File dossier;
    private List<Client> clients;
    public MetierClientImpl() {
        this.dossier = new File("data/clients");
        if (!dossier.exists()) {
            dossier.mkdirs();
        }
    }

    @Override
    public Client add(Client client) throws IOException {
        File fichierClient = new File(dossier, client.getNom() + ".dat");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichierClient))) {
            oos.writeObject(client);
        }
        return client;
    }
    @Override
    public List<Client> getAll() throws IOException, ClassNotFoundException {
        List<Client> clients = new ArrayList<>();
        if (dossier != null && dossier.exists() && dossier.isDirectory()) {
            for (File fichier : dossier.listFiles((dir, name) -> name.endsWith(".dat"))) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier))) {
                    clients.add((Client) ois.readObject());
                } catch (Exception e) {
                    System.err.println("Erreur lors de la lecture du fichier : " + fichier.getName());
                    e.printStackTrace();
                }
            }
        }
        return clients;
    }
    @Override
    public Client findByNom(String nom) throws IOException, ClassNotFoundException {
        File fichierClient = new File(dossier, nom + ".dat");
        if (fichierClient.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichierClient))) {
                return (Client) ois.readObject();
            }
        }
        return null;
    }

    @Override
    public void delete(String nom) throws IOException {
        File fichierClient = new File(dossier, nom + ".dat");
        if (fichierClient.exists()) {
            fichierClient.delete();
        }
    }

    @Override
    public void saveAll() {
        for (Client client : clients) {
            String fichierClient = "clients/" + client.getNom() + ".dat";
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichierClient))) {
                oos.writeObject(client);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
