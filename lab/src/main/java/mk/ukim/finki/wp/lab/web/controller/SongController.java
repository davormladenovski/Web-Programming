package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.model.exceptions.SameSongsIDException;
import mk.ukim.finki.wp.lab.service.AlbumService;
import mk.ukim.finki.wp.lab.service.ArtistService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/songs")
public class SongController {

    public final SongService songService;
    public final AlbumService albumService;
    public final ArtistService artistService;

    public SongController(SongService songService, AlbumService albumService, ArtistService artistService) {
        this.songService = songService;
        this.albumService = albumService;
        this.artistService = artistService;
    }

    @GetMapping
    public String getSongsPage(@RequestParam(required = false) String error, Model model){
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        model.addAttribute("songs",songService.listSongs());
        return "listSongs";
    }

    @GetMapping("/add")
    public String getAddSongPage(@RequestParam(required = false) String error,Model model){
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        model.addAttribute("type","add");
        model.addAttribute("albums",this.albumService.findAll());
        model.addAttribute("actionUrl","/songs/add");
        return "add-edit-song";
    }

    @PostMapping("/add")
    public String saveSong(@RequestParam String title,@RequestParam String trackId,@RequestParam String genre
         ,@RequestParam int releaseYear,@RequestParam long albumId){

        Album album = albumService.findById(albumId);
        try {
            songService.addSong(new Song(trackId,title,genre,releaseYear,album));
        } catch (SameSongsIDException e) {
            return "redirect:/songs/add?error="+e.getMessage();
        }

        return "redirect:/songs";
    }

    @GetMapping("/edit/{songId}")
    public String getEditSongPage(@PathVariable long songId,Model model){
        Song song = songService.findById(songId);
        model.addAttribute("song",song);
        model.addAttribute("actionUrl","/songs/edit/"+songId);
        model.addAttribute("albums",albumService.findAll());
        return "add-edit-song";

    }
    @PostMapping("/edit/{songId}")
    public String editSong(@PathVariable long songId,Song updatedSong,@RequestParam long albumId,Model model){
        try {
            Album album = albumService.findById(albumId);
            updatedSong.setAlbum(album);
            songService.editSong(songId, updatedSong);
            return "redirect:/songs";
        } catch (SameSongsIDException e) {
            return "redirect:/songs/edit/{songId}?error="+e.getMessage();
        }

    }

    @GetMapping("/delete/{id}")
    public String deleteSong(@PathVariable Long id){
        System.out.println(id);
        songService.deleteById(id);
        return "redirect:/songs";
    }

    @GetMapping("/details/{songId}")
    public String detailsSongPage(@PathVariable long songId,Model model){
        Song song = songService.findById(songId);
        model.addAttribute("song",song);
        return "songDetails";
    }




}
