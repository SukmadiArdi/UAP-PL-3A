package Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class AddCarController implements ActionListener {
    private JTextField txtCarName;
    private JTextField txtCarType;
    private JTextField txtCarBrand;
    private JTextField txtCarPrice;
    private JTable table;
    private DefaultTableModel tableModel;
    private JFrame frame;
    private ArrayList<Car> carList;
    private JComboBox<Car> carComboBox;

    public static class Car {
        public String name;
        public String type;
        public String brand;
        public Long price;

        public Car(String name, String type, String brand, Long price) {
            this.name = name;
            this.type = type;
            this.brand = brand;
            this.price = price;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public AddCarController(JTextField txtCarName, JTextField txtCarType, JTextField txtCarBrand, JTextField txtCarPrice, JTable table, DefaultTableModel tableModel, JFrame frame, JComboBox<Car> carComboBox) {
        this.txtCarName = txtCarName;
        this.txtCarType = txtCarType;
        this.txtCarBrand = txtCarBrand;
        this.txtCarPrice = txtCarPrice;
        this.table = table;
        this.tableModel = tableModel;
        this.frame = frame;
        this.carList = new ArrayList<>();
        this.carComboBox = carComboBox;
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        String name = txtCarName.getText().trim();
        String type = txtCarType.getText().trim();
        String brand = txtCarBrand.getText().trim();
        String priceText = txtCarPrice.getText().trim();

        if (name.isEmpty() || type.isEmpty() || brand.isEmpty() || priceText.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Harap isi semua field!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                Long price = Long.parseLong(priceText);
                NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
                String formattedPrice = currencyFormat.format(price);

                Car newCar = new Car(name, type, brand, price);
                carList.add(newCar);

                tableModel.addRow(new Object[]{name, type, brand, formattedPrice});
                txtCarName.setText("");
                txtCarType.setText("");
                txtCarBrand.setText("");
                txtCarPrice.setText("");

                updateCarComboBox();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Harga tidak valid!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void updateCarComboBox() {
        carComboBox.removeAllItems();
        for (Car car : carList) {
            carComboBox.addItem(car);
        }
    }

    public ArrayList<Car> getCarList() {
        return carList;
    }
}
