package texteditor; //package to organize code

import javax.swing.*; //for GUI components 
import java.awt.*;    //for layout and color
import java.awt.event.*; //for handling actions 
import java.io.*;       //for file reading/writing
import javax.swing.undo.*; //for undo/redo support

public class SimpleTextEditor extends JFrame implements ActionListener {
    
    JTextArea textBox;
    JScrollPane scroll; //to add scroll bars to text area

    //menu items for File menu
    JMenuItem newFile, openFile, saveFile, printFile, exitFile;
    
    //menu items for Edit menu
    JMenuItem cutText, copyText, pasteText, undoText, redoText, findText, clearText;
    
    //menu items for Format menu
    JMenuItem upperCase, lowerCase, changeFontSize, switchTheme;
    
    //menu item for Tools menu
    JMenuItem countWords;

    //status label to show messages at bottom
    JLabel status;

    //file chooser dialog to open/save files
    JFileChooser fileChooser;

    //current file being edited (null if new file)
    File currentFile = null;

    //undo manager to handle undo/redo functionality
    UndoManager undoManager;

    //constructor - this runs when program starts and sets up GUI
    public SimpleTextEditor() {
        
        //set window title
        setTitle("Untitled - MyTextEditor");
        
        //set window size
        setSize(600, 500);
        
        //override default close operation to confirm exit
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
        
                //ask user before closing the window
                int result = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION){
                    System.exit(0); // exit program
                }
            }
        });

        //create text area and add to scroll pane
        textBox = new JTextArea();
        scroll = new JScrollPane(textBox);
        add(scroll); //add scroll pane to JFrame

        //create UndoManager and connect it to textBox's document
        undoManager = new UndoManager();
        textBox.getDocument().addUndoableEditListener(undoManager);

        //create menu bar
        JMenuBar menuBar = new JMenuBar();

        //file menu and its items
        JMenu menu1 = new JMenu("File");
        newFile = new JMenuItem("New");
        openFile = new JMenuItem("Open");
        saveFile = new JMenuItem("Save");
        printFile = new JMenuItem("Print");
        exitFile = new JMenuItem("Exit");
        menu1.add(newFile);
        menu1.add(openFile);
        menu1.add(saveFile);
        menu1.add(printFile);
        menu1.add(exitFile);

        //edit menu and its items
        JMenu menu2 = new JMenu("Edit");
        cutText = new JMenuItem("Cut");
        copyText = new JMenuItem("Copy");
        pasteText = new JMenuItem("Paste");
        undoText = new JMenuItem("Undo");
        redoText = new JMenuItem("Redo");
        findText = new JMenuItem("Find");
        clearText = new JMenuItem("Clear");
        menu2.add(cutText);
        menu2.add(copyText);
        menu2.add(pasteText);
        menu2.add(undoText);
        menu2.add(redoText);
        menu2.add(findText);
        menu2.add(clearText);

        // Format menu and its items
        JMenu menu3 = new JMenu("Format");
        upperCase = new JMenuItem("To Uppercase");
        lowerCase = new JMenuItem("To Lowercase");
        changeFontSize = new JMenuItem("Font Size");
        switchTheme = new JMenuItem("Switch Dark/Light");
        menu3.add(upperCase);
        menu3.add(lowerCase);
        menu3.add(changeFontSize);
        menu3.add(switchTheme);

        // Tools menu and its item
        JMenu menu4 = new JMenu("Tools");
        countWords = new JMenuItem("Word & Character Count");
        menu4.add(countWords);

        //add all menus to menu bar
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        menuBar.add(menu4);

        //set menu bar on JFrame
        setJMenuBar(menuBar);

        //add action listeners for all menu items
        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
        printFile.addActionListener(this);
        exitFile.addActionListener(this);
        cutText.addActionListener(this);
        copyText.addActionListener(this);
        pasteText.addActionListener(this);
        undoText.addActionListener(this);
        redoText.addActionListener(this);
        findText.addActionListener(this);
        clearText.addActionListener(this);
        upperCase.addActionListener(this);
        lowerCase.addActionListener(this);
        changeFontSize.addActionListener(this);
        switchTheme.addActionListener(this);
        countWords.addActionListener(this);

        //label at bottom to show status messages
        status = new JLabel("Welcome to MyTextEditor");
        add(status, BorderLayout.SOUTH);

        //create file chooser dialog
        fileChooser = new JFileChooser();

        //show window
        setVisible(true);
    }

    //this method runs when any menu item is clicked
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if(src == newFile) {
            
            //clear text area and reset title for new file
            textBox.setText("");
            setTitle("Untitled - MyTextEditor");
            currentFile = null;
            status.setText("New file created");
        } 
        else if (src == openFile) {
            //show open dialog to choose a file
            int op = fileChooser.showOpenDialog(this);
            if (op == JFileChooser.APPROVE_OPTION) {
                currentFile = fileChooser.getSelectedFile();
                try (BufferedReader reader = new BufferedReader(new FileReader(currentFile))) {
                    textBox.setText(""); // clear current text
                    String line;
                    while ((line = reader.readLine()) != null) {
                        textBox.append(line + "\n"); // read file line by line
                    }
                    setTitle(currentFile.getName() + " - MyTextEditor");
                    status.setText("Opened: " + currentFile.getName());
                } 
                catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Can't open file");
                }
            }
        } 
        else if(src == saveFile) {
            //save file dialog if new file, else save current file
            if(currentFile == null) {
                int op = fileChooser.showSaveDialog(this);
                if (op == JFileChooser.APPROVE_OPTION) {
                    currentFile = fileChooser.getSelectedFile();
                }
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(currentFile))) {
                writer.write(textBox.getText());
                setTitle(currentFile.getName() + " - MyTextEditor");
                status.setText("Saved: " + currentFile.getName());
            } 
            catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Can't save file");
            }
        } 
        else if (src == printFile) {
            // Print text area content
            try{
                textBox.print();
                status.setText("Printing...");
            } 
            catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Can't print");
            }
        } 
        else if (src == exitFile) {
            // Confirm before exiting
            int confirm = JOptionPane.showConfirmDialog(this, "Exit editor?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        } 
        else if (src == cutText) {
            // Cut selected text
            textBox.cut();
            status.setText("Cut text");
        } 
        else if (src == copyText) {
            // Copy selected text
            textBox.copy();
            status.setText("Copied text");
        } 
        else if (src == pasteText) {
            // Paste from clipboard
            textBox.paste();
            status.setText("Pasted text");
        } 
        else if (src == undoText) {
            // Undo last action if possible
            if (undoManager.canUndo()) {
                undoManager.undo();
                status.setText("Undo");
            }
        }
        else if (src == redoText) {
            //redo last undone action if possible
            if (undoManager.canRedo()) {
                undoManager.redo();
                status.setText("Redo");
            }
        } 
        else if (src == findText) {
            //find text input dialog
            String findStr = JOptionPane.showInputDialog(this, "Find:");
            if (findStr != null && !findStr.isEmpty()) {
                String content = textBox.getText();
                int idx = content.indexOf(findStr);
                if (idx != -1) {
                    //select found text
                    textBox.setCaretPosition(idx);
                    textBox.select(idx, idx + findStr.length());
                    status.setText("Found text at position " + idx);
                } 
                else {
                    JOptionPane.showMessageDialog(this, "Not found");
                    status.setText("Text not found");
                }
            }
        } 
        else if (src == clearText) {
            // Clear all text
            textBox.setText("");
            status.setText("Text cleared");
        } 
        else if (src == upperCase) {
            // convert all text to uppercase
            textBox.setText(textBox.getText().toUpperCase());
            status.setText("Converted to uppercase");
        } 
        else if (src == lowerCase) {
            // Convert all text to lowercase
            textBox.setText(textBox.getText().toLowerCase());
            status.setText("Converted to lowercase");
        } 
        else if (src == switchTheme) {
            //switch between dark and light theme
            Color bg = textBox.getBackground();
            if (bg.equals(Color.WHITE)) {
                textBox.setBackground(Color.BLACK);
                textBox.setForeground(Color.GREEN);
                status.setText("Switched to dark theme");
            }
            else {
                textBox.setBackground(Color.WHITE);
                textBox.setForeground(Color.BLACK);
                status.setText("Switched to light theme");
            }
        } 
        else if (src == countWords) {
            //count words and characters in text
            String data = textBox.getText();
            int wordCount = data.trim().isEmpty() ? 0 : data.trim().split("\\s+").length;
            int charCount = data.length();
            JOptionPane.showMessageDialog(this, "Words: " + wordCount + ", Characters: " + charCount);
            status.setText("Counted words and characters");
        } 
        else if (src == changeFontSize) {
            //Ask user for new font size and change font
            String input = JOptionPane.showInputDialog(this, "Enter font size:");
            try {
                int size = Integer.parseInt(input);
                textBox.setFont(new Font("Arial", Font.PLAIN, size));
                status.setText("Font size changed to " + size);
            } 
            catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid number");
            }
        }
    }

    //main method to start the program
    public static void main(String[] args) {
        new SimpleTextEditor(); //create instance of editor and show window
    }
}
