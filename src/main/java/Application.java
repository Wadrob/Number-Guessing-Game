import cli.NumberGuessingGameCLI;

public class Application {

    public static void main(String[] args) {
        new Application().start();
    }

    public void start(){
        NumberGuessingGameCLI nGG = new NumberGuessingGameCLI();
        nGG.run();
    }
}