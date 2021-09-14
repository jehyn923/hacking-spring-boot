package net.frank.api.hackingspringbootch1reactive.controller;

import lombok.RequiredArgsConstructor;
import net.frank.api.hackingspringbootch1reactive.domain.Dish;
import net.frank.api.hackingspringbootch1reactive.service.KitchenService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class ServerController {
    private final KitchenService kitchen;

    @GetMapping(value = "/server", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Dish> serveDishes(){
        return this.kitchen.getDishes();
    }

    @GetMapping(value = "/served-dishes", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Dish> deliverDishes(){
        return this.kitchen.getDishes()
                .map(dish->Dish.deliver(dish));
    }
}
