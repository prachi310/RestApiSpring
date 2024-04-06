package com.example.RestApiSpring;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

    private TodoService todoService;
    private List<ToDo> toDoList;


    public TodoController(TodoService todoService) {
        this.todoService = todoService;
        this.toDoList = new ArrayList<>();
        toDoList.add(new ToDo(1, true, "ToDo1", 1));
        toDoList.add(new ToDo(2, false, "ToDo2", 2));
    }

    @GetMapping
    public ResponseEntity<List<ToDo>> getTodos() {
        System.out.println("method invoked : " + this.todoService.doSomething());
        return ResponseEntity.ok(toDoList);
    }

    @PostMapping("/createTodos")
    public ResponseEntity<List<ToDo>> createToDo(@RequestBody ToDo newToDo) {
        toDoList.add(newToDo);
        return ResponseEntity.ok(toDoList);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {

        for (ToDo todo : toDoList) {
            if (todo.getId() == id)
                return ResponseEntity.ok(todo);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ToDo not found");
    }

    @DeleteMapping("/DeletedById/{id}")
    public ResponseEntity<?> deleteTodoById(@PathVariable("id") Long id) {

        for (ToDo toDo : toDoList) {
            if (toDo.getId() == id) {
                toDoList.remove(toDo);
                return ResponseEntity.ok("Deleted " + toDo);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ToDo not found/Deleted");

    }

}

