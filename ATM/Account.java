import java.util.ArrayList;

public class Account {

    private String name;    //account name
    private String uuid;    //account ID
    private User holder;    //User object owner
    private ArrayList<Transaction> transaction; //transaction list

    //Create a new user
        // @param firstName    the user's first name
        // @param lastName     the user's last name
        // @param pin          the user's pin number
        // @param theBank      the Bank object parent of customer

    public Account(String name, User holder, Bank theBank){

        //set the account name and holder
        this.name = name;
        this.holder = holder;

        //get new account UUID
        this.uuid = theBank.getNewAccountUUID();

        //init transaction 
        this.transaction = new ArrayList<Transaction>();

        //add to holder and bank lists
        holder.addAccount(this);
        theBank.addAccount(this);
    }
}