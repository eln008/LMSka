package Package.Model;
import java.util.Scanner;
public class Admin {
    private String email;
    private String adminPassword;

    public Admin(String email, String adminPassword) {
        this.email = email;
        this.adminPassword = adminPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public  void checkEmail (){
        Scanner scan =new Scanner (System.in);
        System.out.println("Введите Email: ");
        String pass = scan.next();
        if(!pass.equals(getEmail())){
            System.err.println("Вы неправильно ввели свой Email!");
        }
    }
    public void checkPassword (Admin admin){
        Scanner scan =new Scanner (System.in);
        System.out.println("Введите пароль: ");
        String pass = scan.next();
        if(!pass.equals(getAdminPassword())){
            System.err.println("Вы неправильно ввели свой пароль!");
        }
    }
}
