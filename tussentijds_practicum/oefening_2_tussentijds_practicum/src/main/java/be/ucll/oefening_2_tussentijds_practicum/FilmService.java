package be.ucll.oefening_2_tussentijds_practicum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {
    private final FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<Film> getAllFilms() {
        return (List<Film>) filmRepository.findAll();
    }

    public Optional<Film> getFilmByTitle(String title) {
        return filmRepository.findById(title);
    }

    public void addFilm(Film film) {
        filmRepository.save(film);
    }

    public boolean updateFilm(String title, Film updatedFilm) {
        Optional<Film> existingFilmOptional = filmRepository.findById(title);
        if (existingFilmOptional.isPresent()) {
            Film existingFilm = existingFilmOptional.get();
            existingFilm.setRelease_year(updatedFilm.getRelease_year());
            existingFilm.setPersonal_score(updatedFilm.getPersonal_score());
            existingFilm.setPersonal_review(updatedFilm.getPersonal_review());
            filmRepository.save(existingFilm);
            return true;
        }
        return false;
    }

    public boolean deleteFilm(String title) {
        Optional<Film> filmOptional = filmRepository.findById(title);
        if (filmOptional.isPresent()) {
            filmRepository.deleteById(title);
            return true;
        }
        return false;
    }
}

