package org.example.libraryapi.repository;

import org.example.libraryapi.model.Dream;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DreamRepositoryJdbc {

    private final JdbcTemplate jdbc;

    public DreamRepositoryJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    //Create
    public Dream save(Dream dream) {
        jdbc.update(
                "INSERT INTO dreams(title, type, description, intensity) VALUES (?, ?, ?, ?)",
                dream.getTitle(), dream.getType(), dream.getDescription(), dream.getIntensity()
        );
        return dream;
    }


    //Read all
    public List<Dream> findAll() {
        return jdbc.query(
                "SELECT id, title, type, description, intensity FROM dreams ORDER BY id",
                (rs, rowNum) -> {
                    Dream d = new Dream();
                    d.setId(rs.getLong("id"));
                    d.setTitle(rs.getString("title"));
                    d.setType(rs.getString("type"));
                    d.setDescription(rs.getString("description"));
                    d.setIntensity(rs.getInt("intensity"));
                    return d;
                }
        );
    }


    //Read one
    public Optional<Dream> findById(long id) {
        List<Dream> list = jdbc.query(
                "SELECT id, title, type, description, intensity FROM dreams WHERE id = ?",
                (rs, rowNum) -> {
                    Dream d = new Dream();
                    d.setId(rs.getLong("id"));
                    d.setTitle(rs.getString("title"));
                    d.setType(rs.getString("type"));
                    d.setDescription(rs.getString("description"));
                    d.setIntensity(rs.getInt("intensity"));
                    return d;
                },
                id
        );
        return list.stream().findFirst();
    }

    public boolean update(long id, Dream dream) {
        int updated = jdbc.update(
                "UPDATE dreams SET title=?, type=?, description=?, intensity=? WHERE id=?",
                dream.getTitle(), dream.getType(), dream.getDescription(), dream.getIntensity(), id
        );
        return updated > 0;
    }

    public boolean delete(long id) {
        int deleted = jdbc.update("DELETE FROM dreams WHERE id = ?", id);
        return deleted > 0;
    }
}
