import java.util.ArrayList;

public class User<Account> {
    
    private String fname; //user name
    private String lname; //user last name
    private String uuid;  //user ID number
    private byte pinHash; //user pin
    private ArrayList<Account> account; // list of account for the user 
}
