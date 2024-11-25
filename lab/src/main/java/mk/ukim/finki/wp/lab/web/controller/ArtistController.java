package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.AlbumService;
import mk.ukim.finki.wp.lab.service.ArtistService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/artists")
public class ArtistController {

    public final SongService songService;
    public final AlbumService albumService;
    public final ArtistService artistService;

    public ArtistController(SongService songService, AlbumService albumService, ArtistService artistService) {
        this.songService = songService;
        this.albumService = albumService;
        this.artistService = artistService;
    }

    @PostMapping()
    public String getArtistsPage(@RequestParam("Id") Long songId) {
        return "redirect:/artists/" + songId;
    }

    @GetMapping("/{songId}")
    public String getArtistsPage(@PathVariable Long songId, Model model) {
        Song song = songService.findById(songId);
        model.addAttribute("artists", artistService.listArtists());
        model.addAttribute("song", song);
        return "artistsList";
    }

    @PostMapping("/add")
    public String addArtistToSong(@RequestParam("songId") Long songId,
                                  @RequestParam("artistId") Long artistId) {

        Song song = songService.findById(songId);
        Artist artist = artistService.findById(artistId).orElse(null);

        songService.addArtistToSong(artist,song);

        return "redirect:/songs/details/" + songId;
    }


}
