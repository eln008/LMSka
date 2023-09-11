package Package.Service;

import Package.Enum.Gender;
import Package.Interface.InterfaceStudent;
import Package.Model.DataBase;
import Package.Model.Group;
import Package.Model.Student;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class StudentService implements InterfaceStudent {
    DataBase dataBase = new DataBase();

    public StudentService(DataBase dataBase) {
        this.dataBase = dataBase;
    }


    public void updateStudent() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите имя студента, которого вы хотите обновить: ");
        String name = scan.next();
        boolean studentFound = false;
        for (Student s : dataBase.getStudents()) {
            if (s.getFirstName().equals(name)) {
                System.out.println("Введите новое имя для студента " + s.getFirstName() + ": ");
                String newName = scan.next();
                s.setFirstName(newName);
                System.out.println("Имя успешно обновлено на " + newName);
                studentFound = true;
                break;
            }
        }

        if (!studentFound) {
            System.out.println("Студент с именем " + name + " не найден.");
        }
    }



    @Override
    public void findStudentByFirstName() {
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите имя студента, которого ищете: ");
            String name = scan.next();
            boolean studentFound = false;
            for (Student s : dataBase.getStudents()) {
                if (s.getFirstName().equals(name)) {
                    System.out.println(s);
                    studentFound = true;
                }
            }
            if (!studentFound) {
                System.err.println("Такого студента нет в нашей базе данных!");
            }
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

