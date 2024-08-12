package com.example.simplenotemanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Optional;

/**
 * Concrete implementation of the service layer with constructor injection.
 */
@Service
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note findNoteById(long id) {
        Optional<Note> optionalNote = noteRepository.findById(id);
        return optionalNote.orElse(null);
    }

    public Iterable<Note> findAllNotes() {
       return noteRepository.findAll();
    }

    @Override
    public void addNote(Note note) {
        noteRepository.save(note);
    }

    @Override
    public void updateNote(Note note) {
        noteRepository.save(note);
    }

    @Override
    public void deleteNote(long id) {
        noteRepository.deleteById(id);
    }
}
