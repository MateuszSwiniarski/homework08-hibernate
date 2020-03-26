package com.rodzyn.homework08hibernate.controller;

import com.rodzyn.homework08hibernate.model.notebook.Notebook;
import com.rodzyn.homework08hibernate.service.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/notebook")
public class NotebookController {

    private NotebookService notebookService;

    @Autowired
    public NotebookController(NotebookService notebookService) {
        this.notebookService = notebookService;
    }

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("notes", notebookService.getAllNotes());
        model.addAttribute("note", new Notebook());
        return "notes";
    }

    @GetMapping("/{id}")
    public String getOneOnte(@PathVariable("id") Long id, Model model){
        model.addAttribute("onenote", notebookService.getOneNote(id));
        return "getone";
    }

    @PostMapping
    public String saveNote(@ModelAttribute Notebook notebook){
        notebookService.saveNote(notebook);
        return "redirect:/notebook";
    }

    @GetMapping("/modify/{id}")
    public String modifyNote(@PathVariable("id") Long id, Model model){
        Optional<Notebook> oneNote = notebookService.getOneNote(id);
        model.addAttribute("modifynote", oneNote.get());
        return "modnotes";
    }

    @PostMapping("/modify")
    public String modifyNote(@ModelAttribute Notebook notebook){
        notebookService.updateNote(notebook.getTitle(), notebook.getNote(), notebook.getId());
        return "redirect:/notebook";
    }

    @GetMapping("/delete/{id}")
    public String deleteNote(@PathVariable("id") Long id){
        notebookService.deleteNote(id);
        return "redirect:/notebook";
    }

}
