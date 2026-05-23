package com.notesapp.notesapp.controller;

import com.notesapp.notesapp.model.Note;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NoteController {

    List<Note> notes = new ArrayList<>();

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("notes", notes);

        return "index";
    }

    @PostMapping("/add")
    public String addNote(@RequestParam String title,
                          @RequestParam String content) {

        int id = notes.size() + 1;

        notes.add(new Note(id, title, content));

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteNote(@PathVariable int id) {

        notes.removeIf(note -> note.getId() == id);

        return "redirect:/";
    }
}