import java.io.*;

public class Game {
    public static void main(String[] args) {

        
        try {
            Prompter prompter = new Prompter();
            Jar jar = new Jar(prompter.promptForItem(), prompter.promptForNumber());
            jar.fill();
            prompter.promptForGuess(jar);
        }
        catch (IOException ioe) {
            ioe.printStackTrace();   
        }
    }
}
