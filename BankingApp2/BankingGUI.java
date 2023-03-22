import javax.swing.*;
import java.awt.*;

public class BankingGUI extends JFrame {
    private JTextField unField;
    private JTextField psField;
    
    public BankingGUI() {
        setTitle("Banking Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        
        //menu bar
        JMenuBar mb = new JMenuBar();

        //file menu
        JMenu mFile = new JMenu("File");
        JMenuItem mOpen = new JMenuItem("Open");
        JMenuItem mSaveAs = new JMenuItem("Save as");
        mFile.add(mSaveAs);
        mFile.add(mOpen);
        mb.add(mFile);
        //support menu
        setJMenuBar(mb);
        JMenu mHelp = new JMenu("Help");
        JMenuItem mSupport = new JMenuItem("Support Link");
        mHelp.add(mSupport);
        mb.add(mHelp);

        //username label & field
        JLabel unLabel = new JLabel("Username");
        unField = new JTextField(20);
        JPanel unPanel = new JPanel(new FlowLayout());
        unPanel.add(unLabel);
        unPanel.add(unField);


        //password label & field
        JLabel psLabel = new JLabel("Password");
        psField = new JTextField(20);
        JPanel psPanel = new JPanel(new FlowLayout());
        psPanel.add(psLabel);
        psPanel.add(psField);

        JPanel mainPanel = new JPanel(new GridLayout(3, 1));
        mainPanel.add(unPanel);
        mainPanel.add(psPanel);
        add(mainPanel, BorderLayout.CENTER);


        setVisible(true);
    }
    
    public static void main(String[] args) {
        new BankingGUI();
    }
}
