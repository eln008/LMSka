package Package.Service;

import Package.Enum.Gender;
import Package.Interface.InterfaceStudent;
import Package.Model.DataBase;
import Package.Model.Group;
import Package.Model.Student;

import java.util.LinkedList;
import java.util.Scanner;

public class StudentService implements InterfaceStudent {
    DataBase dataBase = new DataBase();

    public StudentService(DataBase dataBase) {
        this.dataBase = dataBase;
    }


    @Override
    public void updateStudent() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите имя студента: ");
        String name = scan.next();
        System.out.println("Введите новое имя студента: ");
        String newName = scan.next();
        for (Student s: dataBase.getStudents()) {
           if(s.getFirstName().equals(name)){
               s.setFirstName(newName);
               System.out.println("Имя успешно обновлено.");
           }
        }
    }

    @Override
    public Student findStudentByFirstName() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите имя студента которого ищете");
        String name = scan.next();
        for (Student s:dataBase.getStudents()) {
            if(s.getFirstName().equals(name)){
                return s;
            }
        }
        return null;
    }

    @Override
    public void deleteStudent() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите имя студента для удаления: ");
        String name = scan.next();
        Student studentToDelete = null;
        for (Student s:dataBase.getStudents()) {
            if(s.getFirstName().equals(name)){
                studentToDelete = s;
                break;
            }
        }
        if(studentToDelete != null){
            dataBase.getStudents().remove(studentToDelete);
            System.out.println("Студент успешно удален!");
        }else {
            System.out.println("Студент с таким именем не найден! ");
        }
    }


}

