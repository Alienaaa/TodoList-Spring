package com.alien.TodoList.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.alien.TodoList.pojo.User;

public interface UserRepository extends JpaRepository<User,Long>{
    // public List<User> findByEmailLike(String email);
}
