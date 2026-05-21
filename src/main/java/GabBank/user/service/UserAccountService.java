package GabBank.user.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import GabBank.user.dto.CreateUserRequestDTO;
import GabBank.user.enums.UserStatus;
import GabBank.user.mapper.UserAccountMapper;
import GabBank.exception.custom.CpfAlreadyExistsException;
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
        userAccount.setUserStatus(UserStatus.ACTIVE);

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
}
