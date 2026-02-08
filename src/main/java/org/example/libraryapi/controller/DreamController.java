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

    // Create
    @PostMapping
    public ResponseEntity<DreamResponse> create(@RequestBody DreamRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }


    // Read all
    @GetMapping
    public List<DreamResponse> getAll() {
        return service.getAll();
    }

    // Read by id
    @GetMapping("/{id}")
    public DreamResponse getById(@PathVariable long id) {
        return service.getById(id);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @RequestBody DreamRequest request) {
        service.update(id, request);
        return ResponseEntity.noContent().build();
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
