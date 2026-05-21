package GabBank.user.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import GabBank.user.dto.CreateUserRequestDTO;
import GabBank.user.dto.UpdateRequestEmailDTO;
import GabBank.user.dto.UserResponseDTO;
import GabBank.user.mapper.UserAccountMapper;
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
    public UserResponseDTO createUser(@Valid @RequestBody CreateUserRequestDTO request) {
        return userAccountMapper.toResponseDTO(userAccountService.createUser(request));
    }

    // GET    
    @GetMapping("/view/{id}")
    public UserResponseDTO findyUserById(@PathVariable("id") Long id) {
        return userAccountMapper.toResponseDTO(userAccountService.findUserById(id));
    }

    @GetMapping("/view/all")
    public List<UserResponseDTO> findUsers() {
        return userAccountService.findAll()
        .stream()
        .map(userAccountMapper::toResponseDTO)
        .toList();
    }

    // REMOVE
    @DeleteMapping("remove/{id}")
    public UserResponseDTO removeUserById(@PathVariable("id") Long id) {
        return userAccountMapper.toResponseDTO(userAccountService.removeUserById(id));
    }
    
    // UPDATE
    @PutMapping("update/{id}/email")
    public UserResponseDTO updateEmail(@PathVariable("id") Long id, @Valid @RequestBody UpdateRequestEmailDTO request) {
        return userAccountMapper.toResponseDTO(userAccountService.updateUserEmail(id, request));
    }
}
