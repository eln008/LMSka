package Package.Service;
import java.util.LinkedList;
import java.util.Scanner;

import Package.Enum.Gender;
import Package.Interface.InterfaceGroup;
import Package.Model.DataBase;
import Package.Model.Group;
import Package.Model.Lesson;
import Package.Model.Student;

public class GroupService implements InterfaceGroup {
    DataBase dataBase = new DataBase();

    public GroupService(DataBase dataBase) {
        this.dataBase = dataBase;
    }
    @Override
    public void AddNewGroup() {
        try {
                Scanner scan = new Scanner(System.in);
                System.out.println("Введите название группы: ");
                String name = scan.next();
                System.out.println("Введите описание: ");
                String des = scan.next();

                Group newGroup = new Group();
                newGroup.setGroupName(name);
                newGroup.setDescription(des);
                newGroup.setStudents(new LinkedList<>());
                newGroup.setLessons(new LinkedList<>());

                if (dataBase.getHeadGroup() == null) {
                    dataBase.setHeadGroup(newGroup);
                    dataBase.getGroups().add(newGroup);
                } else {
                    Group current = dataBase.getHeadGroup();
                    while (current.getNext() != null) {
                        current = current;
                    }
                    dataBase.getGroups().add(newGroup);

                }
                System.out.println("Группа " + name + " успешно добавлена." + newGroup);
        } catch (Exception e) {
            System.err.println("Ошибка! Вы неправильно ввели свои данные!");
        }
    }

    @Override
    public void getGroupByName() {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите название группы: ");
            String name = scan.next();
            for (Group g : dataBase.getGroups()) {
                if (g.getGroupName().equals(name)) {
                    System.out.println(g);
                    return;
                }
            }
            System.err.println("Группа с именем " + name + " не найдена в базе данных.");
        } catch (Exception e) {
            System.err.println("Вы неправильно ввели название группы или произошла ошибка.");
        }
    }

    @Override
    public Group updateGroupName() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите нынешнее название группы: ");
        String name = scan.next();
        System.out.println("Введите новое название группы: ");
        String newName = scan.next();
        for (Group g: dataBase.getGroups()) {
           if(g.getGroupName().equals(name)){
               g.setGroupName(newName);
               System.out.println("Название группы успешно обновлено.");
               return g;
           }
        }

        System.out.println("Ne naideno");
        return null;
    }

    @Override
    public LinkedList<Group> getAllGroups() {
        return dataBase.getGroups();
    }

    @Override
    public LinkedList<Student> getAllStudentsByGroupName() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите название группы: ");
        String name = scan.next();
        for (Group g: dataBase.getGroups()) {
            if(g.getGroupName().equals(name)){
                return g.getStudents();
            }
        }
        return null;
    }



    @Override
    public void addNewStudent() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите название группы: ");
        String groupName = scan.next();

        Group targetGroup = null;
        for (Group group : dataBase.getGroups()) {
            if (group.getGroupName().equals(groupName)) {
                targetGroup = group;
                break;
            }
        }

        if (targetGroup == null) {
            System.err.println("Такой группы нет в нашей базе данных! ");
            return;
        }

        System.out.println("Введите имя студента: ");
        String name = scan.next();
        System.out.println("Введите фамилию студента: ");
        String lastName = scan.next();
        System.out.println("Введите Email: ");
        String email = scan.next();
        if (!email.contains("@")) {
            System.err.println("Неправильно ввели email");
            return;
        }

        System.out.println("Придумайте пароль (не менее 7 символов): ");
        String newPassword = scan.next();
        if (newPassword.length() < 7) {
            System.err.println("Вы неправильно ввели пароль. Он должен быть не менее 7 символов.");
            return;
        }

        System.out.println("Выберите gender (1) FEMALE  2) MALE): ");
        int genderChoice = scan.nextInt();
        Gender gender;

        if (genderChoice == 1) {
            gender = Gender.FEMALE;
        } else if (genderChoice == 2) {
            gender = Gender.MALE;
        } else {
            System.err.println("Неправильный выбор gender. Пол будет установлен как неопределенный.");
            gender = Gender.UNKNOWN;
        }

        Student newStudent = new Student();
        newStudent.setFirstName(name);
        newStudent.setLastName(lastName);
        newStudent.setGmail(email);
        newStudent.setPassword(newPassword);
        newStudent.setGender(gender);

        targetGroup.getStudents().add(newStudent);
        dataBase.getStudents().add(newStudent);
        System.out.println("Студент " + name + " успешно добавлен в группу " + groupName + ": " + newStudent);
    }

    @Override
    public void addNewLessonToGroup() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите название группы: ");
        String groupName = scan.next();

        Group targetGroup = null;
        for (Group g : dataBase.getGroups()) {
            if (g.getGroupName().equals(groupName)) {
                targetGroup = g;
                break;
            }
        }

        if (targetGroup == null) {
            System.err.println("Такой группы не существует! ");
            return;
        }

        System.out.println("Введите название урока: ");
        String lessonName = scan.next();

        System.out.println("Введите описание урока: ");
        String lessonDesc = scan.next();

        Lesson newLesson = new Lesson();
        newLesson.setLessonName(lessonName);
        newLesson.setLessonDesc(lessonDesc);

        targetGroup.getLessons().add(newLesson);

        System.out.println("Урок '" + lessonName + "' успешно добавлен в группу '" + groupName + "'.");
    }



    @Override
    public void getAllStudentsLesson() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите почту студента: ");
        String gmail = scan.next();
        for (Group g: dataBase.getGroups()) {
            if(g.getStudents().getFirst().getGmail().equals(gmail)){
                System.out.println(g.getLessons());
            }
        }
    }

    @Override
    public void getLessonByName() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите название урока, который хотите найти: ");
        String name = scan.next();

        boolean lessonFound = false;

        for (Lesson l : dataBase.getHeadGroup().getLessons()) {
            if (l.getLessonName().equals(name)) {
                System.out.println(l);
                lessonFound = true;
                break;
            }
        }

        if (!lessonFound) {
            System.err.println("Урок " + name + " не найден!");
        }
    }


    @Override
    public void getAllLessonByGroupName() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите название группы чтобы получить список уроков: ");
        String name = scan.next();
        for (Group g:dataBase.getGroups()) {
            if(g.getGroupName().equals(name)){
                for (Lesson l: dataBase.getHeadGroup().getLessons()) {
                    System.out.println(l);
                }
            }else System.err.println("Такая группа не найдено!");
        }
    }

    @Override
    public void deleteGroupByName() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите название группы которую хотите удалить: ");
        String name = scan.next();
        Group groupToDelete = null;
        for (Group g:dataBase.getGroups()) {
            if(g.getGroupName().equals(name)){
                groupToDelete = g;
                break;
            }
        }
        if(groupToDelete != null){
            dataBase.getGroups().remove(groupToDelete);
            System.out.println("Группа '" + name + "' успешно удалена.");
        } else {
            System.out.println("Группа с именем '" + name + "' не найдена.");
        }
    }

    @Override
    public void deleteLessonByName() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите название урока которого хотите удалить");
        String deleteName = scan.next();
        Lesson lessonToDelete = null;
        for (Lesson l : dataBase.getHeadGroup().getLessons()) {
            if(l.getLessonName().equals(deleteName)){
                lessonToDelete = l;
                break;
            }
        }
        if(lessonToDelete != null){
            dataBase.getHeadGroup().getLessons().remove(lessonToDelete);
            System.out.println("Урок '" + deleteName + "' успешно удалена.");
    } else {
        System.err.println("Урок с названием '" + deleteName + "' не найдена.");
    }
    }
}
