package practice10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person {
    public static final String I_AM_A_TEACHER_I_TEACH_NO_CLASS = " I am a Teacher. I teach No Class.";
    public static final String I_AM_A_TEACHER_I_TEACH_CLASS = " I am a Teacher. I teach Class ";
    private Klass klass;
    private List<Klass> klasses = new ArrayList<>();

    public Teacher(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }
    public Teacher(int id, String name, int age) {
        super(id, name, age);;
    }
    public Teacher(int id, String name, int age, List<Klass> klasses) {
        super(id, name, age);
        this.klasses = klasses;
    }

    public Klass getKlass() {
        return klass;
    }

    public String introduce(){

        String klassListStr = klasses.stream()
                .map(klassList -> String.valueOf(klass.getNumber()))
                .collect(Collectors.joining(", "));

        if(this.klasses.size()==0){
            return new StringBuilder().append(super.introduce())
                    .append(I_AM_A_TEACHER_I_TEACH_NO_CLASS).toString();
        }else{
            return new StringBuilder().append(super.introduce())
                    .append(I_AM_A_TEACHER_I_TEACH_CLASS).append(klassListStr).append(".").toString();
        }

    }

    public String introduceWith(Student student){
        if(isTeaching(student)){
            return new StringBuilder().append(super.introduce())
                    .append(" I am a Teacher. I teach ").append(student.getName()).append(".").toString();
        }else{
            return new StringBuilder().append(super.introduce())
                    .append(" I am a Teacher. I don't teach ").append(student.getName()).append(".").toString();
        }
    }

    public List<Klass> getClasses(){ return klasses; }

    public boolean isTeaching(Student student) {
        if (this.klasses.stream().anyMatch(t -> t.getNumber() == student.getKlass().getNumber())) {
            return true;
        } else {
            return false;
        }
    }
}