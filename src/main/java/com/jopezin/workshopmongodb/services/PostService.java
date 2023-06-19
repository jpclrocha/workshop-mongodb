package com.jopezin.workshopmongodb.services;

import com.jopezin.workshopmongodb.domain.Post;
import com.jopezin.workshopmongodb.exceptions.ObjectNotFoundException;
import com.jopezin.workshopmongodb.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id){
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado!"));
    }

    public List<Post> findByTitle(String text){
        return postRepository.searchTitle(text);
    }
}
