package org.example.exercice3.interfaces;

import java.io.IOException;
import java.util.List;

public interface IMetier<T> {
    T add(T o) throws IOException;
    List<T> getAll() throws IOException, ClassNotFoundException;
    T findByNom(String nom) throws IOException, ClassNotFoundException;
    void delete(String nom) throws IOException;
    void saveAll() throws IOException;
}
