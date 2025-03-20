import java.util.*;

class WaterJugBFSMenuDriven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter capacity of Jug1: ");
        int m = scanner.nextInt();
        System.out.println("Enter capacity of Jug2: ");
        int n = scanner.nextInt();
        System.out.println("Enter target amount to measure: ");
        int d = scanner.nextInt();

        if (d > Math.max(m, n) || d % gcd(m, n) != 0) {
            System.out.println("The target cannot be achieved with the given jug capacities.");
            return;
        }

        int jug1 = 0, jug2 = 0;

        System.out.println("\nLet's start the game!");
        System.out.println("You need to measure exactly " + d + " liters.\n");

        while (jug1 != d && jug2 != d) {
            System.out.println("\nCurrent State: Jug1 = " + jug1 + ", Jug2 = " + jug2);
            System.out.println("Choose an action:");
            System.out.println("1. Fill Jug1");
            System.out.println("2. Fill Jug2");
            System.out.println("3. Empty Jug1");
            System.out.println("4. Empty Jug2");
            System.out.println("5. Pour Jug1 into Jug2");
            System.out.println("6. Pour Jug2 into Jug1");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (jug1 == m) {
                        System.out.println("Jug1 is already full.");
                    } else {
                        jug1 = m;
                        System.out.println("Filled Jug1 to " + m + " liters.");
                    }
                    break;
                case 2:
                    if (jug2 == n) {
                        System.out.println("Jug2 is already full.");
                    } else {
                        jug2 = n;
                        System.out.println("Filled Jug2 to " + n + " liters.");
                    }
                    break;
                case 3:
                    if (jug1 == 0) {
                        System.out.println("Jug1 is already empty.");
                    } else {
                        jug1 = 0;
                        System.out.println("Emptied Jug1.");
                    }
                    break;
                case 4:
                    if (jug2 == 0) {
                        System.out.println("Jug2 is already empty.");
                    } else {
                        jug2 = 0;
                        System.out.println("Emptied Jug2.");
                    }
                    break;
                case 5:
                    if (jug1 == 0) {
                        System.out.println("Jug1 is empty, nothing to pour.");
                    } else if (jug2 == n) {
                        System.out.println("Jug2 is already full, cannot pour from Jug1.");
                    } else {
                        int pour1to2 = Math.min(jug1, n - jug2);
                        jug1 -= pour1to2;
                        jug2 += pour1to2;
                        System.out.println("Poured " + pour1to2 + " liters from Jug1 to Jug2.");
                    }
                    break;
                case 6:
                    if (jug2 == 0) {
                        System.out.println("Jug2 is empty, nothing to pour.");
                    } else if (jug1 == m) {
                        System.out.println("Jug1 is already full, cannot pour from Jug2.");
                    } else {
                        int pour2to1 = Math.min(jug2, m - jug1);
                        jug2 -= pour2to1;
                        jug1 += pour2to1;
                        System.out.println("Poured " + pour2to1 + " liters from Jug2 to Jug1.");
                    }
                    break;
                case 7:
                    System.out.println("Exiting the game. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("\nSuccess! The target amount has been measured.");
        System.out.println("Final State: Jug1 = " + jug1 + ", Jug2 = " + jug2);
        scanner.close();
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
