package practice11;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person implements JoinListener, JoinLeaderListener{
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
        klasses.forEach(klass1 -> klass1.addTeacherList(this));
    }

    public Klass getKlass() {
        return klass;
    }

    public String introduce(){

        if(klasses == null){
            return introduceKlass();
        }else{
            return introduceKlasses();
        }

    }

    public String introduceKlass(){
        if(this.klass == null){
            return new StringBuilder().append(super.introduce())
                    .append(" I am a Teacher. I teach No Class.").toString();
        }else{
            return new StringBuilder().append(super.introduce())
                    .append(" I am a Teacher. I teach Class ").append(this.klass.getNumber()).append(".").toString();
        }
    }
    public String introduceKlasses(){
        List<Integer> klassListInt = new ArrayList<>();
        for(Klass klassList: klasses){
            klassListInt.add(klassList.getNumber());
        }
        String klassListStr = klassListInt.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        if(this.klasses.size()==0){
            return new StringBuilder().append(super.introduce())
                    .append(" I am a Teacher. I teach No Class.").toString();
        }else{
            return new StringBuilder().append(super.introduce())
                    .append(" I am a Teacher. I teach Class ").append(klassListStr).append(".").toString();
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

    public boolean isTeaching(Student student){
        if(klasses == null){
            if(this.klass == null){
                return false;
            }else{
                if (this.klass.getNumber() == student.getKlass().getNumber()){
                    return true;
                }else{
                    return  false;
                }
            }
        }else{
            if(this.klasses.size()==0){
                return false;
            }else{
                if(this.klasses.stream().anyMatch(t -> t.getNumber()==student.getKlass().getNumber())){
                    return true;
                }else {
                    return false;
                }
            }
        }
    }

    @Override
    public void notifyAssignLeader(Student student, Klass klass) {
        System.out.print(String.format("I am Tom. I know %s become Leader of %s.\n",student.getName(),klass.getDisplayName()));
    }

    @Override
    public void notifyJoin(Student student, Klass klass) {
        System.out.print(String.format("I am Tom. I know %s has joined %s.\n",student.getName(),klass.getDisplayName()));
    }
}