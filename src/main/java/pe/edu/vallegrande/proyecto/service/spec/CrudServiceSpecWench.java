package pe.edu.vallegrande.proyecto.service.spec;

import java.util.List;
import pe.edu.vallegrande.proyecto.model.Wench;

public class CrudServiceSpecWench implements CrudServiceSpecClient<Wench> {

    @Override
    public List<Wench> getAll() {
        // Implement code to fetch all Wench records from the database
        return null;
    }

    @Override
    public Wench getById(String id) {
        // Implement code to fetch a Wench record by ID from the database
        return null;
    }

    @Override
    public List<Wench> get(Wench bean) {
        // Implement code to fetch Wench records based on the filter provided
        return null;
    }

    @Override
    public void insert(Wench bean) {
        // Implement code to insert a new Wench record into the database
    }

    @Override
    public void update(Wench bean) {
        // Implement code to update an existing Wench record in the database
    }

    @Override
    public void delete(String id) {
        // Implement code to delete a Wench record by ID from the database
    }

    @Override
    public void delete(Integer id) {
        // Implement code to delete a Wench record by ID from the database
    }
}
