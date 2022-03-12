package academy.devdojo.springboot2essentials.repositories;

import academy.devdojo.springboot2essentials.domain.entities.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime, Long> {

}
