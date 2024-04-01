package com.example.RestApiSpring;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

    private TodoService todoService;
    private List<ToDo> toDoList;


    public TodoController(TodoService todoService) {
        this.todoService = todoService;
        this.toDoList=new ArrayList<>();
        toDoList.add(new ToDo(1,true,"ToDo1",1));
        toDoList.add(new ToDo(2,false,"ToDo2",2));
    }

    @GetMapping
    public ResponseEntity<List<ToDo>> getTodos()
    {
        System.out.println("method invoked : " +this.todoService.doSomething());
        return ResponseEntity.ok(toDoList);
    }


}
