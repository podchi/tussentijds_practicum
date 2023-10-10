package be.ucll.oefening_2_tussentijds_practicum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
@Entity
@Table(name = "FILM")
public class Film {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column
    private String movie_title;
    @Column
    private int release_year;
    @Column
    private int personal_score;
    @Column
    private String personal_review;

    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public int getPersonal_score() {
        return personal_score;
    }

    public void setPersonal_score(int personal_score) {
        this.personal_score = personal_score;
    }

    public String getPersonal_review() {
        return personal_review;
    }

    public void setPersonal_review(String personal_review) {
        this.personal_review = personal_review;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

