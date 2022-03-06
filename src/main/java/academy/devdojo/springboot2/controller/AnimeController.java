package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("anime")
@Log4j2
@AllArgsConstructor
public class AnimeController {

    private DateUtil dateUtil;

    //listar animes
    @GetMapping(path = "/list")
       public List<Anime> list(){
        log.info(dateUtil.formatLocalDateTimeToDateBaseStyle(LocalDateTime.now()));
            return List.of(new Anime("Naruto"), new Anime("Damon Slayer"));
        }

    }

