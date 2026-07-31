package components;

public class PatternInfo {
    private final int number;
    private final String name;
    private final String imagePath;
    private final components.PatternFunction generator;
    private final String sourceCode;

    public PatternInfo(int number,
                       String name,
                       String imagePath,
                       components.PatternFunction generator,
                       String sourceCode) {
        this.number = number;
        this.name = name;
        this.imagePath = imagePath;
        this.generator = generator;
        this.sourceCode = sourceCode;
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
    public components.PatternFunction getGenerator(){
        return generator;
    }
    public String getSourceCode() {
        return sourceCode;
    }
}
