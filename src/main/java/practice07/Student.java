package practice07;

public class Student extends Person {
    public static final String I_AM_A_STUDENT_I_AM_AT = " I am a Student. I am at ";
    public static final String PERIOD = ".";
    private Klass klass;

    public Student(String name, int age, Klass klass) {
        super(name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    public String introduce(){
        return new StringBuilder().append(super.introduce()).append(I_AM_A_STUDENT_I_AM_AT)
                .append(this.klass.getDisplayName()).append(PERIOD).toString();
    }
}
