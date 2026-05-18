package GabBank.model;

import GabBank.enums.StatusUser;
import GabBank.enums.UserRole;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor 
@NoArgsConstructor
public class UserAccount {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    private String cpf;
    private String password;
    private String email;

    @OneToOne
    private Wallet wallet;

    @Enumerated(EnumType.STRING)
    private StatusUser statusUser;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;
}