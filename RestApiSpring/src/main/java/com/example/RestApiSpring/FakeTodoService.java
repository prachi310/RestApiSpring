package com.example.RestApiSpring;

import org.springframework.stereotype.Service;

@Service
public class FakeTodoService implements TodoService{


    @Override
    public String doSomething() {
        return "something";
    }
}
