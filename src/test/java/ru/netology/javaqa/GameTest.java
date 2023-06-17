package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void testWhenFirstPlayerStronger() {
        Game game = new Game();
        Player player1 = new Player(1, "John", 100);
        Player player2 = new Player(2, "Alex", 80);


        game.register(player1);
        game.register(player2);
        int actual = game.round("John", "Alex");
        int expected = 1;

        Assertions.assertEquals(expected,actual);

    }
    @Test
    public void testWhenSecondPlayerStronger() {
        Game game = new Game();
        Player player1 = new Player(1, "John", 60);
        Player player2 = new Player(2, "Alex", 80);


        game.register(player1);
        game.register(player2);
        int actual = game.round("Alex", "John");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testWhenPlayersEqual() {
        Game game = new Game();
        Player player1 = new Player(1, "John", 80);
        Player player2 = new Player(2, "Alex", 80);


        game.register(player1);
        game.register(player2);
        int actual = game.round("Alex", "John");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testWhenOnePlayerNotRegistered() {
        Game game = new Game();
        Player player1 = new Player(1, "John", 80);
        Player player2 = new Player(2, "Alex", 90);


        game.register(player1);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class,
                ()-> game.round("John","Fil")
                );
    }

}