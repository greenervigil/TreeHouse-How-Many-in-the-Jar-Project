import java.util.Random;

public class Jar {

    private int mFilledJar;
    private String mItem;
    private int mNumber;
    
    public Jar(String item, int number) {
        mNumber = number;
        mItem = item;
    }
    
    public int getFilledJarTotal() {
        return mFilledJar;
    }
    
    public String getItem() {
        return mItem;
    }
    
    public int getMaxNumber() {
        return mNumber;
    }
    
    public void fill() {
        Random random = new Random();
        mFilledJar = random.nextInt(mNumber) + 1;
        System.out.println(mFilledJar);
    }
    

}