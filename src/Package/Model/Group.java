package Package.Model;

import java.util.LinkedList;

public class Group {
    private static int idd=1;
    private int id;
    private String groupName;
    private LinkedList<Group> next;
    private String description;
    private LinkedList<Lesson> lessons;
    private LinkedList<Student> students;



    public Group() {
        this.id = idd++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LinkedList<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(LinkedList<Lesson> lessons) {
        this.lessons = lessons;
    }

    public LinkedList<Student> getStudents() {
        return students;
    }

    public void setStudents(LinkedList<Student> students) {
        this.students = students;
    }

    public LinkedList<Group> getNext() {
        return next;
    }

    public void setNext(Group next) {
        this.next = next.getNext();
    }

    public static int getIdd() {
        return idd;
    }

    public static void setIdd(int idd) {
        Group.idd = idd;
    }

    public void setNext(LinkedList<Group> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "\nGroup: \n" +
                "id: " + id + "\n" +
                "groupName:  " + groupName + "\n" +
                "description:  " + description +"\n" +
                "lessons:  " + lessons + "\n" +
                "students:  " + students + "\n" ;
    }

}
