package org.example.libraryapi.model;

public abstract class DreamBase {

    protected String title;
    protected String description;
    protected String type;       // LUCID / NIGHTMARE / NORMAL
    protected Integer intensity; // 1..10

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getType() { return type; }
    public Integer getIntensity() { return intensity; }
}
