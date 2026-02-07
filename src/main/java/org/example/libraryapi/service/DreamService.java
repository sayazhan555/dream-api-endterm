package org.example.libraryapi.service;

import org.example.libraryapi.dto.DreamRequest;
import org.example.libraryapi.dto.DreamResponse;
import org.example.libraryapi.exception.NotFoundException;
import org.example.libraryapi.model.Dream;
import org.example.libraryapi.model.DreamBase;
import org.example.libraryapi.patterns.DreamFactory;
import org.example.libraryapi.repository.DreamRepository;
import org.example.libraryapi.utils.AppLogger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DreamService {

    private final DreamRepository repository;

    public DreamService(DreamRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public DreamResponse create(DreamRequest request) {
        DreamBase base = DreamFactory.fromRequest(request);

        Dream dream = Dream.builder()
                .title(base.getTitle())
                .description(base.getDescription())
                .type(base.getType())
                .intensity(base.getIntensity())
                .build();


        AppLogger.getInstance().info("Creating dream: " + dream.getTitle());
        Dream saved = repository.save(dream);
        return toResponse(saved);
    }

    // READ ALL
    public List<DreamResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    // READ BY ID
    public DreamResponse getById(Long id) {
        Dream dream = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Dream not found: id=" + id));
        return toResponse(dream);
    }

    // UPDATE
    public DreamResponse update(Long id, DreamRequest request) {
        Dream existing = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Dream not found: id=" + id));

        existing.setTitle(request.getTitle());
        existing.setDescription(request.getDescription());
        if (request.getType() != null) {
            existing.setType(request.getType().toUpperCase());
        }
        if (request.getIntensity() != null) {
            existing.setIntensity(request.getIntensity());
        }

        AppLogger.getInstance().info("Updating dream id=" + id);
        Dream saved = repository.save(existing);
        return toResponse(saved);
    }

    // DELETE
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Dream not found: id=" + id);
        }
        AppLogger.getInstance().info("Deleting dream id=" + id);
        repository.deleteById(id);
    }

    // MAPPER
    private DreamResponse toResponse(Dream d) {
        return new DreamResponse(
                d.getId(),
                d.getTitle(),
                d.getDescription(),
                d.getType(),
                d.getIntensity()
        );
    }
}
