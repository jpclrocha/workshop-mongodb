package com.jopezin.workshopmongodb.config;


import com.jopezin.workshopmongodb.domain.Post;
import com.jopezin.workshopmongodb.domain.User;
import com.jopezin.workshopmongodb.repositories.PostRepository;
import com.jopezin.workshopmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");



        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        Post post1 = new Post(null, LocalDate.from(dtf.parse("21/03/2018")),"Partiu viagem", "Vou viajar para Sao Paulo. Abracos!", maria);
        Post post2 = new Post(null, LocalDate.from(dtf.parse("23/03/2018")),"Bom dia", "Acordei feliz hoje!",maria);

        postRepository.saveAll(Arrays.asList(post1,post2));
        userRepository.saveAll(Arrays.asList(maria, alex, bob));
    }
}
