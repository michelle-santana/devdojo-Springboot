package academy.devdojo.springboot2essentials.service;

import academy.devdojo.springboot2essentials.domain.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AnimeService {

    //private final AnimeRepository repository;

    private static List<Anime> animes;

    static {
        animes = new ArrayList<>(List.of(
                new Anime(1L, "Naruto"),
                new Anime(2L, "Damon Slayer"),
                new Anime(3L, "Dragon Ball Z")));
    }

    public List<Anime> listAll(){
        return animes;
    }

    public Anime findById(long id){
       return animes.stream()
        .filter(animes -> animes.getId().equals(id))
        .findFirst()
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found!"));
    }


    public Anime save(Anime anime) {
        anime.setId(ThreadLocalRandom.current().nextLong());
        animes.add(anime);
        return anime;
    }

    public void delete(long id) {
        animes.remove(findById(id));

    }

    public void replace(Anime anime) {
        delete(anime.getId());
        animes.add(anime);
    }
}
