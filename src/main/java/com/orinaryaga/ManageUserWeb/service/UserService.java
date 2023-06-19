package com.orinaryaga.ManageUserWeb.service;

import com.orinaryaga.ManageUserWeb.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.orinaryaga.ManageUserWeb.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> listAll() {
        return (List<User>) repo.findAll();
    }

    public void save(User user) {
        repo.save(user);
    }

    public User get(Integer id) throws UserNotFoundException {
        Optional<User> result = repo.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new UserNotFoundException("User not found with ID"+id);
    }
    

    public void delete(Integer id) {
        Integer count =  repo.countById(id);
        if (count == null || count == 0) {
            try {
                throw new UserNotFoundException("Could not find user with ID:" + id);
            } catch (UserNotFoundException e) {
                e.printStackTrace();
            }        }
         repo.deleteById(id);
    
    }

    @Autowired
    UserRepository userRepository;

}
