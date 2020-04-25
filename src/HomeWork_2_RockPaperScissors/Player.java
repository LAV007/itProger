package HomeWork_2_RockPaperScissors;

import java.util.Random;

public class Player {
    private VARIANTS variants;
    private String name;

    public Player(){
        variants = VARIANTS.values()[new Random().nextInt(VARIANTS.values().length)];
        name = "Bot";
    }

    public Player(VARIANTS variants, String name){
        this.variants = variants;
        this.name = name;
    }

    static public String whoWins(Player playerOne, Player playerTwo){
        String whoWins = "";
        if (playerOne.variants.equals(playerTwo.variants)) whoWins = "ничья";
        else if (playerOne.variants == VARIANTS.SCISSORS && playerTwo.variants == VARIANTS.ROCK)
            whoWins = playerTwo.name;
        else if (playerOne.variants == VARIANTS.PAPER && playerTwo.variants == VARIANTS.ROCK)
            whoWins = playerTwo.name;
        else if (playerOne.variants == VARIANTS.PAPER && playerTwo.variants == VARIANTS.SCISSORS)
            whoWins = playerTwo.name;
        else if (playerOne.variants == VARIANTS.ROCK && playerTwo.variants == VARIANTS.SCISSORS)
            whoWins = playerOne.name;
        else if (playerOne.variants == VARIANTS.SCISSORS && playerOne.variants == VARIANTS.PAPER)
            whoWins = playerOne.name;
        else if (playerOne.variants == VARIANTS.ROCK && playerTwo.variants == VARIANTS.PAPER)
            whoWins = playerOne.name;
        return "Победил игрок с именем: " + whoWins;
    }
}
