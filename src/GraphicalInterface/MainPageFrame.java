package GraphicalInterface;

import User.User;
import Web.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainPageFrame extends JFrame {

    Client client;
    User user;

    JPanel pTitle = new JPanel();
    JPanel pUsername = new JPanel();
    JPanel pButton = new JPanel();

    JLabel lblDisconnect = new JLabel("Disconnect");
    JLabel lblUsername;

    JButton btnSelectFlight = new JButton("Select Flight");
    JButton btnGoToProfile = new JButton("Go To Your Profile");

    public MainPageFrame(Client client, User user){
        super("Airline Company");
        setSize(300,150);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Font f = new Font("",Font.HANGING_BASELINE,10);
        this.client = client;
        this.user = user;
        lblDisconnect.setFont(f);
        initComponents();

    }

    public void initComponents(){
        lblUsername = new JLabel("Welcome " + user.getName() + " " + user.getSurname() + "!");
        pTitle.add(lblDisconnect);
        add(pTitle, BorderLayout.EAST);
        pUsername.add(lblUsername,BorderLayout.CENTER);
        add(pUsername,BorderLayout.CENTER);
        pButton.add(btnGoToProfile);
        pButton.add(btnSelectFlight);
        add(pButton,BorderLayout.SOUTH);
    }

    public void addListeners(){

        lblDisconnect.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LogInFrame logInFrame = new LogInFrame(client);
                logInFrame.initComponents();
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lblDisconnect.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblDisconnect.setForeground(Color.BLACK);
            }


        });

    }



}
