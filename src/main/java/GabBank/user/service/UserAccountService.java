package GabBank.user.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import GabBank.user.dto.CreateUserRequestDTO;
import GabBank.user.enums.StatusUser;
import GabBank.user.mapper.UserAccountMapper;
import GabBank.exception.custom.CpfAlreadyExistsException;
import GabBank.exception.custom.UserDoesNotExistException;
import GabBank.user.model.UserAccount;
import GabBank.user.repository.UserAccountRepository;

@Service
public class UserAccountService {

    private final UserAccountRepository userAccountRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserAccountMapper userAccountMapper;
    
    public UserAccountService(
        UserAccountRepository userAccountRepository, 
        PasswordEncoder passwordEncoder,
        UserAccountMapper userAccountMapper) {
        this.userAccountRepository = userAccountRepository;
        this.passwordEncoder       = passwordEncoder;
        this.userAccountMapper     = userAccountMapper;
    }

    // CREATE USER
    public UserAccount createUser(CreateUserRequestDTO request) {
        String encryptedPwd     = passwordEncoder.encode(request.getPassword()); 
        
        if (userAccountRepository.existsByCpf(request.getCpf())) {
            throw new CpfAlreadyExistsException();
        }
        
        UserAccount userAccount = userAccountMapper.requestToUser(request);
        userAccount.setPassword(encryptedPwd); 
        userAccount.setStatusUser(StatusUser.ACTIVE);

        return userAccountRepository.save(userAccount);
    }

    // FIND USER
    public UserAccount findUserById(Long id) {
        return userAccountRepository.findById(id)
        .orElseThrow(UserDoesNotExistException::new);
    }
    public List<UserAccount> findAll() {
        return userAccountRepository.findAll();
    }

    // REMOVE
    public UserAccount removeUserById(Long id) {
        UserAccount user = userAccountRepository.findById(id).orElseThrow(UserDoesNotExistException::new);
        userAccountRepository.deleteById(id);
        return user;
    }
}
