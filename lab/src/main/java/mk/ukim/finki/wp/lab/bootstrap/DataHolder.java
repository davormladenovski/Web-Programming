package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.jpa.AlbumRepository;
import mk.ukim.finki.wp.lab.repository.jpa.ArtistRepository;
import mk.ukim.finki.wp.lab.repository.jpa.SongRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Component
public class DataHolder {

    private final ArtistRepository artistRepository;
    private final AlbumRepository albumRepository;
    private final SongRepository songRepository;

    public DataHolder(ArtistRepository artistRepository, AlbumRepository albumRepository, SongRepository songRepository) {
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
        this.songRepository = songRepository;
    }

    @PostConstruct
    public void init() {
        Artist freddie = new Artist(null, "Freddie", "Mercury", "Lead vocalist of the rock band Queen.");
        Artist whitney = new Artist(null, "Whitney", "Houston", "American singer and actress.");
        Artist michael = new Artist(null, "Michael", "Jackson", "Known as the King of Pop.");
        Artist adele = new Artist(null, "Adele", "", "English singer-songwriter.");
        Artist elton = new Artist(null, "Elton", "John", "British singer, songwriter, and pianist.");

        artistRepository.saveAll(List.of(freddie, whitney, michael, adele, elton));

        Album album1 = new Album("A Night at the Opera", "Rock", "1975");
        Album album2 = new Album("The Bodyguard", "Pop", "1992");
        Album album3 = new Album("Thriller", "Pop", "1982");
        Album album4 = new Album("21", "Pop", "2011");
        Album album5 = new Album("Goodbye Yellow Brick Road", "Rock", "1973");

        albumRepository.saveAll(List.of(album1, album2, album3, album4, album5));

        Song song1 = new Song("1", "Bohemian Rhapsody", "Rock", 1975, album1);
        Song song2 = new Song("2", "I Will Always Love You", "Pop", 1992, album2);
        Song song3 = new Song("3", "Billie Jean", "Pop", 1983, album3);
        Song song4 = new Song("4", "Someone Like You", "Pop", 2011, album4);
        Song song5 = new Song("5", "Rocket Man", "Rock", 1972, album5);
        Song song6 = new Song("6", "Under Pressure", "Rock", 1981, album1);

        songRepository.saveAll(List.of(song1, song2, song3, song4, song5, song6));
    }
}
