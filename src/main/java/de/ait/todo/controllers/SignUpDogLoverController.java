package de.ait.todo.controllers;

import de.ait.todo.controllers.api.SignUpDogLover;
import de.ait.todo.dto.DogSitterDto;
import de.ait.todo.dto.DogSitterToDogLoverDto;
import de.ait.todo.dto.NewDogLoverDto;
import de.ait.todo.dto.DogLoverDto;
import de.ait.todo.services.SignUpDogLoverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 6/12/2023
 * spring-security-demo
 *
 * @author Marsel Sidikov (AIT TR)
 */
@RequiredArgsConstructor
@RestController
public class SignUpDogLoverController implements SignUpDogLover {

    private final SignUpDogLoverService signUpDogLoverService;

    @Override
    public ResponseEntity<DogLoverDto> registerDogLover(NewDogLoverDto newUser) {

        return ResponseEntity
                .status(201)
                .body(signUpDogLoverService.registerDogLover(newUser));
    }

    @Override
    public ResponseEntity<List<DogSitterDto>> addDogSitterToDogLover(@PathVariable("dogLover-id") Long dogLoverId,
                                                                     @RequestBody DogSitterToDogLoverDto gogSitterData) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(signUpDogLoverService.addDogSitterToDogLover(dogLoverId, gogSitterData));
    }
    @Override
    public List<DogSitterDto> addDogSittersToDogLover(@PathVariable("loveId") Long dogLoverId, @PathVariable("sitId") Long gogSitterId) {


        return signUpDogLoverService.addDogSittersToDogLover(dogLoverId, gogSitterId);

//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(signUpDogLoverService.addDogSittersToDogLover(dogLoverId, gogSitterId));
    }

    @Override
    public ResponseEntity<List<DogSitterDto>> getDogSittersOfDogLover(@PathVariable("dogLover-id") Long dogLoverId) {
        return ResponseEntity.ok(signUpDogLoverService.getDogSittersOfDogLover(dogLoverId));
    }
}
