package practice07;

public class Klass {

    public static final String CLASS = "Class ";
    private int number;

    public Klass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getDisplayName(){
        return CLASS + this.number;
    }
}
