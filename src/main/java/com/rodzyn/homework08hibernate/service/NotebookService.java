package com.rodzyn.homework08hibernate.service;

import com.rodzyn.homework08hibernate.model.notebook.Notebook;
import com.rodzyn.homework08hibernate.repository.NotebookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotebookService {

    private NotebookRepository noteBookRepo;

    @Autowired
    public NotebookService(NotebookRepository noteBookRepo) {
        this.noteBookRepo = noteBookRepo;
        noteBookRepo.save(new Notebook("Example note", "This note is only for training"));
        noteBookRepo.save(new Notebook("Play with note", "You can create new, or delete note"));
    }

    public List<Notebook> getAllNotes(){
        return noteBookRepo.findAll();
    }

    public Optional<Notebook> getOneNote(Long id){
        return noteBookRepo.findById(id);
    }

    public void saveNote(Notebook notebook){
        notebook.setUpdateDate(notebook.getCreateDate());
        noteBookRepo.save(notebook);
    }

    public void deleteNote(Long id){
        noteBookRepo.deleteById(id);
    }

    public void updateNote(String title, String note, Long id){
        Notebook notebook = new Notebook();
        noteBookRepo.updateNote(title, note, notebook.getCreateDate().toString(), id);
    }
}
