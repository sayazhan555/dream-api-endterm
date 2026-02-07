package org.example.libraryapi.model;

public class NightmareDream extends DreamBase {

    public NightmareDream(String title, String description, Integer intensity) {
        this.title = title;
        this.description = description;
        this.type = "NIGHTMARE";
        this.intensity = intensity;
    }
}
