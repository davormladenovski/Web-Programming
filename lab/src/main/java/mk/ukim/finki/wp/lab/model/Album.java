package mk.ukim.finki.wp.lab.model;

import lombok.Data;

import java.util.Random;
import java.util.UUID;

@Data
public class Album {

    private Long id;
    private String name;
    private String genre;
    private String releaseYear;

    public Album(String name, String genre, String releaseYear) {
        this.id = new Random().nextLong();
        this.name = name;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }
}

