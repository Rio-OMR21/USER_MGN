package com.orinaryaga.ManageUserWeb.repository;

import com.orinaryaga.ManageUserWeb.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
    public Integer countById(Integer id);
}