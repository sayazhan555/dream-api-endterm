package org.example.libraryapi.service;

import org.example.libraryapi.dto.DreamRequest;
import org.example.libraryapi.dto.DreamResponse;
import org.example.libraryapi.exception.NotFoundException;
import org.example.libraryapi.model.Dream;
import org.example.libraryapi.model.DreamBase;
import org.example.libraryapi.patterns.DreamFactory;
import org.example.libraryapi.repository.DreamRepositoryJdbc;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DreamService {

    private final DreamRepositoryJdbc repo;

    public DreamService(DreamRepositoryJdbc repo) {
        this.repo = repo;
    }

    // Create
    public DreamResponse create(DreamRequest request) {
        DreamBase base = DreamFactory.fromRequest(request); // Factory выбирает Lucid/Nightmare/Normal

        Dream dream = Dream.builder()
                .title(base.getTitle())
                .description(base.getDescription())
                .type(base.getType())
                .intensity(base.getIntensity())
                .build();

        Dream saved = repo.save(dream);
        return toResponse(saved);
    }

    // Read all
    public List<DreamResponse> getAll() {
        return repo.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    // Read by id
    public DreamResponse getById(long id) {
        Dream dream = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Dream not found: " + id));
        return toResponse(dream);
    }

    // Update
    public void update(long id, DreamRequest request) {
        DreamBase base = DreamFactory.fromRequest(request);

        Dream dream = Dream.builder()
                .title(base.getTitle())
                .description(base.getDescription())
                .type(base.getType())
                .intensity(base.getIntensity())
                .build();

        if (!repo.update(id, dream)) {
            throw new NotFoundException("Dream not found: " + id);
        }
    }

    // Delete
    public void delete(long id) {
        if (!repo.delete(id)) {
            throw new NotFoundException("Dream not found: " + id);
        }
    }

    private DreamResponse toResponse(Dream d) {
        return new DreamResponse(
                d.getId(),
                d.getTitle(),
                d.getType(),
                d.getDescription(),
                d.getIntensity()
        );
    }
}
