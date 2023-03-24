import java.util.ArrayList;

public class Account {

    private String name;    //account name
    private double balance; //account balance
    private String uuid;    //account ID
    private User holder;    //User object owner
    private ArrayList<Transaction> transaction; //transaction list
}