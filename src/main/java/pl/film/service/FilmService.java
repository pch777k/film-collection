package pl.film.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.film.model.Film;
import pl.film.repository.FilmRepository;

@Service
public class FilmService {

	@Autowired
	private FilmRepository filmRepository;
	
	public List<Film> getAllFilms(){
		return filmRepository.findAll();
	}
	
	public Film getFilmById(Long id) {
		return filmRepository.findById(id).get();
	}
	
	public void addFilm(Film film) {
		filmRepository.save(film);
	}
	
	public void deleteFilm(Long id) {
		filmRepository.deleteById(id);
	}
}
