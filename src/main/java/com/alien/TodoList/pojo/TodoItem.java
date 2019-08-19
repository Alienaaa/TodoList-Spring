package com.alien.TodoList.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String todoTitle;
    private Date todoDDL;
    private Date todoCreateData;
    private Boolean isDone;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTodoTitle() {
        return todoTitle;
    }

    public void setTodoTitle(String todoTitle) {
        this.todoTitle = todoTitle;
    }

    public Date getTodoDDL() {
        return todoDDL;
    }

    public void setTodoDDL(Date todoDDL) {
        this.todoDDL = todoDDL;
    }
    public Date getTodoCreateData() {
        return todoCreateData;
    }

    public void setTodoCreateData(Date todoCreateData) {
        this.todoCreateData = todoCreateData;
    }

    public Boolean getisDone() {
        return isDone;
    }

    public void setisDone(Boolean isDone) {
        this.isDone = isDone;
    }
}
