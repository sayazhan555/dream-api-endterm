package org.example.libraryapi.controller;

import org.example.libraryapi.dto.DreamRequest;
import org.example.libraryapi.dto.DreamResponse;
import org.example.libraryapi.service.DreamService;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.List;

@RestController
@RequestMapping("/api/dreams")
public class DreamController {

    private final DreamService service;

    public DreamController(DreamService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<DreamResponse> create(@RequestBody DreamRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(request));
    }

    // READ ALL
    @GetMapping
    public List<DreamResponse> getAll() {
        return service.getAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public DreamResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public DreamResponse update(@PathVariable Long id, @RequestBody DreamRequest request) {
        return service.update(id, request);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
