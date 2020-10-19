package practice08;

import java.util.Optional;

public class Student extends Person {
    public static final String I_AM_A_STUDENT_I_AM_LEADER_OF = " I am a Student. I am Leader of ";
    public static final String I_AM_A_STUDENT_I_AM_AT = " I am a Student. I am at ";
    private Klass klass;

    public Student(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    public String introduce() { //need to find way
        return Optional.ofNullable(this.klass.getLeader())
                .map(leader -> new StringBuilder().append(super.introduce())
                        .append(I_AM_A_STUDENT_I_AM_LEADER_OF).append(this.klass.getDisplayName()).append(".").toString())
                .orElse(new StringBuilder().append(super.introduce())
                        .append(I_AM_A_STUDENT_I_AM_AT).append(this.klass.getDisplayName()).append(".").toString());

//        if(this.klass.getLeader() == null){//!null
//            return new StringBuilder().append(super.introduce())
//                    .append(I_AM_A_STUDENT_I_AM_AT).append(this.klass.getDisplayName()).append(".").toString();
//        }else{
//            if (this.klass.getLeader().getId() == this.getId()){
//                return new StringBuilder().append(super.introduce())
//                        .append(I_AM_A_STUDENT_I_AM_LEADER_OF).append(this.klass.getDisplayName()).append(".").toString();
//            }
//            else{
//                return new StringBuilder().append(super.introduce())
//                        .append(I_AM_A_STUDENT_I_AM_AT).append(this.klass.getDisplayName()).append(".").toString();
//            }
//        }
    }
}

