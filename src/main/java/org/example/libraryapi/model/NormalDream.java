package org.example.libraryapi.model;

public class NormalDream extends DreamBase {

    public NormalDream(String title, String description, Integer intensity) {
        this.title = title;
        this.description = description;
        this.type = "NORMAL";
        this.intensity = intensity;
    }
}
