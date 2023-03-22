import javax.swing.*;
import java.awt.*;

public class BankingGUI extends JFrame {
    
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

        setJMenuBar(mb);
        JMenu mHelp = new JMenu("Help");
        JMenuItem mSupport = new JMenuItem("Support Link");
        mHelp.add(mSupport);
        mb.add(mHelp);

        // Create two buttons
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        
        // Create a panel with FlowLayout manager
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(button1);
        panel.add(button2);
        
        // Add the panel to the center of the frame
        add(panel, BorderLayout.CENTER);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new BankingGUI();
    }
}
