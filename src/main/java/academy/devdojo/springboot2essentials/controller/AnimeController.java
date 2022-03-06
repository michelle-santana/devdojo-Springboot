package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.service.AnimeService;
import academy.devdojo.springboot2.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
       public ResponseEntity<List<Anime>> list(){
        log.info(dateUtil.formatLocalDateTimeToDateBaseStyle(LocalDateTime.now()));
            return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
        }

    @GetMapping(path = "{/id}")
       public ResponseEntity<Anime> findById(@PathVariable long id){
        log.info(dateUtil.formatLocalDateTimeToDateBaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(service.findById(id));


    }


    }

