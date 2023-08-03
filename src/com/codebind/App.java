package com.codebind;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class App {
    private JPanel panel;
    private JButton btnDisplay;
    private JTextArea textArea1;
    private JButton bubbleSortButton;
    private JButton insertionSortButton;
    private JButton selectionSortButton;
    private JButton mergeSortButton;
    private JButton quickSortButton;
    private JLabel timeBubbleSortLabel;
    private JLabel timeInsertionSortLabel;
    private JLabel timeSelectionSortLabel;
    private JLabel timeMergeSortLabel;
    private JLabel timeQuickSortLabel;

    public App() {
        String[] randomArray = new String[1000];
        btnDisplay.addActionListener(e -> {
            Random random = new Random();
            char[] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

            for (int i = 0; i < 1000; i++) {
                int length = random.nextInt(5) + 1;
                StringBuilder randomElement = new StringBuilder();
                for (int j = 0; j < length; j++) {
                    randomElement.append(alphabet[random.nextInt(alphabet.length)]);
                }
                randomArray[i] = randomElement.toString();
            }

            List<String> randomList = new ArrayList<>(Arrays.asList(randomArray));
            textArea1.setText(randomList.toString());
        });
        bubbleSortButton.addActionListener(e -> {
            long startTime = System.currentTimeMillis();
            sortStrings(randomArray);
            long endTime = System.currentTimeMillis();
            List<String> randomList = new ArrayList<>(Arrays.asList(randomArray));
            NumberFormat formatter = new DecimalFormat("#0.00000");
            timeBubbleSortLabel.setText(formatter.format((endTime - startTime) / 1000d) + " seconds");
            SortScreen sortScreen = new SortScreen();
            sortScreen.pack();
            sortScreen.setDisplaySort(randomList.toString());
            sortScreen.setVisible(true);

        });
        insertionSortButton.addActionListener(e -> {
            long startTime = System.currentTimeMillis();
            insertionSort(randomArray);
            long endTime = System.currentTimeMillis();
            List<String> randomList = new ArrayList<>(Arrays.asList(randomArray));
            NumberFormat formatter = new DecimalFormat("#0.00000");
            timeInsertionSortLabel.setText(formatter.format((endTime - startTime) / 1000d) + " seconds");
            SortScreen sortScreen = new SortScreen();
            sortScreen.pack();
            sortScreen.setDisplaySort(randomList.toString());
            sortScreen.setVisible(true);
        });
        selectionSortButton.addActionListener(e -> {
            long startTime = System.currentTimeMillis();
            selectionSort(randomArray);
            long endTime = System.currentTimeMillis();
            List<String> randomList = new ArrayList<>(Arrays.asList(randomArray));
            NumberFormat formatter = new DecimalFormat("#0.00000");
            timeSelectionSortLabel.setText(formatter.format((endTime - startTime) / 1000d) + " seconds");
            SortScreen sortScreen = new SortScreen();
            sortScreen.pack();
            sortScreen.setDisplaySort(randomList.toString());
            sortScreen.setVisible(true);
        });
        mergeSortButton.addActionListener(e -> {
            long startTime = System.currentTimeMillis();
            mergeSort(randomArray);
            long endTime = System.currentTimeMillis();
            List<String> randomList = new ArrayList<>(Arrays.asList(randomArray));
            NumberFormat formatter = new DecimalFormat("#0.00000");
            timeMergeSortLabel.setText(formatter.format((endTime - startTime) / 1000d) + " seconds");
            SortScreen sortScreen = new SortScreen();
            sortScreen.pack();
            sortScreen.setDisplaySort(randomList.toString());
            sortScreen.setVisible(true);
        });
        quickSortButton.addActionListener(e -> {
            long startTime = System.currentTimeMillis();
            quickSort(randomArray,0,randomArray.length-1);
            long endTime = System.currentTimeMillis();
            List<String> randomList = new ArrayList<>(Arrays.asList(randomArray));
            NumberFormat formatter = new DecimalFormat("#0.00000");
            timeQuickSortLabel.setText(formatter.format((endTime - startTime) / 1000d) + " seconds");
            SortScreen sortScreen = new SortScreen();
            sortScreen.pack();
            sortScreen.setDisplaySort(randomList.toString());
            sortScreen.setVisible(true);
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("App");
        jFrame.setContentPane(new App().panel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public static void sortStrings(String[] arr) {
        int n = arr.length;
        String temp;
        // Sorting strings using bubble sort
        for (int j = 0; j < n - 1; j++) {
            for (int i = j + 1; i < n; i++) {
                if (arr[j].compareTo(arr[i]) > 0) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    public static void insertionSort(String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            String key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void selectionSort(String[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[min]) < 0) {
                    min = j;
                }
            }
            String temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static void mergeSort(String[] arr) {
        if (arr.length <= 1) {
            return;
        }

        int middle = arr.length / 2;
        String[] left = Arrays.copyOfRange(arr, 0, middle);
        String[] right = Arrays.copyOfRange(arr, middle, arr.length);

        mergeSort(left);
        mergeSort(right);

        merge(left, right, arr);
    }

    private static void merge(String[] left, String[] right, String[] arr) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static void quickSort(String[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    private static int partition(String[] arr, int low, int high) {
        String pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        String temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

}
