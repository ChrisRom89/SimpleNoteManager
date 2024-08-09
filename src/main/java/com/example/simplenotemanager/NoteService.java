package com.example.simplenotemanager;

import com.example.simplenotemanager.Note;

public interface NoteService {
    void addNote(String title, String text);
    Note findNoteById(long id);
    void deleteNoteById(long id);
    void updateNote(Note note);
}
