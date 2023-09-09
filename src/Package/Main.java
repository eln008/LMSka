package Package;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Scanner;
import Package.Model.*;
import Package.Service.GroupService;
import Package.Service.StudentService;

public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin("Elnura@gmail.com", "password");
        DataBase dataBase = new DataBase();
        GroupService groupService = new GroupService(dataBase);
        StudentService studentService = new StudentService(dataBase);


        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(currentDate);
        System.out.println("Current Time: " + formattedDate);

        Scanner scan = new Scanner(System.in);
        int choice;
        System.out.println("Для входа \nВведите ваш gmail: ");
        String gmail = scan.next();
        System.out.println("Введите ваш password: ");
        String password = scan.next();
        if(!gmail.equals(admin.getEmail()) && !password.equals(admin.getAdminPassword())){
            System.out.println("Вы неправильно ввели свои данные в доступе отказано! ");
            return;
        }
        else {


        do {
            System.out.println("Меню:");
            System.out.println("1. Добавить новую группу");
            System.out.println("2. Добавить новый урок в группу");
            System.out.println("3. Добавить нового студента");
            System.out.println("4. Вывести все группы");
            System.out.println("5. Вывести всех студентов группы по урокам");
            System.out.println("6. Найти урок по имени");
            System.out.println("7. Вывести все уроки по названию группы");
            System.out.println("8. Найти группу по имени");
            System.out.println("9. Обновить название группы");
            System.out.println("10. Обновить имя студента");
            System.out.println("11. Вывести всех студентов группы (повторно)");
            System.out.println("12. Найти студента по имени");
            System.out.println("13. Удалить урок по имени");
            System.out.println("14. Удалить группу по имени");
            System.out.println("15. Удалить студента по имени");
            System.out.println("0. Выход из программы");
            System.out.print("Выберите действие: ");

            choice = scan.nextInt();

            try {
                switch (choice) {
                    case 1:
                        groupService.AddNewGroup();
                        break;
                    case 2:
                        groupService.addNewLessonToGroup();
                        break;
                    case 3:
                        groupService.addNewStudent();
                        break;
                    case 4:
                        System.out.println(groupService.getAllGroups());
                        break;
                    case 5:
                        groupService.getAllStudentsLesson();
                        break;
                    case 6:
                        groupService.getLessonByName();
                        break;
                    case 7:
                        groupService.getAllLessonByGroupName();
                        break;
                    case 8:
                        groupService.getGroupByName();
                        break;
                    case 9:
                        groupService.updateGroupName();
                        break;
                    case 10:
                        studentService.updateStudent();
                        break;
                    case 11:
                        System.out.println(groupService.getAllStudentsByGroupName());
                        break;
                    case 12:
                        studentService.findStudentByFirstName();
                        break;

                    case 13:
                        groupService.deleteLessonByName();
                        break;
                    case 14:
                        groupService.deleteGroupByName();
                        break;
                    case 15:
                        studentService.deleteStudent();
                    case 0:
                        System.out.println("Выход из программы.");
                        break;
                    default:
                        System.out.println("Некорректный выбор. Попробуйте снова.");
                }
            } catch (Exception e) {
                System.err.println("Произошла ошибка: " + e.getMessage());
            }
        } while (choice != 0);
        }
    }
}