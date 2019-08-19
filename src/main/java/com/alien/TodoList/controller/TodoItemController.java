package com.alien.TodoList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import com.alien.TodoList.pojo.TodoItem;
import com.alien.TodoList.repository.TodoItemRepository;

import java.util.Date;
import java.util.List;

@RestController
public class TodoItemController {
    @Autowired
    private TodoItemRepository todoitemRepository;

    // insert new test data
    @PostMapping(path="/api/createTodoitem")
    public @ResponseBody String addNewTodo(@RequestBody TodoItem todoItem) {

        // TodoItem todo = new TodoItem();
        // n.setName(name);
        // n.setEmail(email);
        // System.out.println(todoItem);
        todoitemRepository.save(todoItem);
        return "saved successfully";
    }

    @PostMapping(path="/api/changeIsdone")
    public @ResponseBody String changeIsdone(@RequestBody TodoItem todoItem) {

        // System.out.println(todoItem);
        todoitemRepository.save(todoItem);
        return "saved successfully";
    }

    @PostMapping(path="/api/editTodoitem")
    public @ResponseBody String editTodoitem(@RequestBody TodoItem todoItem) {

        // System.out.println(todoItem);
        todoitemRepository.save(todoItem);
        return "saved successfully";
    }

    // get all test data
    @GetMapping(path="/api/getallTodoitem")
    public  Iterable<TodoItem> getAllTodoitem() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return todoitemRepository.findAll(sort);
    }

    @GetMapping(path="/api/getTodoitem")
    public @ResponseBody TodoItem getTodoitemByid(@RequestParam Integer id) {

        // System.out.println(todoItem);
        // todoitemRepository.save(todoItem);
        return todoitemRepository.findById(id);
    }

    @GetMapping(path="/api/searchTodoitem")
    public @ResponseBody List<TodoItem> searchTodoitem(@RequestParam String keyword) {

        System.out.println(keyword);
        // todoitemRepository.save(todoItem);
        return todoitemRepository.findAllByTodoTitleLike('%'+keyword+'%');
    }

}
