
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
        String account_no=s.next();
        System.out.print("Enter username: ");
        String username=s.next();
        System.out.println("Enter password: ");
        String password=s.next();
        //not completed
    }
    public static void userside(){
        System.out.print("Enter Account Number: ");
        String account_no=s.next();
        System.out.print("Enter username: ");
        String username=s.next();
        System.out.println("Enter password: ");
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
            System.out.println("4.Exit");
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
}


