package com.sev;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static List<Order> ordersList = new ArrayList<>();
    private static List<Order> buyOrdersList = new ArrayList<>();
    private static List<Order> sellOrdersList = new ArrayList<>();

    public static List<Order> getOrdersList() {
        return ordersList;
    }

    public static void setOrdersList(List<Order> ordersList) {
        Main.ordersList = ordersList;
    }

    public static List<Order> getBuyOrdersList() {
        return buyOrdersList;
    }

    public static void setBuyOrdersList(List<Order> buyOrdersList) {
        Main.buyOrdersList = buyOrdersList;
    }

    public static List<Order> getSellOrdersList() {
        return sellOrdersList;
    }

    public static void setSellOrdersList(List<Order> sellOrdersList) {
        Main.sellOrdersList = sellOrdersList;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Live Order Board!");
        liveOrder();
    }

    private static void liveOrder() {
        System.out.println("What would you like to do? Type 'view' to see orders list,'add' to create an order or 'remove' to remove an order.");
        isViewOr();
    }

    private static void viewOrder() {
        System.out.println("These are our live orders.");
        System.out.println("Would you like to view All, Buy or Sell orders?");
        isViewBuyOrSell();
    }

    private static void enterOrder() {
        System.out.println("Please enter a new order:");
        System.out.println("Type 'quit' to return to the Live Oder Board");
        Scanner scan = new Scanner(System.in);
        System.out.println("User ID? This is any integer number.");
        int userId = Integer.parseInt(scan.nextLine());
        System.out.println("Order quantity? This is any integer number.");
        int quantity = Integer.parseInt(scan.nextLine());
        System.out.println("Price? For example: 29.95");
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
        Scanner scan = new Scanner(System.in);
        System.out.println("Which order ID to remove?");
        int index = Integer.parseInt(scan.nextLine());
        ordersList.remove(index);
        System.out.println("Order removed!");
        liveOrder();
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

    private static void isViewOr() {
        Scanner scan = new Scanner(System.in);
        String viewOrAdd = scan.nextLine();
        if (viewOrAdd.toLowerCase().equals("view")) {
            viewOrder();
        } else if (viewOrAdd.toLowerCase().equals("add")){
            enterOrder();
        } else if (viewOrAdd.toLowerCase().equals("remove")){
            removeOrder();
        } else {
            System.out.println("There is something not right! Try again. View or Add?");
            isViewOr();
        }
    }

    private static void isViewBuyOrSell() {
        Scanner scan = new Scanner(System.in);
        String viewBuyOrSell = scan.nextLine();
        if (viewBuyOrSell.toLowerCase().equals("buy")) {
            printBuyOrders();
        } else if (viewBuyOrSell.toLowerCase().equals("sell")){
            printSellOrders();
        } else if (viewBuyOrSell.toLowerCase().equals("all")){
            printAllOrders(ordersList);
        } else {
            System.out.println("There is something not right! Try again. View Buy or Sell orders?");
            isViewBuyOrSell();
        }
    }

    private static void printSellOrders() {
        sellOrdersList = ordersList.stream()
            .filter(el-> "sell".equals((el.getType()).toLowerCase()))
            .sorted(Comparator.comparingDouble(Order::getPrice))
            .collect(Collectors.toList());
        printOrders(sellOrdersList);
    }

    private static void printBuyOrders() {
        buyOrdersList = ordersList.stream()
            .filter(el-> "buy".equals((el.getType()).toLowerCase()))
            .sorted(Comparator.comparingDouble(Order::getPrice).reversed())
            .collect(Collectors.toList());
        printOrders(buyOrdersList);
    }

    private static void printOrders(List<Order> list) {
        list.forEach(el-> System.out.println(el.getQuantity() + " kg for £" + el.getPrice()));
        liveOrder();
    }

    private static void printAllOrders(List<Order> list) {
        list.forEach(el->
            System.out.println("OrderID: " + list.indexOf(el) + " - " + el.getType().toUpperCase() + ": " + el.getQuantity() + " kg for £" + el.getPrice() + " [" + el.getUserId() + "]")
        );
        liveOrder();
    }
}
