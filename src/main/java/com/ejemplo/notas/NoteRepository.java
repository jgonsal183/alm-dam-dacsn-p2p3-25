package com.ejemplo.notas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findAllByOrderByPositionAsc();

    @Modifying
    @Transactional
    @Query("UPDATE Note n SET n.position = n.position + 1")
    void incrementAllPositions();
}