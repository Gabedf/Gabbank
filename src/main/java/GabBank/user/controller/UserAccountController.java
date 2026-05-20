package GabBank.user.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import GabBank.user.dto.CreateUserRequestDTO;
import GabBank.user.dto.CreateUserResponseDTO;
import GabBank.user.mapper.UserAccountMapper;
import GabBank.user.model.UserAccount;
import GabBank.user.service.UserAccountService;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

@RequestMapping("/users")
@RestController
public class UserAccountController {
    private final UserAccountService userAccountService;
    private final UserAccountMapper userAccountMapper;
    public UserAccountController(UserAccountService userAccountService, UserAccountMapper userAccountMapper) {
        this.userAccountService = userAccountService;
        this.userAccountMapper  = userAccountMapper;
    }

    @PostMapping
    public CreateUserResponseDTO createUser(@Valid @RequestBody CreateUserRequestDTO request) {
        UserAccount user                      = userAccountService.createUser(request);
        return userAccountMapper.toResponseDTO(user);
    }
}
