package kz.singularity.sendingemail.controller;

import jakarta.validation.Valid;
import kz.singularity.sendingemail.constants.UserConstants;
import kz.singularity.sendingemail.payload.RequestDto;
import kz.singularity.sendingemail.payload.ResponseDto;
import kz.singularity.sendingemail.payload.UserDetailsDto;
import kz.singularity.sendingemail.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> registerUser(@RequestBody @Valid RequestDto requestDto){
        userService.registerUser(requestDto);
        return new ResponseEntity<>(ResponseDto.builder()
                .statusCode(HttpStatus.CREATED.toString())
                .statusMsg(UserConstants.REGISTRATION_SUCCESS)
                .build(), HttpStatus.OK);
    }

    @GetMapping("/getbyemail/{email}")
    public ResponseEntity<UserDetailsDto> getUserByEmail(@PathVariable String email){
        return new ResponseEntity<>(userService.getUserByEmail(email),HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<UserDetailsDto>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateUser(@Valid RequestDto requestDto){
        boolean isUpdated = userService.updateUser(requestDto);
        if (!isUpdated)
            return new ResponseEntity<>(ResponseDto.builder()
                    .statusCode(HttpStatus.EXPECTATION_FAILED.toString())
                    .statusMsg(UserConstants.UPDATE_FAILED)
                    .build(),HttpStatus.EXPECTATION_FAILED);
        return new ResponseEntity<>(ResponseDto.builder()
                .statusMsg(UserConstants.UPDATE_SUCCESS)
                .statusCode(HttpStatus.OK.toString())
                .build(),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{email}")
    public ResponseEntity<ResponseDto> deleteUser(@PathVariable("email") String email){
        boolean isDeleted = userService.deleteUser(email);
        if (!isDeleted)
            return new ResponseEntity<>(ResponseDto.builder()
                    .statusCode(HttpStatus.EXPECTATION_FAILED.toString())
                    .statusMsg(UserConstants.DELETION_FAILED)
                    .build(),HttpStatus.EXPECTATION_FAILED);
        return new ResponseEntity<>(ResponseDto.builder()
                .statusMsg(UserConstants.DELETION_SUCCESS)
                .statusCode(HttpStatus.OK.toString())
                .build(),HttpStatus.OK);
    }
}
