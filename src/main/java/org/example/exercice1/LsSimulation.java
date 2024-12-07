package org.example.exercice1;
import java.io.File;

public class LsSimulation {
    public static void listFiles(String directoryPath) {

        File dir = new File(directoryPath);

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    String type = file.isDirectory() ? "<DIR>" : "<FILE>";
                    String permissions = (file.canRead() ? "r" : "-") +
                            (file.canWrite() ? "w" : "-") +
                            (file.isHidden() ? "h" : "-");
                    System.out.printf("%s %s %s%n", file.getAbsolutePath(), type, permissions);
                    if (file.isDirectory()) {
                        listFiles(file.getAbsolutePath());
                    }
                }
            }

        } else {
            System.out.println("Le chemin spécifié n'est pas un répertoire valide !");
        }
    }
}
