/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.finalsrequirement;

/**
 *
 * @author Owner
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FinalsRequirement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter comma-separated values for Column D:");
        String input = sc.nextLine();

        try {
            List<Integer> columnDValues = validateAndParseInput(input);

            removeSignedValues(columnDValues);

            bubbleSort(columnDValues);

            System.out.println("Sorted and processed values: " + columnDValues);

            // Ask the user to run again or exit
            System.out.println("\nDo you want to run again? (yes/no)");
            String runAgain = sc.nextLine().toLowerCase();

            if ("yes".equals(runAgain)) {
                main(args);
            } else {
                System.out.println("Program exited.");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
            main(args);
        }
    }

    private static List<Integer> validateAndParseInput(String input) {
        List<Integer> columnD = new ArrayList<>();

        String[] values = input.split(",");

        for (String value : values) {
            try {
                if (!value.matches("\\d+")) {
                    throw new IllegalArgumentException("Invalid input: Non-integer value or missing comma.");
                }

                columnD.add(Integer.parseInt(value));

            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid input: Non-integer value detected.");
            }
        }

        return columnD;
    }

    private static void removeSignedValues(List<Integer> columnDValues) {
        columnDValues.removeIf(value -> value < 0);
    }

    private static void bubbleSort(List<Integer> columnDValues) {
        int n = columnDValues.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (columnDValues.get(j) > columnDValues.get(j + 1)) {
                Collections.swap(columnDValues, j, j + 1);
                }
            }
        }
    }
}