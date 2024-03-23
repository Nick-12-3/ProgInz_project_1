package com.example.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// Автор: Николай Шарипов | Группа: ПИ21-3 | Научный руководитель: Чернышов Л.Н.
// Назначение класса: запуск программы.
@SpringBootApplication
public class LibraryApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }
}
