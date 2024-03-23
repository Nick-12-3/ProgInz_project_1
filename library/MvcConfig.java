package com.example.library;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


// Автор: Николай Шарипов | Группа: ПИ21-3 | Научный руководитель: Чернышов Л.Н.
// Назначение класса: конфигурация и сборка воедино Java-проектов.
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
    }

}
