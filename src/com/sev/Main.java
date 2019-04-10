package com.sev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static ArrayList<Order> ordersList = new ArrayList<>();

    public static void main(String[] args) {
        liveOrder();
    }

    private static void liveOrder() {
        System.out.println("Welcome to the Live Order Board!");
        System.out.println("What would you like to do? Type 'view' to see orders list or 'add' to create an order.");
        isViewOrAdd();
    }

    private static void viewOrder() {
        System.out.println("These are our live orders.");
        System.out.println(ordersList.get(0).getType());
        liveOrder();
    }

    private static void enterOrder() {
        System.out.println("Please enter a new order:");
        System.out.println("Type 'quit' to return to the Live Oder Board");
        Scanner scan = new Scanner(System.in);
        System.out.println("User ID? This is any integer number.");
        int userId = Integer.parseInt(scan.nextLine());
        System.out.println("Order quantity? This is any integer number.");
        int quantity = Integer.parseInt(scan.nextLine());
        System.out.println("Price?");
        double price = Double.parseDouble(scan.nextLine());
        System.out.println("Order type? It should be either BUY or SELL");
        String type = scan.nextLine();
        addOrder(new Order(userId, quantity, price, type));
        isYesOrNo();
    }

    private static void addOrder(Order order) {
        ordersList.add(order);
    }

    private static void removeOrder() {

    }

    private static void isYesOrNo() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Thanks! Add another order? Yes/No");
        String yesOrNo = scan.nextLine();
        if (yesOrNo.toLowerCase().equals("yes")) {
            enterOrder();
        } else if (yesOrNo.toLowerCase().equals("no")){
            liveOrder();
        } else {
            System.out.println("There is something not right! Try again. Yes or No?");
            isYesOrNo();
        }
    }

    private static void isViewOrAdd() {
        Scanner scan = new Scanner(System.in);
        String viewOrAdd = scan.nextLine();
        if (viewOrAdd.toLowerCase().equals("view")) {
            viewOrder();
        } else if (viewOrAdd.toLowerCase().equals("add")){
            enterOrder();
        } else {
            System.out.println("There is something not right! Try again. View or Add?");
            isViewOrAdd();
        }
    }
}
