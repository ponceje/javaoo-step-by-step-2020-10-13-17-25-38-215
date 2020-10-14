package practice08;

public class Person {
    private String name;
    private int age;
    private int id;

    public Person(int id, String name, int age) {
        this.name = name;
        this.age = age;
        this.id = id;
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
