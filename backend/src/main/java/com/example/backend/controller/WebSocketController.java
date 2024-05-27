package com.example.backend.controller;

import com.example.backend.model.dto.GameResponse;
import com.example.backend.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class WebSocketController {

    private final GameService gameService;

    @MessageMapping("/game/{id}")
    @SendTo("/topic/game/{id}")
    public GameResponse game(@DestinationVariable("id") Long id) {
        return new GameResponse(gameService.findById(id));
    }
}
