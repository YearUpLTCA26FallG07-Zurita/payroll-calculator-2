package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.Buffer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        try {
            BufferedReader bufReader = new BufferedReader(new FileReader("employees.csv"));

            bufReader.readLine();

            String input;

            String[] employees = null;
            while ((input = bufReader.readLine()) != null) {
                employees = input.split("\\|");
                int employeeId = Integer.parseInt(employees[0]);
                String name = employees[1];
                double hoursWorked = Double.parseDouble(employees[2]);
                double payRate = Double.parseDouble(employees[3]);
                Employee employee = new Employee(employeeId, name, hoursWorked, payRate);
                System.out.printf("ID |%d| %s worked %.2f hours and makes $%.2f an hour. Gross payout is $%.2f.%n", employee.getEmployeeId(), employee.getName(), employee.getHoursWorked(), employee.getPayRate(), (employee.getHoursWorked() * employee.getPayRate()));
            }


        } catch (Exception e) {
            System.out.println("There was an error.");
        }
    }
}