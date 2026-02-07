package org.example.libraryapi.repository;

import org.example.libraryapi.model.Dream;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DreamRepository extends JpaRepository<Dream, Long> {
}
