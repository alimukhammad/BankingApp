import java.util.Date;

public class Transaction {
    
    private double amount;      //transaction amount
    private Date timestamp;     //transaction time & date
    private String memo;        //transaction memo
    private Account inAccount;  //transaction in the account

    public Transaction(double amount, Account inAccount) {
        this.amount = amount;
        this.inAccount = inAccount;
        this.timestamp = new Date();
        this.memo = "";
    }

    /**
     * @param amount    the amount transacted
     * @param memo      the memo for the transaction
     * @param inAccount the account the transactions belong to
     */
    public Transaction(double amount, String memo, Account inAccount) {
        // call  the two-ara constructor first
        this(amount, inAccount);

        //set the memo
        this.memo = memo;
    }

    public double getAmount() {
        return this.amount;
    }
    public  String getSummaryLine(){
        if (this.amount >= 0){
            return  String.format("%s : $%.02f", this.timestamp.toString(), this.amount, this.memo);
        }else {
            return String.format("%s : $(%.02f)", this.timestamp.toString(), -this.amount, this.memo);
        }
    }
}
