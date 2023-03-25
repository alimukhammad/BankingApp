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
    }

    public String getUUID(){
        return this.uuid;
    }
    public String getSummaryLine(){
        //get the account's balance
        double balance = this.getBalance();

        // format summary line depending on whether balance is negative
        if ( balance >=0) {
            return String.format("%s : $%.02f: %s", this.uuid, balance, this.name);
        }else {
            return  String.format("%s : $(%.02f) : %s", this.uuid, balance, this.name);
        }
    }
    public  double getBalance(){
        double balance = 0;
        for (Transaction t : this.transactions){
            balance += t.getAmount();
        }
        return  balance;
    }
    public void printTransHistory(){
        System.out.printf("\n Transaction history for account %s \n", this.uuid);
        for (int t = this.transactions.size()-1; t >=0; t --){
            System.out.println(this.transactions.get(t).getSummaryLine() );
        }
        System.out.println();
    }
    public void  addTransaction (double amount, String memo){
        Transaction newTrans = new Transaction(amount, memo, this);
        this.transactions.add(newTrans);

    }
}