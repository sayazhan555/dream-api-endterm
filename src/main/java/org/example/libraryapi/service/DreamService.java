package org.example.libraryapi.service;

import org.example.libraryapi.dto.DreamRequest;
import org.example.libraryapi.dto.DreamResponse;
import org.example.libraryapi.exception.NotFoundException;
import org.example.libraryapi.model.Dream;
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
        Dream dream = toModel(request);
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
        Dream dream = toModel(request);
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

    // MAPPERS
    private Dream toModel(DreamRequest req) {
        Dream d = new Dream();
        d.setTitle(req.getTitle());
        d.setType(req.getType());
        d.setDescription(req.getDescription());
        return d;
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
