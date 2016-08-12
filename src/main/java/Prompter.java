import java.io.*;

public class Prompter {
 
    private int mCount = 0;
    private int mNumber;
    private String mItem;
    private BufferedReader mReader;
    
    public Prompter() {
        mReader = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public void evaluateGuess(Jar jar, int guess, int filled) throws IOException{
        
        if (guess > jar.getMaxNumber()) {
            System.out.println("Your guess must be less than " + jar.getMaxNumber());
            guess = Integer.parseInt(mReader.readLine());
        }
        while (guess != filled) {
            if (guess < filled) {
                mCount++;
                System.out.println("Your guess is too low.  Please try again:  ");
                guess = Integer.parseInt(mReader.readLine());
            } else if(guess > filled){
                mCount++;
                System.out.println("Your guess is too high.  Try Again:  ");
                guess = Integer.parseInt(mReader.readLine());
            }
        }
        mCount++;
        System.out.println("You guessed the correct number of " + jar.getItem() + 
                               ".  You got it in "+ mCount + " attempt(s). ");
    }
    
    public void promptForGuess(Jar jar) throws IOException {
        
        int num =0;
        while (num == 0) {
            System.out.print("Guess how many " + mItem + " are in the jar?   Enter numbers only please.   =8P  Pick a number from 1 to " 
                             + jar.getMaxNumber() + "    ");
//            if (mReader.readLine() == "" || mReader.readLine() == null) {
//                System.out.println("That is not a correct response.  Please try again.  ");
//            }
            num = Integer.parseInt(mReader.readLine());
        }
        evaluateGuess(jar, num, jar.getFilledJarTotal());
    }
    
    public String promptForItem() throws IOException{
      
        System.out.println("*************************");
        System.out.println("****  Administrator  ****");
        System.out.println("*************************");
        System.out.println("\n");
        System.out.println("What is in this jar?  ");
        
        mItem = mReader.readLine();
        System.out.print("\033[H\033[2J");
        return mItem;
        
    }
    
    public int promptForNumber() throws IOException{
        System.out.println("What is the maximum number of " + mItem + "s for this jar?  ");
        mNumber = Integer.parseInt(mReader.readLine());
        return mNumber;
    }
}