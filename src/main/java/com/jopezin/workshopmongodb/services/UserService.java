package com.jopezin.workshopmongodb.services;

import com.jopezin.workshopmongodb.domain.User;
import com.jopezin.workshopmongodb.dto.UserDTO;
import com.jopezin.workshopmongodb.exceptions.ObjectNotFoundException;
import com.jopezin.workshopmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService{

    @Autowired
    public UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Usuario nao encontrado!"));
    }

    public User insert(User obj){
        return userRepository.insert(obj);
    }

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }


}
