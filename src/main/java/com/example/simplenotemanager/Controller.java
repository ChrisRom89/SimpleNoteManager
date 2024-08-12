package com.example.simplenotemanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * The controller handles incoming HTTP REST requests and calls the corresponding service method.
 * Dependency injection is performed via constructor injection.
 */
@RestController
@RequestMapping("/api")
public class Controller {
    private final NoteService noteService;

    @Autowired
    public Controller(NoteService noteService) {
        this.noteService = noteService;
    }

    /**
     * Get all available note entries. The endpoint is /api/list with the GET method.
     * @return Iterable of Note
     */
    @GetMapping("/list")
    public Iterable<Note> findAllNotes() {
        return noteService.findAllNotes();
    }

    /**
     * Get a stored note by passing the ID. The endpoint is /api/{id} with the GET method.
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Note findNoteById(@PathVariable Long id) {
        return noteService.findNoteById(id);
    }

    /**
     * Put a new note to the storage. The endpoint is /api/ with the POST method.
     * @param note consisting of title and text contained in the body of the request
     */
    @PostMapping
    public void addNote(@RequestBody Note note) {
        noteService.addNote(note);
    }

    /**
     * Remove the note from the storage matching a specific id. The endpoint is /api/{id} with the DELETE method.
     * @param id ID of the note, which is deleted
     */
    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
    }

    /**
     * Change the note entry (title and text) of a specific id in the storage. The endpoint is /api/{id} with the
     * PUT method.
     * @param id ID of the note, which is updated
     * @param note Containing the new note data
     */
    @PutMapping("/{id}")
    public void updateNote(@PathVariable Long id, @RequestBody Note note) {
        Note existingNote = noteService.findNoteById(id);
        if (existingNote != null) {
            note.setId(id);
            noteService.addNote(note);
        }
    }

}
