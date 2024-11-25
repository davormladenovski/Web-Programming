package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataHolder {

    public static List<Artist> Artists=new ArrayList<>();
    public static List<Song> Songs = new ArrayList<>();

    public static List<Album> Albums = new ArrayList<>();


    @PostConstruct
    public void init(){

        Artist freddie = new Artist(1L, "Freddie", "Mercury", "Lead vocalist of the rock band Queen.");
        Artist whitney = new Artist(2L, "Whitney", "Houston", "American singer and actress.");
        Artist michael = new Artist(3L, "Michael", "Jackson", "Known as the King of Pop.");
        Artist adele = new Artist(4L, "Adele", "", "English singer-songwriter.");
        Artist elton = new Artist(5L, "Elton", "John", "British singer, songwriter, and pianist.");

        Artists.addAll(Arrays.asList(freddie, whitney, michael, adele, elton));

        Album album1 = new Album("A Night at the Opera", "Rock", "1975");
        Album album2 = new Album("The Bodyguard", "Pop", "1992");
        Album album3 = new Album("Thriller", "Pop", "1982");
        Album album4 = new Album("21", "Pop", "2011");
        Album album5 = new Album("Goodbye Yellow Brick Road", "Rock", "1973");

        Albums.addAll(Arrays.asList(album1, album2, album3, album4, album5));

        Songs.add(new Song("1", "Bohemian Rhapsody", "Rock", 1975, album1));
        Songs.add(new Song("2", "I Will Always Love You", "Pop", 1992, album2));
        Songs.add(new Song("3", "Billie Jean", "Pop", 1983, album3));
        Songs.add(new Song("4", "Someone Like You", "Pop", 2011, album4));
        Songs.add(new Song("5", "Rocket Man", "Rock", 1972, album5));
        Songs.add(new Song("6", "Under Pressure", "Rock", 1981, album1));


    }

}
