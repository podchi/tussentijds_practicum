package be.ucll.oefening_2_tussentijds_practicum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/films")
public class FilmController {
    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public List<Film> getAllFilms() {
        return filmService.getAllFilms();
    }

    @GetMapping("/{title}")
    public ResponseEntity<Film> getFilmByTitle(@PathVariable String title) {
        Optional<Film> film = filmService.getFilmByTitle(title);
        return film.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> addFilm(@RequestBody Film film) {
        filmService.addFilm(film);
        return ResponseEntity.status(HttpStatus.CREATED).body("Film Added: " + film.getMovie_title());
    }

    @PutMapping("/{title}")
    public ResponseEntity<String> updateFilm(@PathVariable String title, @RequestBody Film film) {
        if (filmService.updateFilm(title, film)) {
            return ResponseEntity.ok("Film updated: " + title);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{title}")
    public ResponseEntity<String> deleteFilm(@PathVariable String title) {
        if (filmService.deleteFilm(title)) {
            return ResponseEntity.ok("Film deleted: " + title);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


