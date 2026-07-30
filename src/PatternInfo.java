package src;

public class PatternInfo {
    private final int number;
    private final String name;
    private final String imagePath;
    private final PatternFunction generator;

    public PatternInfo(int number,
                       String name,
                       String imagePath,
                       PatternFunction generator) {
        this.number = number;
        this.name = name;
        this.imagePath = imagePath;
        this.generator = generator;
    }
    public  int getNumber(){
        return number;
    }
    public String getName(){
        return name;
    }
    public String getImagePath(){
        return imagePath;
    }
    public PatternFunction getGenerator(){
        return generator;
    }
}
