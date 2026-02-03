package com.lostfound.main;

import com.lostfound.dto.Item;
import com.lostfound.service.ItemService;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        ItemService service = new ItemService();
        Scanner sc = new Scanner(System.in);

        while (true) {
        	System.out.println("1. Report Lost Item");
        	System.out.println("2. Report Found Item");
        	System.out.println("3. View All Items");
        	System.out.println("4. Claim Item");
        	System.out.println("5. Delete Item");
        	System.out.println("6. Exit");
        	System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

            case 1: // Report LOST
                sc.nextLine();
                System.out.print("Item Name: ");
                String lostName = sc.nextLine();
                System.out.print("Description: ");
                String lostDesc = sc.nextLine();
                System.out.print("Location: ");
                String lostLoc = sc.nextLine();

                service.reportItem(new Item(lostName, lostDesc, lostLoc, "LOST"));
                System.out.println("Lost item reported successfully.");
                break;

            case 2: // Report FOUND
                sc.nextLine();
                System.out.print("Item Name: ");
                String foundName = sc.nextLine();
                System.out.print("Description: ");
                String foundDesc = sc.nextLine();
                System.out.print("Location: ");
                String foundLoc = sc.nextLine();

                service.reportItem(new Item(foundName, foundDesc, foundLoc, "FOUND"));
                System.out.println("Found item reported successfully.");
                break;

            case 3: // View all
                service.viewItems().forEach(i ->
                    System.out.println(
                        i.getId() + " | " +
                        i.getItemName() + " | " +
                        i.getDescription() + " | " +
                        i.getLocation() + " | " +
                        i.getStatus()
                    )
                );
                break;

            case 4: // Claim
                System.out.print("Enter Item ID to claim: ");
                int id = sc.nextInt();
                service.claimItem(id);
                break;

            case 5: // Delete
                System.out.print("Enter Item ID to delete: ");
                int delId = sc.nextInt();
                service.removeItem(delId);
                break;

            case 6:
                System.out.println("Exiting system.");
                sc.close();
                System.exit(0);

            default:
                System.out.println("Invalid choice.");
        }
        }
    }
}
