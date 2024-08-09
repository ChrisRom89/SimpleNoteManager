package com.example.simplenotemanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {
    private final NoteService noteService;

    @Autowired
    public Controller(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/list")
    public Iterable<Note> findAllNotes() {
        return noteService.findAllNotes();
    }

    @GetMapping("/{id}")
    public Note findNoteById(@PathVariable Long id) {
        return noteService.findNoteById(id);
    }

    @PostMapping
    public void addNote(@RequestBody Note note) {
        noteService.addNote(note);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
    }

    @PutMapping("/{id}")
    public void updateNote(@PathVariable Long id, @RequestBody Note note) {
        Note existingNote = noteService.findNoteById(id);
        if (existingNote != null) {
            note.setId(id);
            noteService.addNote(note);
        }
    }

}
