package academy.devdojo.springboot2essentials.controller;

import academy.devdojo.springboot2essentials.domain.entities.Anime;
import academy.devdojo.springboot2essentials.requests.AnimePostRequestBody;
import academy.devdojo.springboot2essentials.requests.AnimePutRequestBody;
import academy.devdojo.springboot2essentials.servicies.AnimeService;
import academy.devdojo.springboot2essentials.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("animes")
@Log4j2
@AllArgsConstructor
public class AnimeController {

    private final DateUtil dateUtil;

    private final AnimeService service;

    //listar animes
    @GetMapping
       public ResponseEntity<List<Anime>> listAllAnimes(){
        log.info(dateUtil.formatLocalDateTimeToDateBaseStyle(LocalDateTime.now()));
            return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
        }

     //listar animes por id
    @GetMapping(path = "/{id}")
       public ResponseEntity<Anime> findAnimesById(@PathVariable long id){
        return ResponseEntity.ok(service.findByIdOrThrowBadRequestException(id));
    }

    //cadastrar novos animes
    @PostMapping
       public ResponseEntity<Anime> saveAnimes(@RequestBody AnimePostRequestBody anime){
        return new ResponseEntity(service.save(anime), HttpStatus.CREATED);
    }

    //deletar animes
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteAnimes(@PathVariable long id){
        service.delete(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //atualizar animes
    @PutMapping
    public ResponseEntity<Void> replaceAnimes(@RequestBody AnimePutRequestBody animePutRequestBody) {
        service.replace(animePutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    }

