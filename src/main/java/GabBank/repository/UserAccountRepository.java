package GabBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import GabBank.model.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

}
