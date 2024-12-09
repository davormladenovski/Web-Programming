package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Data
@Entity
public class Song {

    private String trackId;
    private String title;
    private String genre;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int releaseYear;
    @ManyToMany
    private List<Artist> performers=new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "album_id", nullable = false)
    private Album album;

    public Song(String trackId, String title, String genre, int releaseYear,Album album) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.album=album;
    }

    public Song() {

    }

    public void setAlbum(Album album) {
        this.album = album;
    }


}
