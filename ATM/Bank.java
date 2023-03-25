import java.util.ArrayList;
import java.util.Random;

public class Bank {
    
    private String name;
    private ArrayList<User> users;
    private ArrayList<Account> accounts;

    public String getNewUserUUID() {
        //inits
        String uuid;
        Random rng = new Random();
        int len = 6;
        boolean nonUnique = false;
        // loping until we get a unique ID
        do {
            //generate the number
            uuid = "";
            for (int c = 0; c < len; c++) {
                uuid += ((Integer) rng.nextInt(10)).toString();
            }
            //Check to make sure it's unique
            for (User u : this.users) {
                if (uuid.compareTo(u.getUUID()) == 0) {
                    nonUnique = true;
                    break;
                }
            }
        } while (nonUnique);


        return uuid;
    }

    /**
     * Generate a new universally unique getNewAccountUUID for a user
     *
     * @return
     */

    public String getNewAccountUUID() {
        //inits
        String uuid;
        Random rng = new Random();
        int len = 10;
        boolean nonUnique = false;
        // loping until we get a unique ID
        do {
            //generate the number
            uuid = "";
            for (int c = 0; c < len; c++) {
                uuid += ((Integer) rng.nextInt(10)).toString();
            }
            //Check to make sure it's unique
            for (Account a : this.accounts) {
                if (uuid.compareTo(a.getUUID()) == 0) {
                    nonUnique = true;
                    break;
                }
            }
        } while (nonUnique);

        return uuid;
    }

    /**
     * Add an account
     *
     * @param anAcct the account to add
     */
    public void addAccount(Account anAcct) {
        this.accounts.add(anAcct);
    }

    public User addUser(String firstName, String lastName, String pin) {
        // create a new User object and add it to our list
        User newUser = new User(firstName, lastName, pin, this);
        this.users.add(newUser);
        // create a savings account for the user
        Account newAccount = new Account("Savings", newUser, this);
        // add to holder and bank lists
        newUser.addAccount(newAccount);
        this.addAccount(newAccount);
        return newUser;
    }

    /**
     * @param userID
     * @param pin
     * @return
     */
    public User userLogin(String userID, String pin) {
        for (User u : this.users) {
            if (u.getUUID().compareTo(userID) == 0 && u.validatePin(pin)){
                return u;
            }
        }
        // if we haven't found the user or have an incorrect pin
        return  null;
    }

    /**
     *
     * @param name
     * @return
     */
    public String getName() {

        return this.name;
    }

}
