
import javax.swing.*;

public class BankingApplication {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BankingGUI();
            }
        });
    }
}
