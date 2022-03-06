package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.repository.AnimeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AnimeService {

    //private final AnimeRepository repository;

    private List<Anime> animes = List.of(new Anime(1L, "Naruto"),
            new Anime( 2L , "Damon Slayer"),
            new Anime( 3L, "Dragon Ball Z"));

    public List<Anime> listAll(){
        return animes;
    }

    public Anime findById(long id){
return animes.stream()
        .filter(animes -> animes.getId().equals(id))
        .findFirst()
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found!"));
    }


}
