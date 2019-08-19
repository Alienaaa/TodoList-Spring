package com.alien.TodoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alien.TodoList.pojo.TodoItem;

import java.util.List;

public interface TodoItemRepository extends JpaRepository<TodoItem,Long>{
    TodoItem findById(Integer id);
    List<TodoItem> findAllByTodoTitleLike(String keyword);
}
