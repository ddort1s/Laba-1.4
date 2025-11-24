import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("stop")) {
                break;
            }

            int countShelfBooks;
            try {
                countShelfBooks = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                continue;
            }
            
            String targetBook = scanner.nextLine();

            if (targetBook.equalsIgnoreCase("stop")) {
                System.out.println("You checked 0 books and did not find " + targetBook);
                break;
            }

            boolean found = false;
            int checkedBooks = 0;

            for (int i = 0; i < countShelfBooks; i++) {
                if (!scanner.hasNextLine()) {

                    System.out.println("You checked " + checkedBooks + " books and did not find " + targetBook);
                    return;
                }

                String currentInput = scanner.nextLine();

                if (currentInput.equalsIgnoreCase("stop")) {
                    System.out.println("You checked " + checkedBooks + " books and did not find " + targetBook);
                    return;
                }

                try {
                    Integer.parseInt(currentInput);

                    System.out.println("You checked " + checkedBooks + " books and did not find " + targetBook);

                    countShelfBooks = Integer.parseInt(currentInput);

                    if (!scanner.hasNextLine()) {
                        return;
                    }
                    targetBook = scanner.nextLine().trim();

                    if (targetBook.equalsIgnoreCase("stop")) {
                        System.out.println("You checked 0 books and did not find " + targetBook);
                        return;
                    }

                    found = false;
                    checkedBooks = 0;
                    i = -1;
                } catch (NumberFormatException e) {
                    checkedBooks++;

                    if (currentInput.equals(targetBook)) {
                        System.out.println("Checked " + checkedBooks + " books and found " + targetBook);
                        found = true;
                        break;
                    }
                }
            }

            if (!found && checkedBooks == countShelfBooks) {
                System.out.println("You did not find " + targetBook);
            }
        }
    }
}
