package Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.NumberFormat;
import java.util.Locale;

public class PaymentButtonEditor extends DefaultCellEditor {
    private JButton button;
    private boolean isClicked;
    private JFrame frame;
    private DefaultTableModel tableModel;
    private int row;

    public PaymentButtonEditor(JTextField textField, JFrame frame, DefaultTableModel tableModel) {
        super(textField);
        this.frame = frame;
        this.tableModel = tableModel;
        button = new JButton("Pay");
        button.setOpaque(true);

        button.addActionListener(e -> {
            if (isClicked) {
                String paymentAmount = JOptionPane.showInputDialog(frame, "Enter payment amount:", "Payment", JOptionPane.PLAIN_MESSAGE);
                if (paymentAmount != null && !paymentAmount.isEmpty()) {
                    try {
                        double amount = Double.parseDouble(paymentAmount);
                        String carPriceString = tableModel.getValueAt(row, 3).toString();
                        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
                        Number carPriceNumber = currencyFormat.parse(carPriceString);
                        double carPrice = carPriceNumber.doubleValue();

                        if (amount >= carPrice) {
                            double change = amount - carPrice;
                            if (change > 0) {
                                JOptionPane.showMessageDialog(frame, "Payment received. Change: Rp" + currencyFormat.format(change), "Payment Successful", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(frame, "Payment received. Thank you!", "Payment Successful", JOptionPane.INFORMATION_MESSAGE);
                            }
                            tableModel.setValueAt("Paid", row, 4);
                        } else {
                            JOptionPane.showMessageDialog(frame, "Payment insufficient. Amount due: Rp" + currencyFormat.format(carPrice - amount), "Payment Error", JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "Error processing payment: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.row = row;
        isClicked = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        isClicked = false;
        return "Pay";
    }
}
