package GabBank.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import GabBank.user.model.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    // CPFs
    boolean existsByCpf(String cpf);
 
    // EMAILs
    boolean existsByEmail(String email);
}
