package com.codebind;

import javax.swing.*;
import java.awt.event.*;

public class SortScreen extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextArea displaySort;


    public void setDisplaySort(String display) {
        displaySort.setText(display);
    }

    public SortScreen() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }


    public static void main(String[] args) {
        SortScreen dialog = new SortScreen();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
