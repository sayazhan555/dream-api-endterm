package org.example.libraryapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "dreams")
public class Dream {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String type;      // LUCID / NIGHTMARE / NORMAL
    private Integer intensity; // 1..10

    public Dream() {}

    public Dream(String title, String description, String type, Integer intensity) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.intensity = intensity;
    }

    // ===== Builder =====
    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private String title;
        private String description;
        private String type;
        private Integer intensity;

        public Builder title(String title) { this.title = title; return this; }
        public Builder description(String description) { this.description = description; return this; }
        public Builder type(String type) { this.type = type; return this; }
        public Builder intensity(Integer intensity) { this.intensity = intensity; return this; }

        public Dream build() { return new Dream(title, description, type, intensity); }
    }
    // ===================

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getType() { return type; }
    public Integer getIntensity() { return intensity; }

    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setType(String type) { this.type = type; }
    public void setIntensity(Integer intensity) { this.intensity = intensity; }
}
