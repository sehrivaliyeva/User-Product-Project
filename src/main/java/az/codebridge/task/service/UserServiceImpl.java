package az.codebridge.task.service;

import az.codebridge.task.dto.UserRequestDto;
import az.codebridge.task.dto.UserResponseDto;
import az.codebridge.task.entity.UserEntity;
import az.codebridge.task.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        UserEntity userEntity = UserEntity.builder()
                .userName(userRequestDto.getUserName())
                .name(userRequestDto.getName())
                .surname(userRequestDto.getSurname())
                .age(userRequestDto.getAge())
                .balance(userRequestDto.getBalance())
                .isActive(userRequestDto.getIsActive())
                .build();
        UserEntity save = userRepository.save(userEntity);
        return UserResponseDto.builder()
                .id(save.getId())
                .userName(save.getUserName())
                .name(save.getName())
                .surname(save.getSurname())
                .age(save.getAge())
                .balance(save.getBalance())
                .isActive(save.getIsActive())
                .build();
    }
}
