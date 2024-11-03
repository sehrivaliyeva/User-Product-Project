package az.codebridge.task.service;


import az.codebridge.task.dto.UserRequestDto;
import az.codebridge.task.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(UserRequestDto userRequestDto);

    UserResponseDto updateUser(Long id, UserRequestDto userRequestDto);

    UserResponseDto getUser(Long id);

    void deleteUser(Long id);

    UserResponseDto getUserByUserName(String userName);

    List<UserResponseDto> getUsers();

    UserResponseDto getUserBalanceWithUserName(String userName);
}
