package practice07;

public class Person {
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
        return new StringBuilder().append("My name is ").append(this.name).append(". I am ").append(this.getAge()).append(" years old.").toString();
    }

}