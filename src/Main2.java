import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (!scanner.hasNextLine()) break;
            String line = scanner.nextLine().trim();
            if (line.equalsIgnoreCase("stop")) break;

            int countShelfBooks;
            try {
                countShelfBooks = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                continue;
            }

            if (!scanner.hasNextLine()) break;
            String targetBook = scanner.nextLine();
            if (targetBook.equalsIgnoreCase("stop")) break;

            boolean found = false;
            int checkedBooks = 0;

            while (true) {
                if (checkedBooks >= countShelfBooks) {
                    if (!found) {
                        System.out.println("You did not find " + targetBook);
                    }
                    break;
                }

                if (!scanner.hasNextLine()) {

                    if (!found) {
                        System.out.println("You did not find " + targetBook);
                    }
                    return;
                }

                String current = scanner.nextLine();

                if (current.equalsIgnoreCase("stop")) {
                    return;
                }
                try {
                    int newCount = Integer.parseInt(current.trim());
//                    if (!found) {
//                        System.out.println("You did not find " + targetBook);
//                    }
                    countShelfBooks = newCount;

                    if (!scanner.hasNextLine()) return;
                    targetBook = scanner.nextLine();
                    if (targetBook.equalsIgnoreCase("stop")) return;

                    checkedBooks = 0;
                    found = false;
                    continue;
                } catch (NumberFormatException ignored) {

                }

                checkedBooks++;
                if (current.equals(targetBook)) {
                    System.out.println("Checked " + checkedBooks + " books and found " + targetBook);
                    found = true;
                    break;
                }
            }
        }
    }
}
