package practice11;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Klass {

    private int number;
    private Student leader;
    private List<Student> member = new ArrayList<>();
    private List<Teacher> teacherList = new ArrayList<>();

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

        if (this.member.contains(student)){
            this.leader = student;
            this.teacherList.forEach(teacher -> teacher.notifyAssignLeader(student, this));
        }else{
            System.out.print("It is not one of us.\n");
        }

    }

    public Student getLeader(){ return leader; }

    public void appendMember(Student student){
        this.member.add(student);
        this.teacherList.forEach(teacher -> teacher.notifyJoin(student,this));
    }

    public List<Student> getMember(){ return member;}

    public void addTeacherList(Teacher teacher) {
        this.teacherList.add(teacher);
    }
}
