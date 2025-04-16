import java.io.Serializable;

public class Admin implements Serializable {
    private String username;
    private String password;

    Admin(String username,String password){
        this.username=username;
        this.password=password;
    }

    public String getusername(){
        return username;
    }

    public String getpassword(){
        return password;
    }
}
