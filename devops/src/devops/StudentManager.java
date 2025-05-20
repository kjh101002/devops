package devops;

import java.util.HashSet;
import java.util.Set;

public class StudentManager {
    private Set<String> students = new HashSet<>();
    
  //학생 추가
    public void addStudent(String name) {
        if (students.contains(name)) {
            throw new IllegalArgumentException("이미 존재하는 학생입니다: " + name);
        }
        students.add(name);
    }
}