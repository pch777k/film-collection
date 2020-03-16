package pl.film.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.film.model.Film;
import pl.film.service.FilmService;



@Controller
public class FilmController {
	
	@Autowired
	private FilmService filmService;

	@RequestMapping({"/","/index"})
	public String viewHomePage(Model model) {
		List<Film> films = filmService.getAllFilms();
		model.addAttribute("films", films);
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewFilmForm(Model model) {
		Film film = new Film();
		model.addAttribute("film", film);	
		return "new_film";		
	}
	
	@RequestMapping(value="/save",  method = RequestMethod.POST)
	public String saveFilm(@ModelAttribute("film") Film film) {
		filmService.addFilm(film);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditFilmForm(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("edit_film");	
		Film film = filmService.getFilmById(id);
		mav.addObject("film", film);
		return mav;		
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteFilm(@PathVariable Long id) {
		filmService.deleteFilm(id);
		return "redirect:/";
	}
}
