package pl.film.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.film.model.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long>{

}
