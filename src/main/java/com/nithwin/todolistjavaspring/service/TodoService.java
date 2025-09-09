package com.nithwin.todolistjavaspring.service;

import com.nithwin.todolistjavaspring.model.Todo;
import com.nithwin.todolistjavaspring.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;


    public Todo addTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public boolean deleteTodo(long id) {
        if(todoRepository.existsById(id)){
        todoRepository.deleteById(id);
        return true;
        }
        return false;
    }

    public boolean updateTodo(long id,Todo res) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if(optionalTodo.isPresent()){
        Todo original = todoRepository.findById(id).get();
        original.setCompleted(res.isCompleted());
        todoRepository.save(original);
        return true;
        }
        return false;
    }
}
