package practice10;

public class Student extends Person {
    private Klass klass;

    public Student(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    public String introduce(){ //need to find way
        if(this.klass.getLeader() == null){
            return new StringBuilder().append(super.introduce())
                    .append(" I am a Student. I am at Class ").append(this.klass.getNumber()).append(".").toString();
        }else{
            if (this.klass.getLeader().getId() == this.getId()){
                return new StringBuilder().append(super.introduce())
                        .append(" I am a Student. I am Leader of Class ").append(this.klass.getNumber()).append(".").toString();
            }
            else{
                return new StringBuilder().append(super.introduce())
                        .append(" I am a Student. I am at Class ").append(this.klass.getNumber()).append(".").toString();
            }
        }
    }

}