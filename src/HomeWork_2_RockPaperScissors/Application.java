package HomeWork_2_RockPaperScissors;

public class Application {
    public static void main(String[] args) {
        // Создаем объекты
        Player bot = new Player();
        Player alex = new Player(VARIANTS.SCISSORS, "Alex");

        // Получаем результат
        System.out.println(Player.whoWins(bot, alex));
    }
}
