package practice06;

public class Teacher extends Person{
    private int klass;

    public Teacher(String name, int age, int klass) {
        super(name, age);
        this.klass = klass;
    }
    public Teacher(String name, int age) {
        super(name, age);
    }

    public int getKlass() {
        return klass;
    }

    public String introduce(){

        if(klass == 0){
            return new StringBuilder().append(super.introduce())
                    .append(" I am a Teacher. I teach No Class.").toString();
        }else{
            return new StringBuilder().append(super.introduce())
                    .append(" I am a Teacher. I teach Class ").append(this.klass).append(".").toString();
        }

    }

}
