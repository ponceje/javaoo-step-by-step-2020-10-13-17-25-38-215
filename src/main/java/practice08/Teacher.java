package practice08;


public class Teacher extends Person {
    private Klass klass;

    public Teacher(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }
    public Teacher(int id, String name, int age) {
        super(id, name, age);;
    }

    public Klass getKlass() {
        return klass;
    }

    public String introduce(){

        if(this.klass == null){
            return new StringBuilder().append(super.introduce())
                    .append(" I am a Teacher. I teach No Class.").toString();
        }else{
            return new StringBuilder().append(super.introduce())
                    .append(" I am a Teacher. I teach ").append(this.klass.getDisplayName()).append(".").toString();
        }

    }

    public String introduceWith(Student student){

        if(this.klass.getNumber()==student.getKlass().getNumber()){
            return new StringBuilder().append(super.introduce())
                    .append(" I am a Teacher. I teach ").append(student.getName()).append(".").toString();
        }else{
            return new StringBuilder().append(super.introduce())
                    .append(" I am a Teacher. I don't teach ").append(student.getName()).append(".").toString();
        }

    }

}