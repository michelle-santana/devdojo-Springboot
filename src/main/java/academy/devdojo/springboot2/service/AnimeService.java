package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.repository.AnimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService {

    //private final AnimeRepository repository;

    public List<Anime> listAll(){
        return List.of(new Anime(1L, "Naruto"),
                new Anime( 2L , "Damon Slayer"),
                new Anime( 3L, "Dragon Ball Z"));
    }

}
