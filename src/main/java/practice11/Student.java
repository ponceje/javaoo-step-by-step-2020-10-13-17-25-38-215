package practice11;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student extends Person {
    private final Klass klass;
    private List<Klass> klasses = new ArrayList<>();

    public Student(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klasses.add(klass);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    public void addKlass(Klass klass) {
        klasses.add(klass);
    }

    @Override
    public String introduce() {
        if (klasses.stream().filter(klass1 -> klass1.getLeader() != null).anyMatch(klass1 -> klass1.getLeader().equals(this))) {
            return String.format("%s I am a Student. I am Leader of Class %d.", super.introduce(), this.klass.getNumber());
        } else {
            return String.format("%s I am a Student. I am at Class %d.", super.introduce(), this.klass.getNumber());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(klass, student.klass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), klass);
    }
}
