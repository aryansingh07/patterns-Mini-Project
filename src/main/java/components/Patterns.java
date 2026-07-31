package components;

public class Patterns {

    private static void validateRows(int n) {
        if (n <= 0) throw new IllegalArgumentException("Rows must be positive.");
    }
    public static void pattern1(int n) {
        validateRows(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void pattern2(int n) {
        validateRows(n);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void pattern5(int n) {
        validateRows(n);
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void pattern4(int n) {
        validateRows(n);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    public static void pattern3(int n) {
        validateRows(n);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    public static void pattern6(int n) {
        validateRows(n);
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    public static void pattern7(int n) {
        validateRows(n);
        for (int i = 1; i <= n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i -1; j++) {
                System.out.print("*");
            }
            for (int j = i; j < n; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void pattern8(int n) {
        validateRows(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * (n -i) -1; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void pattern9(int n) {
        validateRows(n);
        for (int i = 1; i <= n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i -1; j++) {
                System.out.print("*");
            }
            for (int j = 1; j <= n; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * (n -i) -1; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void pattern10(int n) {
        validateRows(n);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = n -1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void pattern11(int n) {
        validateRows(n);
        for (int i = 0; i < n; i++) {
            int start = (i % 2 == 0) ? 1 : 0;
            for (int j = 0; j <= i; j++) {
                System.out.print(start + " ");
                start = 1 -start;
            }
            System.out.println();
        }
    }
    public static void pattern12(int n) {
        validateRows(n);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            for (int j = 1; j <= 2 * (n -i); j++) {
                System.out.print(" ");
            }
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void pattern13(int n) {
        validateRows(n);
        int num = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }
    public static void pattern14(int n) {
        validateRows(n);
        for (int i = 0; i < n; i++) {
            for (char ch = 'A'; ch <= 'A' +i; ch++) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }
    public static void pattern15(int n) {
        validateRows(n);
        for (int i = n; i >= 1; i--) {
            for (char ch = 'A'; ch < 'A' +i; ch++) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }
    public static void pattern16(int n) {
        validateRows(n);
        for (int i = 0; i < n; i++) {
            char ch = (char)('A' +i);
            for (int j = 0; j <= i; j++) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }
    public static void pattern17(int n) {
        validateRows(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n -i -1; j++) {
                System.out.print(" ");
            }
            char ch = 'A';
            for (int j = 0; j <= i; j++) {
                System.out.print(ch );
                ch++;
            }
            ch -= 2;
            for (int j = 0; j < i; j++) {
                System.out.print(ch );
                ch--;
            }
            System.out.println();
        }
    }
    public static void pattern18(int n) {
        validateRows(n);
        for (int i = 0; i < n; i++) {
            for (char ch = (char)('A' + n -i -1); ch <= 'A' +n -1; ch++) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }
    public static void pattern19(int n) {
        validateRows(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n -i; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < 2 * i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n -i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < 2 * (n - i); j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void pattern20(int n) {
        validateRows(n);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            for (int j = 1; j <= 4 * (n -i); j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = n -1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            for (int j = 1; j <= 4 * (n -i); j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void pattern21(int n) {
        validateRows(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == n -1 || j == 0 || j == n -1) System.out.print("* ");
                else System.out.print("  ");
            }
            System.out.println();
        }
    }
    public static void pattern22(int n) {
        validateRows(n);
        int size = 2 * n -1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int top = i;
                int left = j;
                int right = size -1 -j;
                int bottom = size -1 -i;
                System.out.print(n - Math.min(Math.min(top,bottom), Math.min(left, right)) + " ");
            }
            System.out.println();
        }
    }
}
