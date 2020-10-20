package practice11;

import practice11.listener.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person implements Observer {
    private List<Klass> klasses = new ArrayList<>();

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, List<Klass> klasses) {
        super(id, name, age);
        this.klasses = klasses;
        klasses.forEach(klass1 -> klass1.addObserver(this));
    }

    @Override
    public String introduce() {
        return introduceKlasses();
    }

    public String introduceKlasses() {
        String klassListStr = klasses.stream().map(Klass::getNumber).collect(Collectors.toList())
                .stream().map(Object::toString).collect(Collectors.joining(", "));
        if (this.klasses.isEmpty()) {
            return String.format("%s I am a Teacher. I teach No Class.", super.introduce());
        } else {
            return String.format("%s I am a Teacher. I teach Class %s.", super.introduce(), klassListStr);
        }
    }

    public String introduceWith(Student student) {
        if (isTeaching(student)) {
            return String.format("%s I am a Teacher. I teach %s.", super.introduce(), student.getName());
        } else {
            return String.format("%s I am a Teacher. I don't teach %s.", super.introduce(), student.getName());
        }
    }

    public List<Klass> getClasses() {
        return klasses;
    }

    public boolean isTeaching(Student student) {
        return this.klasses.stream().anyMatch(t -> t.getNumber() == student.getKlass().getNumber());
    }

    @Override
    public void notifyJoin(Student student, Klass klass) {
        System.out.printf("I am %s. I know %s has joined %s.\n", this.getName(), student.getName(), klass.getDisplayName());
    }

    @Override
    public void notifyAssignLeader(Student student, Klass klass) {
        System.out.printf("I am %s. I know %s become Leader of %s.\n", this.getName(), student.getName(), klass.getDisplayName());
    }
}