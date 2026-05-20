package GabBank.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import GabBank.dto.CreateUserRequestDTO;
import GabBank.exception.custom.CpfAlreadyExistsException;
import GabBank.model.UserAccount;
import GabBank.repository.UserAccountRepository;

@Service
public class UserAccountService {

    private final UserAccountRepository userAccountRepository;
    private final PasswordEncoder passwordEncoder;

    public UserAccountService(UserAccountRepository userAccountRepository, PasswordEncoder passwordEncoder) {
        this.userAccountRepository = userAccountRepository;
        this.passwordEncoder       = passwordEncoder;
    }

    // CREATE USER
    public UserAccount createUser(CreateUserRequestDTO request) {
        UserAccount userAccount = new UserAccount();
        String encryptedPwd     = passwordEncoder.encode(request.getPassword()); 
        
        if (userAccountRepository.existsByCpf(request.getCpf())) {
            throw new CpfAlreadyExistsException();
        }

        userAccount.setCpf(request.getCpf());
        userAccount.setEmail(request.getEmail());
        userAccount.setPassword(encryptedPwd); 

        return userAccountRepository.save(userAccount);
    }
}
