package Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;

public class AddCustomerController implements ActionListener {
    private JTextField txtCustomerName;
    private JComboBox<AddCarController.Car> carComboBox;
    private JTable table;
    private DefaultTableModel tableModel;
    private JFrame frame;

    public AddCustomerController(JTextField txtCustomerName, JComboBox<AddCarController.Car> carComboBox, JTable table, DefaultTableModel tableModel, JFrame frame) {
        this.txtCustomerName = txtCustomerName;
        this.carComboBox = carComboBox;
        this.table = table;
        this.tableModel = tableModel;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        String customerName = txtCustomerName.getText().trim();
        AddCarController.Car selectedCar = (AddCarController.Car) carComboBox.getSelectedItem();

        if (customerName.isEmpty() || selectedCar == null) {
            JOptionPane.showMessageDialog(frame, "Harap isi semua field!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else {
            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
            String formattedPrice = currencyFormat.format(selectedCar.price);

            tableModel.addRow(new Object[]{customerName, selectedCar.name, selectedCar.type, formattedPrice, "Pending", "Pay"});
            txtCustomerName.setText("");
        }
    }
}
