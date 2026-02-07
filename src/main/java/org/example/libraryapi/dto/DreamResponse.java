package org.example.libraryapi.dto;

public class DreamResponse {

    private Long id;
    private String title;
    private String description;
    private String type;
    private Integer intensity;

    public DreamResponse(Long id, String title, String description, String type, Integer intensity) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.intensity = intensity;
    }

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getType() {
        return type;
    }
    public Integer getIntensity() {
        return intensity;
    }
}
