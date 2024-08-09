package com.example.simplenotemanager;

import com.example.simplenotemanager.Note;

public interface NoteService {
    void addNote(Note note);
    Note findNoteById(long id);
    void deleteNote(long id);
    void updateNote(Note note);
    Iterable<Note> findAllNotes();
}
