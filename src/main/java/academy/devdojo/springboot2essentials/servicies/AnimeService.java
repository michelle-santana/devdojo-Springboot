package academy.devdojo.springboot2essentials.servicies;

import academy.devdojo.springboot2essentials.domain.entities.Anime;
import academy.devdojo.springboot2essentials.repositories.AnimeRepository;
import academy.devdojo.springboot2essentials.requests.AnimePostRequestBody;
import academy.devdojo.springboot2essentials.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository repository;


    public List<Anime> listAll(){

        return repository.findAll();
    }

    public Anime findByIdOrThrowBadRequestException(long id){
       return repository.findById(id)
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found!"));
    }

    public Anime save(AnimePostRequestBody animePostRequestBody) {
       Anime anime = Anime.builder()
               .name(animePostRequestBody.getName())
               .build();
        return repository.save(anime);
    }

    public void delete(long id) {
        repository.delete(findByIdOrThrowBadRequestException(id));

    }
//
//    public void replace(AnimePutRequestBody animePutRequestBody) {
//        findByIdOrThrowBadRequestException(animePutRequestBody.getId());
//        Anime anime = Anime.builder()
//                .id(animePutRequestBody.getId())
//                .name(animePutRequestBody.getName())
//                .build();
//        repository.save(anime);
//
//    }

    public void replace(AnimePutRequestBody animePutRequestBody) {
        Anime savedAnime = findByIdOrThrowBadRequestException(animePutRequestBody.getId());
        Anime anime = Anime.builder()
                .id(savedAnime.getId())
                .name(animePutRequestBody.getName())
                .build();

        repository.save(anime);
    }
}
