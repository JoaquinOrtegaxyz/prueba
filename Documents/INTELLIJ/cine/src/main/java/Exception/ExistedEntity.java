package Exception;

public class ExistedEntity extends RuntimeException {
    public ExistedEntity(String message) {
        super(message);
    }
}
