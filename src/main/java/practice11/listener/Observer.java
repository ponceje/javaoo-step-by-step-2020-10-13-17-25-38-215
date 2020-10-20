package practice11.listener;

import practice11.Klass;
import practice11.Student;

public interface Observer {
    void notifyJoin(Student student, Klass klass);
    void notifyAssignLeader(Student student, Klass klass);
}
