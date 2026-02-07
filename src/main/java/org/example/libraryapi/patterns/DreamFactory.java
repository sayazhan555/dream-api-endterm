package org.example.libraryapi.patterns;

import org.example.libraryapi.dto.DreamRequest;
import org.example.libraryapi.model.DreamBase;
import org.example.libraryapi.model.LucidDream;
import org.example.libraryapi.model.NightmareDream;
import org.example.libraryapi.model.NormalDream;

public class DreamFactory {

    public static DreamBase fromRequest(DreamRequest req) {
        String type = req.getType() == null ? "NORMAL" : req.getType().toUpperCase();

        Integer intensity = req.getIntensity();
        if (intensity == null) {
            if (type.equals("NIGHTMARE")) intensity = 9;
            else if (type.equals("LUCID")) intensity = 7;
            else intensity = 5;
        }

        String title = req.getTitle();
        String description = req.getDescription();

        return switch (type) {
            case "NIGHTMARE" -> new NightmareDream(title, description, intensity);
            case "LUCID" -> new LucidDream(title, description, intensity);
            default -> new NormalDream(title, description, intensity);
        };
    }
}

