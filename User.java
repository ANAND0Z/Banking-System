
import java.io.Serializable;

public class User implements Serializable  {
    private String account_no;
    private String username;
    private String email;
    private String password;
    private double amount;

    public User(String account_no, String username, String email, String password,int amount) {
        this.account_no = account_no;
        this.username = username;
        this.email = email;
        this.password = password;
        this.amount=amount;
    }

    public String getaccount_no() {
        return account_no;
    }

    public void setaccount_no(String account_no) {
        this.account_no = account_no;
    }

    public double getbalance() {
        return amount;
    }

    public void setbalance(int amount) {
        this.amount= amount;
    }

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public void deposit(double amount) {
        if(amount>=0){
        this.amount += amount;
        }
        else{
            System.out.println("Invalid amount");
        }
    }

    public void withdraw(double amount){
        if (this.amount < amount) {
            System.out.println("Insufficient balance");
        }
        else{
        this.amount -= amount;
        }
    }
}

