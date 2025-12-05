package org.example.crud.DAO;

import org.example.crud.entity.Instructor;

public interface AppDAO {

    void save(Instructor instructor);
    Instructor findById(int id);
    void delete(int id);

}
