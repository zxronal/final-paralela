package com.poli.finalprogramacion.service;

import com.poli.finalprogramacion.model.User;
import com.poli.finalprogramacion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return this.saveUser(user);
    }

    public List<User> listUsers() {
        return userRepository.findAllByDeletedFalse();
    }

    public void deleteUser(Long userId) {
       Optional<User> optionalUser = this.userRepository.findById(userId);
       if (!optionalUser.isPresent()) throw new EntityNotFoundException("The User with id: " + userId + " could not be found.");
       User user = optionalUser.get();
       user.setDeleted(true);
       this.userRepository.save(user);
    }
}
