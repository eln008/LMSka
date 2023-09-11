package Package.Interface;

import Package.Model.Group;
import Package.Model.Lesson;
import Package.Model.Student;

import java.util.LinkedList;

public interface InterfaceGroup {
    void AddNewGroup ();
    void getGroupByName ();
    Group updateGroupName();
    LinkedList<Group> getAllGroups();
    LinkedList<Student> getAllStudentsByGroupName();
    void addNewStudent ();
    void addNewLessonToGroup ();
    void getAllStudentsLesson ();
    void getLessonByName();
    void getAllLessonByGroupName();
    void deleteGroupByName();
    void deleteLessonByName();





}
