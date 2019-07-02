package com.example.easynotes.controller;

import com.example.easynotes.model.Note;
import com.example.easynotes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//@RestController
@Controller
@RequestMapping("/db")
public class NoteController {

    @Autowired
    NoteRepository noteRepository;

    //Get all notes

    @GetMapping("/start")
    @ResponseBody
    public String home(){
        return "start";
    }

    @GetMapping("/notes")
    public List<Note> getAllNotes(){

        return noteRepository.findAll();
    }

    //Create new note

    @PostMapping("/notes")
    public Note createNote(@Valid @RequestBody Note note ){

        return noteRepository.save(note);
    }
}
