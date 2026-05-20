package GabBank.exception.custom;

public class CpfAlreadyExistsException extends RuntimeException {

    public CpfAlreadyExistsException() {
        super("CPF already exists");
    }
}