package az.codebridge.task.controller;

import az.codebridge.task.dto.UserRequestDto;
import az.codebridge.task.dto.UserResponseDto;
import az.codebridge.task.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserRequestDto userRequestDto) {
        UserResponseDto user = userService.createUser(userRequestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto){
        UserResponseDto userResponseDto = userService.updateUser(id, userRequestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable Long id){
        UserResponseDto user = userService.getUser(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @GetMapping("/username/{userName}")
    public ResponseEntity<UserResponseDto> getUserByUserName(@PathVariable String userName){
        UserResponseDto userByUserName = userService.getUserByUserName(userName);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userByUserName);
    }

    @GetMapping("/balance/{userName}")
    public ResponseEntity<UserResponseDto> getUserBalanceByUserName(@PathVariable String userName){
        UserResponseDto userBalanceWithUserName = userService.getUserBalanceWithUserName(userName);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userBalanceWithUserName);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getUsers(){
        List<UserResponseDto> users = userService.getUsers();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(users);
    }
}

