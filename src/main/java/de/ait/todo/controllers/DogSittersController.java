package de.ait.todo.controllers;


import de.ait.todo.controllers.api.DogSittersApi;
import de.ait.todo.dto.DogSitterDto;
import de.ait.todo.models.DogSitter;
import de.ait.todo.services.DogSittersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class DogSittersController implements DogSittersApi {
    private final DogSittersService dogSittersService;

    @Override
    public List<DogSitterDto> getDogSitters() {
        return dogSittersService.getDogSitters();
    }

    @Override
    public List<DogSitterDto> getDogSittersByCityAndDogSize(String city, DogSitter.DogSize dogSize, String zip) {
        return dogSittersService.getDogSittersByCityAndDogSize(city, dogSize, zip);
    }

    @Override
    public DogSitterDto deleteDogSitter(Long id) {
        return dogSittersService.deleteDogSitter(id);
    }


}
