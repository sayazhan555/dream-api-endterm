package org.example.libraryapi.patterns;

import org.example.libraryapi.dto.DreamRequest;
import org.example.libraryapi.model.DreamBase;
import org.example.libraryapi.model.LucidDream;
import org.example.libraryapi.model.NightmareDream;
import org.example.libraryapi.model.NormalDream;

public class DreamFactory {

    public static DreamBase fromRequest(DreamRequest req) {
        String type = (req.getType() == null) ? "NORMAL" : req.getType().toUpperCase();

        Integer intensity = req.getIntensity();
        if (intensity == null) {
            intensity = switch (type) {
                case "NIGHTMARE" -> 9;
                case "LUCID" -> 7;
                default -> 5;
            };
        }

        return switch (type) {
            case "NIGHTMARE" -> new NightmareDream(req.getTitle(), req.getDescription(), intensity);
            case "LUCID" -> new LucidDream(req.getTitle(), req.getDescription(), intensity);
            default -> new NormalDream(req.getTitle(), req.getDescription(), intensity);
        };
    }
}
