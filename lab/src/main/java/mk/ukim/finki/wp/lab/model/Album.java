package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Data
@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String genre;
    private String releaseYear;
    @OneToMany(mappedBy = "album")
    private List<Song> songs;

    public Album(String name, String genre, String releaseYear) {
        this.name = name;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }

    public Album() {

    }

}

