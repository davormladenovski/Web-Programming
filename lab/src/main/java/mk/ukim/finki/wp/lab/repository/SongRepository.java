package mk.ukim.finki.wp.lab.repository;


import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.model.exceptions.SameSongsIDException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SongRepository {

    public List<Song> findAll(){
        return DataHolder.Songs;
    }

    public Song findById(long Id){

        for (Song song : DataHolder.Songs) {
            if (song.getId().equals(Id)) {
                return song;
            }
        }
        return null;

    }
    public Song findByTrackId(String trackId) {
        for (Song song : DataHolder.Songs) {
            if (song.getTrackId().equals(trackId)) {
                return song;
            }
        }
        return null;
    }

    public Artist addArtistToSong(Artist artist, Song song){

        song.getPerformers().add(artist);
        return artist;

    }

    public Song deleteById(long Id){
        DataHolder.Songs.removeIf(song -> song.getId().equals(Id));
        return null;

    }

    public Song deleteByTrackId(String trackId) {
        DataHolder.Songs.removeIf(song -> song.getTrackId().equals(trackId));
        return null;
    }

    public Song addSong(Song song) throws SameSongsIDException {
        for(Song s : DataHolder.Songs){
            if(s.getAlbum().equals(song.getAlbum())) {
                if (s.getTrackId().equals(song.getTrackId())) {
                    throw new SameSongsIDException();
                }
            }
        }
        DataHolder.Songs.add(song);
        return song;

    }

    public Song editSong(long id, Song updatedSong) throws SameSongsIDException {
        Song existingSong = findById(id);
        if (existingSong == null) {
            return null;
        }

        existingSong.setTitle(updatedSong.getTitle());
        existingSong.setTrackId(updatedSong.getTrackId());
        existingSong.setGenre(updatedSong.getGenre());
        existingSong.setReleaseYear(updatedSong.getReleaseYear());
        existingSong.setAlbum(updatedSong.getAlbum());

        return existingSong;
    }




}

