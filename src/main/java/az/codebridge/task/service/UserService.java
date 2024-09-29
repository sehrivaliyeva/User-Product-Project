package az.codebridge.task.service;


import az.codebridge.task.dto.UserRequestDto;
import az.codebridge.task.dto.UserResponseDto;

public interface UserService {
    UserResponseDto createUser(UserRequestDto userRequestDto);
}
