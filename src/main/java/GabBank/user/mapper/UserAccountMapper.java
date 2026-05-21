package GabBank.user.mapper;

import org.mapstruct.Mapper;

import GabBank.user.dto.CreateUserRequestDTO;
import GabBank.user.dto.UserResponseDTO;
import GabBank.user.model.UserAccount;

@Mapper(componentModel = "spring")
public interface UserAccountMapper {

    UserResponseDTO toResponseDTO(UserAccount userAccount);
    UserAccount requestToUser(CreateUserRequestDTO userRequestDTO);
}
