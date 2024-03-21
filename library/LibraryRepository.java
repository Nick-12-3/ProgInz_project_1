package com.example.library;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// Автор: Николай Шарипов | Группа: ПИ21-3 | Научный руководитель: Чернышов Л.Н.
// Назначение класса: содержит запросы к БД.
public interface LibraryRepository extends JpaRepository<Library, Long>{

    @Query("SELECT p FROM Library p WHERE CONCAT(p.name, '', p.author, '', p.genre, '', p.path) LIKE %?1%")
    List<Library> search(String keyword);
}
