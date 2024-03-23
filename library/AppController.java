package com.example.library;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;


// Автор: Николай Шарипов | Группа: ПИ21-3 | Научный руководитель: Чернышов Л.Н.
// Назначение класса: контроллеры для взаимодействия с БД посредством MVC.
@Controller
public class AppController {

    @Autowired
    private LibraryService service;

    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword){
        List<Library> listLibrary = service.listAll(keyword);
        model.addAttribute("listLibrary", listLibrary);
        model.addAttribute("keyword", keyword);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewLibraryForm(Model model){
        Library library = new Library();
        model.addAttribute("library", library);
        return "new_library";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveLibrary(@ModelAttribute("library") Library library){
        service.save(library);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditLibraryForm(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("edit_library");
        Library library = service.get(id);
        mav.addObject("library", library);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteLibrary(@PathVariable(name = "id") Long id){
        service.delete(id);
        return "redirect:/";
    }
}
