package GraphicalInterface;

import Core.Company;
import Web.Client;
import User.User;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Gruppo N
 */
public class BookSuccessFrame extends JFrame {

    private Client client;
    private User user;
    private Company airlineCompany;

    private JPanel pTitle = new JPanel();
    private JPanel pButton = new JPanel();
    private JLabel lblTitle = new JLabel("Booking completed successfully!");
    protected JButton btnReturn = new JButton("Go to Main Page");

    /**
     *
     * @param client The <code>Client</code> Class' instance of the current Session
     * @param user The <code>User</code> Class's instance of the current Session
     * @param airlineCompany The <code>Company</code> Class' instance of the current Session
     */
    public BookSuccessFrame(Client client, User user, Company airlineCompany){
        super("Airline Company - Booking Completed Succesfully!!");
        this.client = client;
        this.user = user;
        this.airlineCompany = airlineCompany;
        setSize(300,300);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        addListeners();
    }

    /**
     * To initialize Graphical Components
     */
    public void initComponents(){
        setLayout(new BorderLayout());
        add(pTitle, BorderLayout.NORTH);
        add(pButton, BorderLayout.CENTER);
        pTitle.add(lblTitle);
        pButton.add(btnReturn);


    }

    protected void setlblText(String s){
        lblTitle.setText(s);
    }

    /**
     * To add the Listeners
     */
    protected void addListeners(){

        btnReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    MainPageFrame mainPageFrame = new MainPageFrame(client, user, airlineCompany);
                } catch (ParseException e1) {
                    e1.printStackTrace();
                } setVisible(false);
            }
        });

    }

}
