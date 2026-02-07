package org.example.libraryapi.model;

public class LucidDream extends DreamBase {

    public LucidDream(String title, String description, Integer intensity) {
        this.title = title;
        this.description = description;
        this.type = "LUCID";
        this.intensity = intensity;
    }
}
