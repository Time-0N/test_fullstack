package com.example.backend;

import com.example.backend.model.dao.Game;
import com.example.backend.model.repository.GameRepository;
import com.example.backend.service.GameService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GameServiceTests {

    @Mock
    private GameRepository gameRepository;

    @InjectMocks
    private GameService gameService;

    @Test
    public void testGetGameBoard() {
        // Set up a game with a known game board string and a UID
        Game game = new Game();
        game.setUid("ABC123");
        game.setGameBoard("012345678"); // example game board string

        // Mock the repository to return this game
        when(gameRepository.findByUid("ABC123")).thenReturn(Optional.of(game));

        // Set up the expected board
        Integer[][] expectedBoard = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8} // Corrected to match the actual board
        };

        // Get the actual board from the service
        Integer[][] actualBoard = gameService.getGameBoard("ABC123");

        // Assert that the actual board matches the expected board
        assertArrayEquals(expectedBoard, actualBoard);
    }
}
