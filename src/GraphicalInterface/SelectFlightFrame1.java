package GraphicalInterface;

import Core.Airport;
import Core.Company;
import Core.TempTicket;
import Web.Client;
import User.User;
import org.json.simple.parser.ParseException;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SelectFlightFrame1 extends JFrame {

    private Client client;
    private User user;
    private Company airlineCompany;
    private JPanel pTitle = new JPanel();
    private JPanel pDepArr = new JPanel();
    private JPanel pButton = new JPanel();
    private JLabel lblSelectFlight;
    private JLabel lblDeparture = new JLabel("Departure");
    private JComboBox cmbDeparture;
    private JComboBox cmbArrive;
    private JLabel lblArrive = new JLabel("Arrive");
    private JCheckBox chkDepArr = new JCheckBox("Roundtrip");
    private JButton btnBack = new JButton("Back To Home Page");
    private JButton btnNext = new JButton("Next");



    public SelectFlightFrame1(Client client, User user, Company airlineCompany){
        super("Airline Company - Select Flight");
        this.airlineCompany = airlineCompany;
        this.client = client;
        this.user = user;
        setSize(300,300);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        addListeners();
    }

    private void initComponents(){
        getAirports();
        this.lblSelectFlight = new JLabel("Hi " + user.getName() + "! Select Your Flight!");
        setLayout(new BorderLayout());
        add(pTitle, BorderLayout.NORTH);
        add(pDepArr, BorderLayout.CENTER);
        add(pButton, BorderLayout.SOUTH);
        pTitle.add(lblSelectFlight);
        pDepArr.setLayout(new GridLayout(3,2));
        pDepArr.add(lblDeparture);
        pDepArr.add(cmbDeparture);
        pDepArr.add(lblArrive);
        pDepArr.add(cmbArrive);
        pDepArr.add(chkDepArr);
        pButton.add(btnBack);
        pButton.add(btnNext);
    }

    private void addListeners(){

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    MainPageFrame mainPageFrame = new MainPageFrame(client, user, airlineCompany);
                    setVisible(false);
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }

            }
        });

        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean roundtrip = false;
                if(chkDepArr.isSelected())
                    roundtrip = true;
                TempTicket tempTicketDep = new TempTicket(client, user, airlineCompany.getAirportByName(cmbDeparture.getSelectedItem().toString()),
                        airlineCompany.getAirportByName(cmbArrive.getSelectedItem().toString()), roundtrip);
                TempTicket tempTicketArr = new TempTicket(client, user, airlineCompany.getAirportByName(cmbArrive.getSelectedItem().toString()),
                        airlineCompany.getAirportByName(cmbDeparture.getSelectedItem().toString()), roundtrip);
                    SelectFlightFrame2 selectFlightFrame2 = new SelectFlightFrame2(client, user, airlineCompany, tempTicketDep);
                    setVisible(false);

            }
        });

    }

    private void getAirports(){
        String[] lineArray = airlineCompany.getAirportsNames().toArray(new String[]{});
        this.cmbDeparture = new JComboBox<>(lineArray);
        this.cmbArrive = new JComboBox<>(lineArray);
    }

}