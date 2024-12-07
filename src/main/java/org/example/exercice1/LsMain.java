package org.example.exercice1;

import java.util.Scanner;

public class LsMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Veuillez entrer le chemin complet du répertoire : ");

        String directoryPath = scanner.nextLine();

        scanner.close();

        LsSimulation.listFiles(directoryPath);

    }

}
