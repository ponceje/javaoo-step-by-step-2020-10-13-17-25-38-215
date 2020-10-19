package practice07;

public class Person {
    public static final String MY_NAME_IS = "My name is ";
    public static final String I_AM = ". I am ";
    public static final String YEARS_OLD = " years old.";
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String introduce(){
        return new StringBuilder().append(MY_NAME_IS).append(this.name).append(I_AM).append(this.getAge()).append(YEARS_OLD).toString();
    }

}