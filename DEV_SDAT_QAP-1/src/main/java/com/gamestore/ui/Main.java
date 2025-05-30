package com.gamestore.ui;

import com.gamestore.domain.Game;
import com.gamestore.service.Cart;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart();

        List<Game> availableGames = Arrays.asList(
                new Game("Cyberpunk 2077", 59.99),
                new Game("God of War", 49.99),
                new Game("Minecraft", 29.99),
                new Game("Halo", 39.99)
        );

        while (true) {
            System.out.println("\n GAME STORE MENU ");
            System.out.println("1. View Available Games");
            System.out.println("2. Add Game to Cart");
            System.out.println("3. View Cart Total");
            System.out.println("4. Purchase");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("\n Available Games:");
                    for (int i = 0; i < availableGames.size(); i++) {
                        Game game = availableGames.get(i);
                        System.out.printf("%d. %s - $%.2f\n", i + 1, game.getName(), game.getPrice());
                    }
                    break;

                case 2:
                    System.out.print("Enter game number to add to cart: ");
                    int gameNumber = scanner.nextInt();
                    if (gameNumber >= 1 && gameNumber <= availableGames.size()) {
                        cart.addGame(availableGames.get(gameNumber - 1));
                        System.out.println(" Game added to cart!");
                    } else {
                        System.out.println(" Invalid game number.");
                    }
                    break;

                case 3:
                    System.out.printf(" Cart Total: $%.2f\n", cart.calculateTotal());
                    break;


                    case 4:
                    if (cart.isEmpty()) {
                        System.out.println(" Your cart is empty. Please add games before checking out.");
                    } else {
                        //  Show cart summary
                        System.out.println("\n Purchase Summary:");
                        for (Game g : cart.getGames()) {
                            System.out.printf("- %s: $%.2f\n", g.getName(), g.getPrice());
                        }
                
                        //  Show total
                        double total = cart.calculateTotal();
                        System.out.printf(" Total: $%.2f\n", total);
                
                        //  Ask for confirmation
                        System.out.print(" Proceed to purchase? (yes/no): ");
                        String confirm = scanner.nextLine().trim().toLowerCase();
                
                        if (confirm.equals("yes")) {
                            //  Simulate payment processing
                            System.out.println(" Processing payment...");
                            try {
                                Thread.sleep(1000); // simulate delay
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                
                            // Step 5: Clear the cart and thank user
                            cart.clear();
                            System.out.println(" Thank you for your purchase! A receipt has been sent to your email.");
                        } else {
                            System.out.println(" Purchase canceled. Your cart is still available.");
                        }
                    }
                    break;
                
                case 0:
                    System.out.println(" Thanks for visiting the Game Store!");
                    return;

                default:
                    System.out.println("️ Invalid choice. Please try again.");
            }
        }
    }
}
