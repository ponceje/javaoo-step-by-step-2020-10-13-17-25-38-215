package practice10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Klass {

    private int number;
    private Student leader;
    private List<Student> member = new ArrayList<>();

    public Klass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getDisplayName(){
        return "Class " + this.number;
    }

    public void assignLeader(Student student){

        if (member.stream().anyMatch(studentInList -> Objects.equals(studentInList, student))){
            this.leader = student;
        }else{
            System.out.print("It is not one of us.\n");
        }

    }

    public Student getLeader(){ return leader; }

    public void appendMember(Student student){
        this.member.add(student);
    }

    public List<Student> getMember(){ return member;}
}