package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.domain.Anime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("anime")
public class AnimeController {

    //listar animes
    @GetMapping(path = "/list")
    public List<Anime> list(){
       return List.of(new Anime("Naruto"), new Anime("Damon Slayer"));
    }

    
}