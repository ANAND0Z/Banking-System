
import java.io.*;
import java.util.*;

public class FileManager {
    private static final String USER_FILE = "users.txt";

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
}


