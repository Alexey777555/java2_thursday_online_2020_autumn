package lesson_3.user_interface.product_menu.add_product_menu;

import lombok.Getter;

import java.util.Scanner;

public class AddProductDescription {
    @Getter
    private String userProductDescriptionInput;

    public void showMenuDescription() {
        System.out.println("Enter product Description:");
        userProductDescriptionInput = new Scanner(System.in).nextLine();
    }
}