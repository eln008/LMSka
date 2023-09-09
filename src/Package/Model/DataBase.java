package Package.Model;

import Package.Enum.Gender;

import java.util.LinkedList;

public class DataBase {
    private Group headGroup;
    private Student headStudent;
    private LinkedList<Student> students ;
    private LinkedList<Group> groups;
    public DataBase() {
        groups = new LinkedList<>();
        students = new LinkedList<>();
    }
    public LinkedList<Group> getGroups() {
        return groups;
    }

    public void setGroups(LinkedList<Group> groups) {
        this.groups = groups;
    }

    public LinkedList<Student> getStudents() {
        return students;
    }

    public void setStudents(LinkedList<Student> students) {
        this.students = students;
    }

    public Group getHeadGroup() {
        return headGroup;
    }

    public void setHeadGroup(Group headGroup) {
        this.headGroup = headGroup;
    }

    public Student getHeadStudent() {
        return headStudent;
    }

    public void setHeadStudent(Student headStudent) {
        this.headStudent = headStudent;
    }
}
