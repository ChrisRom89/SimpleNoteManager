package com.example.simplenotemanager;

import org.springframework.data.repository.CrudRepository;

/**
 * Note repository representing the storage.
 */
public interface NoteRepository extends CrudRepository<Note, Long> {
}
