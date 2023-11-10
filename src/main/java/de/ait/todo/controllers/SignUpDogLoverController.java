package de.ait.todo.controllers;

import de.ait.todo.controllers.api.SignUpDogLover;
import de.ait.todo.dto.NewDogLoverDto;
import de.ait.todo.dto.DogLoverDto;
import de.ait.todo.services.SignUpDogLoverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

/**
 * 6/12/2023
 * spring-security-demo
 *
 * @author Marsel Sidikov (AIT TR)
 */
@RequiredArgsConstructor
@RestController
@CrossOrigin
public class SignUpDogLoverController implements SignUpDogLover {

    private final SignUpDogLoverService signUpDogLoverService;

    @Override
    public ResponseEntity<DogLoverDto> signUp(NewDogLoverDto newUser) {
        signUpDogLoverService.signUpp(newUser);
        return ResponseEntity
                .status(201)
                .body(signUpDogLoverService.signUp(newUser));
    }
}
