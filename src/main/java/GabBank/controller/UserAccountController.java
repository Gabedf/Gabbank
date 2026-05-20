package GabBank.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import GabBank.dto.CreateUserRequestDTO;
import GabBank.dto.CreateUserResponseDTO;
import GabBank.model.UserAccount;
import GabBank.service.UserAccountService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RequestMapping("/users")
@RestController
public class UserAccountController {
    private final UserAccountService userAccountService;
    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @PostMapping
    public CreateUserResponseDTO createUser(@RequestBody CreateUserRequestDTO request) {
        UserAccount user                      = userAccountService.createUser(request);

        CreateUserResponseDTO userResponseDTO = new CreateUserResponseDTO();
        userResponseDTO.setCpf(user.getCpf());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setId(user.getId());

        return userResponseDTO;
    }
}
