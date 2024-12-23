package Controller;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class PaymentButtonRenderer extends JButton implements TableCellRenderer {
    public PaymentButtonRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText("Pay");
        return this;
    }
}
