package com.jopezin.workshopmongodb.resources;

import com.jopezin.workshopmongodb.domain.User;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController()
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User maria = new User(1, "maria", "maria@gmail.com");
        User joao = new User(2,"joao","joao@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria, joao));
        return ResponseEntity.ok().body(list);
    }
}
