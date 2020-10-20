package practice11;

import practice11.listener.Observer;

import java.util.ArrayList;
import java.util.List;

public class Klass {

    private final int number;
    private Student leader;
    private final List<Student> member = new ArrayList<>();
    private final List<practice11.listener.Observer> observers = new ArrayList<>();

    public Klass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getDisplayName() {
        return "Class " + this.number;
    }

    public void assignLeader(Student student) {
        if (this.member.contains(student)) {
            this.leader = student;
            this.observers.forEach(observer -> observer.notifyAssignLeader(student, this));
        } else {
            System.out.print("It is not one of us.\n");
        }
    }

    public Student getLeader() {
        return leader;
    }

    public void appendMember(Student student) {
        this.member.add(student);
        student.addKlass(this);
        this.observers.forEach(observer -> observer.notifyJoin(student, this));
    }

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }
}
