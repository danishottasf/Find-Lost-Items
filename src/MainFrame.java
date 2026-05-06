package com.lostfound.ui;

import com.lostfound.dto.Item;
import com.lostfound.service.ItemService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainFrame extends JFrame {

    private JTextField nameField, locationField;
    private JTextArea descArea;
    private JTable table;
    private DefaultTableModel model;

    private ItemService service = new ItemService();

    public MainFrame() {

        setTitle("Lost & Found Registry");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        panel.add(new JLabel("Item Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Description:"));
        descArea = new JTextArea(3, 20);
        panel.add(new JScrollPane(descArea));

        panel.add(new JLabel("Location:"));
        locationField = new JTextField();
        panel.add(locationField);

        JButton addBtn = new JButton("Add Item");
        panel.add(addBtn);

        add(panel, BorderLayout.NORTH);

        model = new DefaultTableModel(
                new String[]{"ID", "Name", "Location", "Status"}, 0);

        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        addBtn.addActionListener(e -> {
            service.reportItem(new Item(
                    nameField.getText(),
                    descArea.getText(),
                    locationField.getText(),
                    "LOST"
            ));
            loadData();
        });

        loadData();
    }

    private void loadData() {
        model.setRowCount(0);

        for (Item i : service.viewItems()) {
            model.addRow(new Object[]{
                    i.getId(),
                    i.getItemName(),
                    i.getLocation(),
                    i.getStatus()
            });
        }
    }
}