package practice07;

public class Teacher extends Person {
    public static final String I_AM_A_TEACHER_I_TEACH = " I am a Teacher. I teach ";
    public static final String I_AM_A_TEACHER_I_DON_T_TEACH = " I am a Teacher. I don't teach ";
    public static final String I_AM_A_TEACHER_I_TEACH_NO_CLASS = " I am a Teacher. I teach No Class.";
    public static final String I_AM_A_TEACHER_I_TEACH1 = " I am a Teacher. I teach ";
    public static final String DOT = ".";
    private Klass klass;

    public Teacher(String name, int age, Klass klass) {
        super(name, age);
        this.klass = klass;
    }
    public Teacher(String name, int age) {
        super(name, age);
    }

    public Klass getKlass() {
        return klass;
    }

    public String introduce(){

        if(this.klass == null){
            return new StringBuilder().append(super.introduce())
                    .append(I_AM_A_TEACHER_I_TEACH_NO_CLASS).toString();
        }else{
            return new StringBuilder().append(super.introduce())
                    .append(I_AM_A_TEACHER_I_TEACH1).append(this.klass.getDisplayName()).append(DOT).toString();
        }

    }

    public String introduceWith(Student student){

        if(this.klass.getNumber()==student.getKlass().getNumber()){
            return new StringBuilder().append(super.introduce())
                    .append(I_AM_A_TEACHER_I_TEACH).append(student.getName()).append(DOT).toString();
        }else{
            return new StringBuilder().append(super.introduce())
                    .append(I_AM_A_TEACHER_I_DON_T_TEACH).append(student.getName()).append(DOT).toString();
        }

    }

}
