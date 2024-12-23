package Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Customer & Car Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Customer Management Tab
        JPanel customerPanel = new JPanel(new BorderLayout());
        customerPanel.setBackground(new Color(91, 173, 248)); // Light blue background

        JTextField txtCustomerName = new JTextField(20);
        txtCustomerName.setBackground(new Color(255, 255, 255)); // Light yellow background
        JComboBox<String> carComboBox = new JComboBox<>();
        JButton btnAddCustomer = new JButton("Add Customer");
        btnAddCustomer.setBackground(new Color(50, 205, 50)); // Lime green background
        btnAddCustomer.setForeground(Color.WHITE); // White text

        DefaultTableModel customerTableModel = new DefaultTableModel(
                new Object[]{"Customer Name", "Car Name", "Car Type", "Car Price", "Payment Status", "Action"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Makes all cells uneditable
            }
        };
        JTable customerTable = new JTable(customerTableModel);
        customerTable.getTableHeader().setResizingAllowed(false); // Prevents column resizing
        customerTable.getTableHeader().setReorderingAllowed(false); // Prevents column reordering
        JScrollPane customerScrollPane = new JScrollPane(customerTable);

        // Setting fixed column widths (optional)
        customerTable.getColumnModel().getColumn(0).setPreferredWidth(150); // Customer Name
        customerTable.getColumnModel().getColumn(1).setPreferredWidth(150); // Car Name
        customerTable.getColumnModel().getColumn(2).setPreferredWidth(150); // Car Type
        customerTable.getColumnModel().getColumn(3).setPreferredWidth(150); // Car Price
        customerTable.getColumnModel().getColumn(4).setPreferredWidth(150); // Payment Status
        customerTable.getColumnModel().getColumn(5).setPreferredWidth(100); // Action

        JPanel customerInputPanel = new JPanel();
        customerInputPanel.setBackground(new Color(91, 173, 248)); // Light cyan background
        customerInputPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        customerInputPanel.add(new JLabel("Customer Name:"));
        customerInputPanel.add(txtCustomerName);
        customerInputPanel.add(new JLabel("Select Car:"));
        customerInputPanel.add(carComboBox);
        customerInputPanel.add(btnAddCustomer);

        customerPanel.add(customerInputPanel, BorderLayout.NORTH);
        customerPanel.add(customerScrollPane, BorderLayout.CENTER);

        // Car Management Tab
        JPanel carPanel = new JPanel(new BorderLayout());
        carPanel.setBackground(new Color(91, 173, 248)); // Beige background

        JTextField txtCarName = new JTextField(15);
        txtCarName.setBackground(new Color(255, 255, 255)); // Misty rose background
        JTextField txtCarType = new JTextField(15);
        txtCarType.setBackground(new Color(255, 255, 255));
        JTextField txtCarBrand = new JTextField(15);
        txtCarBrand.setBackground(new Color(255, 255, 255));
        JTextField txtCarPrice = new JTextField(15);
        txtCarPrice.setBackground(new Color(255, 255, 255));

        JButton btnAddCar = new JButton("Add Car");
        btnAddCar.setBackground(new Color(50, 205, 50)); // Dodger blue background
        btnAddCar.setForeground(Color.WHITE);

        DefaultTableModel carTableModel = new DefaultTableModel(
                new Object[]{"Car Name", "Car Type", "Car Brand", "Car Price"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Makes all cells uneditable
            }
        };
        JTable carTable = new JTable(carTableModel);
        carTable.getTableHeader().setResizingAllowed(false); // Prevents column resizing
        carTable.getTableHeader().setReorderingAllowed(false); // Prevents column reordering
        JScrollPane carScrollPane = new JScrollPane(carTable);

        // Setting fixed column widths (optional)
        carTable.getColumnModel().getColumn(0).setPreferredWidth(150); // Car Name
        carTable.getColumnModel().getColumn(1).setPreferredWidth(150); // Car Type
        carTable.getColumnModel().getColumn(2).setPreferredWidth(150); // Car Brand
        carTable.getColumnModel().getColumn(3).setPreferredWidth(100); // Car Price

        JPanel carInputPanel = new JPanel();
        carInputPanel.setBackground(new Color(91, 173, 248)); // Papaya whip background
        carInputPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        carInputPanel.add(new JLabel("Car Name:"));
        carInputPanel.add(txtCarName);
        carInputPanel.add(new JLabel("Car Type:"));
        carInputPanel.add(txtCarType);
        carInputPanel.add(new JLabel("Car Brand:"));
        carInputPanel.add(txtCarBrand);
        carInputPanel.add(new JLabel("Car Price:"));
        carInputPanel.add(txtCarPrice);
        carInputPanel.add(btnAddCar);

        carPanel.add(carInputPanel, BorderLayout.NORTH);
        carPanel.add(carScrollPane, BorderLayout.CENTER);

        tabbedPane.addTab("Customer Management", customerPanel);
        tabbedPane.addTab("Car Management", carPanel);

        frame.add(tabbedPane);
        frame.setVisible(true);
    }
}
