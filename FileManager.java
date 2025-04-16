
import java.io.*;
import java.util.*;

public class FileManager {
    private static final String USER_FILE = "users.txt";
    private static final String ADMIN_FILE = "admins.txt";

    public static void saveUsers(List<User> users){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(USER_FILE))) {
            out.writeObject(users);
        } catch (IOException e) {
            System.out.println("Error saving users data.");
        }
    }

    public static List<User> loadUsers(){
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(USER_FILE))) {
            return (List<User>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading users data.");
        }
        return new ArrayList<>();
    }

    public static List<Admin> loadadmins(){
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ADMIN_FILE))) {
            return (List<Admin>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading admin data.");
        }
        return new ArrayList<>();
    }

    public static void saveadmins(List<Admin> users){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ADMIN_FILE))) {
            out.writeObject(users);
        } catch (IOException e) {
            System.out.println("Error saving admin data.");
        }
    }
}


