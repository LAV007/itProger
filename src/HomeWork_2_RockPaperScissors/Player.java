package HomeWork_2_RockPaperScissors;

public class Player {

    private String name = "Bot";
    private VARIANTS choice;


    public Player(VARIANTS choice, String name) {
        this.choice = choice;
        this.name = name;
    }


    public Player() {
        double randomDouble = Math.random();
        randomDouble = randomDouble * 3 + 1;
        int randomInt = (int) randomDouble;
        switch(randomInt) {
            case 1: choice = VARIANTS.ROCK; break;
            case 2: choice = VARIANTS.PAPER; break;
            case 3: choice = VARIANTS.SCISSORS; break;
        }

    }

    public static String whoWins(Player firstPlayer, Player secondPlayer) {
        if (firstPlayer.choice == secondPlayer.choice)
            return "Ничья";
        else if ((firstPlayer.choice == VARIANTS.ROCK && secondPlayer.choice == VARIANTS.PAPER)
                || (firstPlayer.choice == VARIANTS.PAPER && secondPlayer.choice == VARIANTS.SCISSORS)
                || (firstPlayer.choice == VARIANTS.SCISSORS && secondPlayer.choice == VARIANTS.ROCK))
            return "Победил игрок с именем: " + firstPlayer.name;
        else
            return "Победил игрок с именем: " + secondPlayer.name;

    }

}
