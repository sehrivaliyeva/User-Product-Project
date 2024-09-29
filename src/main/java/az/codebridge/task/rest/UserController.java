package az.codebridge.task.rest;

import az.codebridge.task.dto.UserRequestDto;
import az.codebridge.task.dto.UserResponseDto;
import az.codebridge.task.service.UserService;
import az.codebridge.task.service.UserServiceImpl;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto) {
        return userService.createUser(userRequestDto);
    }
}
