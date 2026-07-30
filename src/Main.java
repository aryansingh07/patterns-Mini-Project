package src;

import gui.PatternGeneratorGUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(PatternGeneratorGUI::new);
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("pattern Generator");
//        System.out.print("Choose Pattern (1-22): ");
//
//        int choice = sc.nextInt();
//
//        if (choice == 21)   ImageViewer.showImage("pictures/P21.jpg");
//        ImageViewer.showImage("pictures/P" + choice + ".png");
//
//        System.out.print("Enter number of rows: ");
//
//        int n = sc.nextInt();
//
//        switch (choice) {
//            case 1:
//                src.Patterns.pattern1(n);
//                break;
//            case 2:
//                src.Patterns.pattern2(n);
//                break;
//            case 3:
//                src.Patterns.pattern3(n);
//                break;
//            case 4:
//                src.Patterns.pattern4(n);
//                break;
//            case 5:
//                src.Patterns.pattern5(n);
//                break;
//            case 6:
//                src.Patterns.pattern6(n);
//                break;
//            case 7:
//                src.Patterns.pattern7(n);
//                break;
//            case 8:
//                src.Patterns.pattern8(n);
//                break;
//            case 9:
//                src.Patterns.pattern9(n);
//                break;
//            case 10:
//                src.Patterns.pattern10(n);
//                break;
//            case 11:
//                src.Patterns.pattern11(n);
//                break;
//            case 12:
//                src.Patterns.pattern12(n);
//                break;
//            case 13:
//                src.Patterns.pattern13(n);
//                break;
//            case 14:
//                src.Patterns.pattern14(n);
//                break;
//            case 15:
//                src.Patterns.pattern15(n);
//                break;
//            case 16:
//                src.Patterns.pattern16(n);
//                break;
//            case 17:
//                src.Patterns.pattern17(n);
//                break;
//            case 18:
//                src.Patterns.pattern18(n);
//                break;
//            case 19:
//                src.Patterns.pattern19(n);
//                break;
//            case 20:
//                src.Patterns.pattern20(n);
//                break;
//            case 21:
//                src.Patterns.pattern21(n);
//                break;
//            case 22:
//                src.Patterns.pattern22(n);
//                break;
//            default:
//                System.out.println("Invalid choice.");
//                break;
//        }

    }
}
