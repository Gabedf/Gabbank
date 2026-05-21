package GabBank.user.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import GabBank.user.dto.CreateUserRequestDTO;
import GabBank.user.dto.UpdateRequestEmailDTO;
import GabBank.user.enums.StatusUser;
import GabBank.user.exception.custom.CpfAlreadyExistsException;
import GabBank.user.exception.custom.EmailAlreadyExistsException;
import GabBank.user.exception.custom.InvalidPasswordException;
import GabBank.user.exception.custom.UserDoesNotExistException;
import GabBank.user.mapper.UserAccountMapper;
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
        String encryptedPwd     = passwordEncoder.encode(request.password()); 
        
        if (userAccountRepository.existsByCpf(request.cpf())) {
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

    // UPDATE
    public UserAccount updateUserEmail(Long id, UpdateRequestEmailDTO request) {
        UserAccount user    = userAccountRepository.findById(id).orElseThrow(UserDoesNotExistException::new);
        Boolean emailVerify = userAccountRepository.existsByEmail(request.email());
        
        if (emailVerify) {
            throw new EmailAlreadyExistsException();
        }
        user.setEmail(request.email());
        return userAccountRepository.save(user);
    }

    public UserAccount updateUserPwd(Long id, String currentPwd, String newPwd) {
        UserAccount user  = userAccountRepository.findById(id).orElseThrow(UserDoesNotExistException::new);
        Boolean pwdVerify = passwordEncoder.matches(currentPwd, newPwd);
        if (!pwdVerify) {
            throw new InvalidPasswordException();
        }

        String encodedPwd = passwordEncoder.encode(newPwd);
        user.setPassword(encodedPwd);
        return userAccountRepository.save(user);
    }
}
