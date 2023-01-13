package utils;

import surface.OptionAdmin;
import surface.OptionSadmin;
import surface.OptionUser;

import java.util.Scanner;

public class BackMeNuOrExit {
    Scanner scanner = new Scanner(System.in);
    public static int choice = -1;
    public void BackMeNuOrExitUser(){
        System.out.println("Nhấn 1 để quay lại menu chính hoặc 0 để thoát ");
        System.out.printf("︻┳═一 :");
        choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                OptionUser.optionUser();
                break;
            case 0:
                System.out.println("Hẹn Gặp Lại!!!");
                System.exit(0);
                break;
            default:
                System.out.println("Vui Lòng Nhập Lại!");
                BackMeNuOrExitUser();
        }
    }
    public void BackMeNuOrExitAdmin(){
        System.out.println("Nhấn 1 để về menu chính và 0 để thoát !! ");
        System.out.printf("︻┳═一 :");
        choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                OptionAdmin.optionAdmin();
                break;
            case 0:
                System.out.println("Hẹn Gặp Lại!!!");
                System.exit(0);
                break;
            default:
                System.out.println("Vui Lòng Nhập Lại!");
                BackMeNuOrExitAdmin();
        }
    }
    public void BackMeNuOrExitSadmin(){
        System.out.println("Nhấn 1 để quay lại menu chính hoặc 0 để thoát ");
        System.out.printf("︻┳═一 :");
        choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                OptionSadmin.optionSadmin();
                break;
            case 0:
                System.out.println("Hẹn Gặp Lại!!!");
                System.exit(0);
                break;
            default:
                System.out.println("Vui Lòng Nhập Lại!");
                BackMeNuOrExitSadmin();
        }
    }
}
