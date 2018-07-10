package GraphicalInterface;

import Service.Client;

import javax.swing.*;
import java.awt.*;

public class SelectFlight extends JFrame {

    Client client;
    private JPanel pTitle = new JPanel();
    private JPanel pDepArr = new JPanel();
    private JPanel pButton = new JPanel();
    private JLabel lblSelectFlight = new JLabel("SELECT YOUR FLIGHT");
    private JLabel lblDeparture = new JLabel("Departure");
    private JTextField txtDeparture = new JTextField();
    private JLabel lblArrive = new JLabel("Arrive");
    private JTextField txtArrive = new JTextField();
    private JLabel lblDateofDeparture = new JLabel("Date of Departure");
    private JTextField txtDateofDeparture = new JTextField();
    private JLabel lblColor = new JLabel();
    private JCheckBox chkDepArr = new JCheckBox("Roundtrip");
    private JLabel lblDateofArrive = new JLabel("Date of Arrive:");
    private JTextField txtDateofArrive = new JTextField();
    private JButton btnNext = new JButton("Next");



    public SelectFlight(Client client){
        super("Airline Company - Select Flight");
        this.client = client;
        setSize(300,300);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initComponents(){
        pTitle.add(lblSelectFlight);
        add(pTitle,BorderLayout.NORTH);
        pDepArr.setLayout(new GridLayout(6,2));
        pDepArr.add(lblDeparture);
        pDepArr.add(txtDeparture);
        pDepArr.add(lblArrive);
        pDepArr.add(txtArrive);
        pDepArr.add(lblDateofDeparture);
        pDepArr.add(txtDateofDeparture);
        pDepArr.add(chkDepArr);
        pDepArr.add(lblDateofArrive);
        pDepArr.add(txtDateofArrive);
        pDepArr.add(lblColor);
        add(pDepArr,BorderLayout.CENTER);
        pButton.add(btnNext);
        add(pButton,BorderLayout.SOUTH);
    }

}
