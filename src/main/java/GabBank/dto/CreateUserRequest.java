package GabBank.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {
    private String cpf;
    private String email;
    private String password;
}
