package GabBank.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserResponseDTO {
    private Long id;
    private String cpf;
    private String email;
}
