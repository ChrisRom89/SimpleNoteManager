package com.example.simplenotemanager;

import com.example.simplenotemanager.Note;

/**
 * Service layer with basic CRUD operations (create, read, update, delete) and a method to obtain all stored notes.
 */
public interface NoteService {
    void addNote(Note note);
    Note findNoteById(long id);
    void deleteNote(long id);
    void updateNote(Note note);
    Iterable<Note> findAllNotes();
}
