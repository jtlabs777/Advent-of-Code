

class GameValidatorTest {

    public static void main(String[] args) {

        GameValidator gameValidator = new GameValidator();
        boolean result;

        result = gameValidator.isPossible("12 red, 12 green, 12 blue");

        System.out.println("This is: " + result);
    }

}