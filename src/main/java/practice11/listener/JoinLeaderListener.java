package practice11.listener;

import practice11.Klass;
import practice11.Student;

public interface JoinLeaderListener {
    void notifyAssignLeader(Student student, Klass klass);
}
