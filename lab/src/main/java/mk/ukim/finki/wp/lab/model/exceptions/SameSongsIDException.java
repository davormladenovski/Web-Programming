package mk.ukim.finki.wp.lab.model.exceptions;

public class SameSongsIDException extends Exception{
    public SameSongsIDException() {
        super("Already exists song with this ID!");
    }
}
