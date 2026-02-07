package org.example.libraryapi.dto;

public class DreamRequest {
    private String title;
    private String description;
    private String type;
    private Integer intensity;

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getType() { return type; }
    public Integer getIntensity() { return intensity; }

    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setType(String type) { this.type = type; }
    public void setIntensity(Integer intensity) { this.intensity = intensity; }
}
