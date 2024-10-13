package az.codebridge.task.rest;

import az.codebridge.task.dto.BalanceDto;
import az.codebridge.task.dto.UserRequestDto;
import az.codebridge.task.dto.UserResponseDto;
import az.codebridge.task.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto) {
        return userService.createUser(userRequestDto);
    }

    @PutMapping("/{id}")
    public UserResponseDto updateUser(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto){
        return userService.updateUser(id,userRequestDto);
    }

    @GetMapping("/{id}")
    public UserResponseDto getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @GetMapping("/username/{userName}")
    public UserResponseDto getUserByUserName(@PathVariable String userName){
        return userService.getUserByUserName(userName);
    }

    @GetMapping("/balance/{userName}")
    public BalanceDto getUserBalanceByUserName(@PathVariable String userName){
        return userService.getUserBalanceWithUserName(userName);
    }

    @GetMapping
    public List<UserResponseDto> getUsers(){
        return userService.getUsers();
    }
}

