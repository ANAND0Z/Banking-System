
import java.util.*;

public class BankingSystem {
    static Scanner s=new Scanner(System.in);
    public static void main(String args[]){
        try{
        while(true){
            System.out.println("1.Admin side");
            System.out.println("2.User side");
            System.out.println("3.Exit");
            System.out.print("enter choice: ");
            int n=s.nextInt();
            switch (n) {
                case 1:adminside();
                    break;
                case 2:userside();
                    break;
                case 3:System.exit(0);
                    break;
                default:System.out.println("Invalid data");
                    break;
            }
        }}
        catch(Exception e){
            System.out.println(e);
        }
    }

    public static void adminside(){
        try{
        System.out.print("Enter username: ");
        String username=s.next();
        System.out.print("Enter password: ");
        String password=s.next();
        List<Admin> details=FileManager.loadadmins();
        List<User> userdetails=FileManager.loadUsers();
        Admin currentadmin=null;
        boolean t=false;
        int index=0;
        for(Admin users:details){
            if(users.getusername().equals(username) && users.getpassword().equals(password)){
                t=true;
                currentadmin=users;
                break;
            }
            index++;
        }
        if(t){
            System.out.println("1.create new user account");
            System.out.println("2.Show all users details");
            System.out.println("3.Specific user account");
            System.out.println("4.Exit");
            System.out.print("enter choice: ");
            int n=s.nextInt();
            switch (n) {
                case 1:
                    System.out.print("enter username: ");
                    String newusername=s.next();
                    System.out.print("enter password: ");
                    String newpassword=s.next();
                    System.out.print("enter email: ");
                    String newemail=s.next();
                    System.out.print("enter initial deposit amount: ");
                    int newamount=s.nextInt();
                    System.out.print("enter account no:");
                    String newaccountno=s.next();
                    User newuser=new User(newaccountno, newusername, newemail, newpassword, newamount);
                    userdetails.add(newuser);
                    FileManager.saveUsers(userdetails);
                    break;
                case 2:
                    for(User users:userdetails){
                        users.showdetails();
                    }
                    break;
                case 3:
                    userside();
                    break;
                case 4:
                    System.exit(0);
                    break;
            
                default:
                    break;
            }
        }
        else{
            System.out.println("Invalid username or password");
        }
    }
    catch(Exception e){
        System.out.println("Invalid data");
    }
    }

    public static void userside(){
        try{
        System.out.print("Enter Account Number: ");
        String account_no=s.next();
        System.out.print("Enter username: ");
        String username=s.next();
        System.out.print("Enter password: ");
        String password=s.next();
        List<User> details=FileManager.loadUsers();
        User currentuser=null;
        int amount;
        boolean t=false;
        int index=0;
        for(User users:details){
            if(users.getaccount_no().equals(account_no) && users.getusername().equals(username) && users.getpassword().equals(password)){
                t=true;
                currentuser=users;
                break;
            }
            index++;
        }
        if(t){
            System.out.println("1.Deposit amount");
            System.out.println("2.Withdraw amount");
            System.out.println("3.Check balance");
            System.out.println("4.Show details");
            System.out.println("5.change username");
            System.out.println("6.change password");
            System.out.println("7.change email");
            System.out.println("8.Exit");
            System.out.print("enter choice: ");
            int n=s.nextInt();
            switch (n) {
                case 1:
                    amount=0;
                    System.out.print("enter amount to deposit: ");
                    amount=s.nextInt();
                    currentuser.deposit(amount);
                    break;
                case 2:
                    amount=0;
                    System.out.print("enter amount to withdraw: ");
                    amount=s.nextInt();
                    currentuser.withdraw(amount);
                    break;
                case 3:
                    System.out.println(currentuser.getbalance());
                    break;
                case 4:
                    currentuser.showdetails();
                    break;
                case 5:
                    System.out.println("enter new username: ");
                    username=s.next();
                    currentuser.setusername(username);
                    break;
                case 6:
                    System.out.println("enter new passord: ");
                    password=s.next();
                    currentuser.setpassword(password);
                    break;
                case 7:
                    System.out.println("enter new email: ");
                    String email=s.next();
                    currentuser.setemail(email);
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid data");
                    break;
            }
            details.set(index, currentuser);
            FileManager.saveUsers(details);
        }
        else{
            System.out.println("Invalid account number or username or password");
        }
    }
    catch(Exception e){
        System.out.println("Invalid data");
    }
}

}


