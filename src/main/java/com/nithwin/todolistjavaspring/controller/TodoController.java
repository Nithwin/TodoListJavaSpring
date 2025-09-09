package com.nithwin.todolistjavaspring.controller;

import com.nithwin.todolistjavaspring.model.Todo;
import com.nithwin.todolistjavaspring.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@CrossOrigin(value = "http://localhost:3000")
@RequestMapping("/api/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping("/create")
    public Todo addTodo(@RequestBody Todo todo){
        return todoService.addTodo(todo);
    }

    @GetMapping()
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTodo(@PathVariable long id){
        if(todoService.deleteTodo(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateTodo(@PathVariable long id, @RequestBody Todo res){
        if(todoService.updateTodo(id,res)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }


}

