package GabBank.user.exception.custom;

public class UserDoesNotExistException extends RuntimeException {
    public UserDoesNotExistException() {
        super("User does not exists");
    }
}
