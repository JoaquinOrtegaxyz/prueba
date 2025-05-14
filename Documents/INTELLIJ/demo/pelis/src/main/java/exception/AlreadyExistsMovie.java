package exception;

public class AlreadyExistsMovie extends RuntimeException {
    public AlreadyExistsMovie(String message) {
        super(message);
    }
}
