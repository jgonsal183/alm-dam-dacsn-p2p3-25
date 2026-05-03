package com.ejemplo.notas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class NoteController {

    @Autowired
    private NoteRepository repository;

    @GetMapping("/")
    public String index(Model model) {
        List<Note> notes = repository.findAllByOrderByPositionAsc();
        
        Set<String> tags = new HashSet<>();
        for (Note n : notes) {
            if (n.getTags() != null && !n.getTags().isEmpty()) {
                for (String t : n.getTags().split(",")) {
                    tags.add(t.trim());
                }
            }
        }

        // En Java 8 usamos collect(Collectors.toList())
        model.addAttribute("notes", notes);
        model.addAttribute("allTags", tags.stream().sorted().collect(Collectors.toList()));
        model.addAttribute("today", LocalDate.now().toString());
        return "index";
    }

    @PostMapping(value = "/api", consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    public String handleFormAction(@RequestParam String action, 
                                   @ModelAttribute Note note) {
        if ("create".equals(action)) {
            repository.incrementAllPositions();
            note.setPosition(0);
            repository.save(note);
        } else if ("delete".equals(action)) {
            repository.deleteById(note.getId());
        } else if ("update".equals(action)) {
            // findById en Java 8 devuelve Optional, usamos orElse(null)
            Note existing = repository.findById(note.getId()).orElse(null);
            if (existing != null) {
                existing.setContent(note.getContent());
                existing.setCreatedAt(note.getCreatedAt());
                existing.setTags(note.getTags());
                repository.save(existing);
            }
        }
        return "{\"status\":\"success\"}";
    }

    @PostMapping(value = "/api", consumes = "application/json")
    @ResponseBody
    public String handleJsonAction(@RequestBody Map<String, Object> payload) {
        if ("reorder".equals(payload.get("action"))) {
            List<Map<String, Object>> order = (List<Map<String, Object>>) payload.get("order");
            for (Map<String, Object> item : order) {
                Long id = Long.valueOf(item.get("id").toString());
                Integer pos = Integer.valueOf(item.get("position").toString());
                
                Note n = repository.findById(id).orElse(null);
                if (n != null) {
                    n.setPosition(pos);
                    repository.save(n);
                }
            }
        }
        return "{\"status\":\"success\"}";
    }
}