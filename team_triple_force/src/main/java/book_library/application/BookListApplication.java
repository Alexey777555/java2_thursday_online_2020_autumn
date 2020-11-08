package book_library.application;

import java.util.Scanner;

public class BookListApplication {

    private static final ElectronicLibrary electronicLibrary = new ElectronicLibraryImpl();

    private static final UICommand addBookUICommand = new AddBookUICommand(electronicLibrary);
    private static final UICommand deleteBookByTitleUICommand = new DeleteBookByTitleUICommand(electronicLibrary);
    private static final UICommand deleteBookByAuthorUICommand = new DeleteBookByAuthorUICommand(electronicLibrary);
    private static final UICommand deleteBookByIdUICommand = new DeleteBookByIdUICommand(electronicLibrary);
    private static final UICommand printAllBooksUICommand = new PrintAllBooksUICommand(electronicLibrary);
    private static final UICommand exitUICommand = new ExitUICommand();

    public static void main(String[] args) {
        do {
            applicationMenu();
            int menuValue = getMenuNumberFromUser();
            selectedMenu(menuValue);
        } while (true);
    }

    private static void applicationMenu() {
        System.out.println("\n================================================");
        System.out.println("  ELECTRONIC LIBRARY PROGRAM FUNCTIONAL MENU:");
        System.out.println("================================================");
        System.out.println("1. Add book to electronic library");
        System.out.println("2. Delete book from electronic library by title");
        System.out.println("3. Delete book from electronic library by author");
        System.out.println("4. Delete book from electronic library by Id");
        System.out.println("5. Print all books in electronic library");
        System.out.println("9. Exit program menu");
        System.out.println("================================================");
    }

    private static int getMenuNumberFromUser() {
        System.out.println("Please enter menu item number:");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    private static void selectedMenu(int menuValue) {
        switch (menuValue) {
            case 1: {
                addBookUICommand.execute();
                break;
            }
            case 2: {
                deleteBookByTitleUICommand.execute();
                break;
            }
            case 3: {
                deleteBookByAuthorUICommand.execute();
                break;
            }
            case 4: {
                deleteBookByIdUICommand.execute();
                break;
            }
            case 5: {
                printAllBooksUICommand.execute();
                break;
            }
            case 9: {
                exitUICommand.execute();
                break;
            }
        }
    }
}


