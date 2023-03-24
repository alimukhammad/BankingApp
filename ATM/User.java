import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class User<Account> {
    
    private String firstname; //user name
    private String lastname; //user last name
    private String uuid;  //user ID number
    private byte pinHash[]; //user pin
    private ArrayList<Account> account; // list of account for the user 

    //Create a new user
        // @param firstName    the user's first name
        // @param lastName     the user's last name
        // @param pin          the user's pin number
        // @param theBank      the Bank object parent of customer

    public User(String firstName, String lastName, String pin, Bank theBank){

        //set user's name
        this.firstname = firstName;
        this.lastname = lastName;

        //store the pin's MD5 hash, rather than the original value, for security reason
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.pinHash = md.digest(pin.getBytes());
        }catch(NoSuchAlgorithmException e){
            System.err.println("error, caught NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }    

        //get a new, unique universal ID for the user
        this.uuid = theBank.getNewUserUUID();

        //create empty list of accounts
        this.account = new ArrayList<Account>();

        //print log message
        System.out.printf("New user %s, %s with ID %s create.\n", lastName, firstName, this.uuid);

    }

    //Add an Account for the user
        //@param anAcct the account to add
    public void addAccount(Account anAcct){
        this.account.add(anAcct);
    
    }

    public String getUUID(){
        return this.uuid;
    }
}
