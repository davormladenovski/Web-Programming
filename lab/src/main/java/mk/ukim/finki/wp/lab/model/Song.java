package mk.ukim.finki.wp.lab.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Data
public class Song {

    private String trackId;
    private String title;
    private String genre;
    private Long id;

    private int releaseYear;

    private List<Artist> performers;

    private Album album;

    public Song(String trackId, String title, String genre, int releaseYear,Album album) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = new ArrayList<>();
        this.id = new Random().nextLong();
        this.album=album;
    }

}
