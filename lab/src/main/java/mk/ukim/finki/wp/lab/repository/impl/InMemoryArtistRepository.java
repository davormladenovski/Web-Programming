package mk.ukim.finki.wp.lab.repository.impl;


import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/*
public class InMemoryArtistRepository {

    public List<Artist> findAll(){

        return DataHolder.Artists;

    }

    public Optional<Artist> findById(Long id){

        return DataHolder.Artists.stream().filter(artist -> artist.getId().equals(id)).findFirst();

    }

    public Song addSong(Artist artist, Song song){
      artist.getSongsList().add(song);
      return song;
    }
}
*/