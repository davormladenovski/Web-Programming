package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true)
    private  String firstName;
    @Column(nullable = true)
    private String lastName;
    @Column(nullable = true)
    private String bio;
    @ManyToMany(mappedBy = "performers")
    private List<Song> songsList;

    public Artist(Long id, String firstName, String lastName, String bio) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.songsList=new ArrayList<>();
    }

    public Artist() {

    }

}
