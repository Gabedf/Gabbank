package GabBank.user.mapper;

import org.mapstruct.Mapper;

import GabBank.user.dto.CreateUserRequestDTO;
import GabBank.user.dto.CreateUserResponseDTO;
import GabBank.user.model.UserAccount;

@Mapper(componentModel = "spring")
public interface UserAccountMapper {

    CreateUserResponseDTO toResponseDTO(UserAccount userAccount);
    UserAccount requestToUser(CreateUserRequestDTO userRequestDTO);
}
