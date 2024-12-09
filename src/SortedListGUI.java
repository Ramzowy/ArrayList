import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortedListGUI extends JFrame {
    private SortedList sortedList;
    private JTextField inputField, searchField;
    private JTextArea listArea;
    private JButton addButton, searchButton;

    public SortedListGUI() {
        super("Sorted List (Binary Search)");

        sortedList = new SortedList();

        // Create GUI components
        inputField = new JTextField(20);
        searchField = new JTextField(20);
        listArea = new JTextArea(15, 30);
        listArea.setEditable(false);

        addButton = new JButton("Add");
        searchButton = new JButton("Search");

        // Layout components
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Add to list:"));
        inputPanel.add(inputField);
        inputPanel.add(addButton);

        JPanel searchPanel = new JPanel();
        searchPanel.add(new JLabel("Search:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(listArea), BorderLayout.CENTER);
        mainPanel.add(searchPanel, BorderLayout.SOUTH);

        add(mainPanel);

        // Add action listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStringToList();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchStringInList();
            }
        });

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void addStringToList() {
        String value = inputField.getText();
        if (!value.isEmpty()) {
            sortedList.insert(value);
            listArea.setText(sortedList.getListAsString());
            inputField.setText("");
        }
    }

    private void searchStringInList() {
        String value = searchField.getText();
        if (!value.isEmpty()) {
            int index = sortedList.search(value);
            if (index < sortedList.list.size() && sortedList.list.get(index).equals(value)) {
                JOptionPane.showMessageDialog(this, "Found: " + value + " at index " + index);
            } else {
                JOptionPane.showMessageDialog(this, value + " not found. It would be at position " + index);
            }
        }
    }

    public static void main(String[] args) {
        SortedListGUI GUI = new SortedListGUI();
    }
}

