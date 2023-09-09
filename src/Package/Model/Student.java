package Package.Model;

import Package.Enum.Gender;

import java.util.LinkedList;

public class Student {
    private static int idd=1;
    private int id;
    private LinkedList<Student> next;
    private String firstName;
    private String lastName;
    private String gmail;
    private String password;
    private Gender gender;

    public Student() {
        this.id = idd++;
    }


//    public Student() {
//
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getIdd() {
        return idd;
    }

    public void setIdd(int idd) {
        this.idd = idd;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LinkedList<Student> getNext() {
        return next;
    }

    public void setNext(LinkedList<Student> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "\nStudent " +
                "\nid: " + id +
                "\nfirstName:  " + firstName  +
                "\nlastName:  " + lastName  +
                "\ngmail:  " + gmail +
                "\npassword:  " + password +
                "\ngender:  " + gender +
                "\n";
    }


}
