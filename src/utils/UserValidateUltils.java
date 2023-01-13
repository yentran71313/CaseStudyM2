package utils;

import tools.UserManager;

import java.util.Scanner;

public class UserValidateUltils {
    static Scanner input = new Scanner(System.in);

    public static String inputUserName() {
        String userName = "";
        boolean checkUsername = false;
        do {
            System.out.println("Nhập username muốn tạo hoặc sửa (bao gồm 6 ký tự): ");
            userName = input.nextLine();
            if (!ValidateUltils.isUsernameValid(userName)) {
                checkUsername = true;
                System.out.println("Tên không đúng quy định vui lòng nhập lại !!");
            } else if (UserManager.checkUserNameInTheList(userName)) {
                System.out.println("Username đã có, vui lòng nhập lại !!");
                checkUsername = true;
//                UserManager.addUser();
            } else {
                checkUsername = false;
            }
        }
        while (!ValidateUltils.isUsernameValid(userName));
        return userName;
    }

    public static String inputPassWord() {
        String passWord = "";
        do {
            System.out.println("Nhập Password (Mật khẩu có ít nhất 1 ký tự hoa , 1 số, 1 ký tự thường, 1 ký tự đặc biệt và trên 6 chữ số): ");
            passWord = input.nextLine();
            if (!ValidateUltils.isPassswordValid(passWord)) {
                System.out.println("Mật khẩu yếu");
            }
        }
        while (!ValidateUltils.isPassswordValid(passWord));
        return passWord;
    }

    public static String inputFullName() {
        String fullName = "";
        do {
            System.out.println("Nhập tên người dùng: (Ví dụ : Nguyễn Văn Hà) ");
            fullName = input.nextLine();
            if (!ValidateUltils.isNameValid(fullName)) {
                System.out.println("Tên không đúng định dạng vui lòng nhập lại!");
            }

        } while (!ValidateUltils.isNameValid(fullName));
        return fullName;
    }

    public static String inputPhone() {
        String phone = "";
        boolean checkPhone = false;
        do {
            System.out.println("Nhập số điện thoại người dùng (Bắt đầu bằng số 0 , yêu cầu đủ 10 số): ");
            phone = input.nextLine();
            if (!ValidateUltils.isPhoneValid(phone)) {
                checkPhone = true;
                System.out.println("Không đúng định dạng vui lòng nhập lại:");
            } else if(UserManager.checkPhoneInTheList(phone)){
                System.out.println("Số điện thoại đã tồn tại");
                checkPhone = true;
            } else {
                checkPhone = false;
            }
        } while (checkPhone);
        return phone;
    }

    public static String inputEmail() {
        String email = "";
        boolean checkEmail = false;
        do {
            System.out.println("Nhập email người dùng : (Ví dụ : yentran71313@gmail.com)");
            email = input.nextLine();
            if (!ValidateUltils.isEmailValid(email)){
                checkEmail = true;
                System.out.println("Không đúng định dạng, vui lòng nhập lại!!");
            } else if(UserManager.checkEmailInTheList(email)){
                checkEmail = true;
                System.out.println(("Email đã được sử dụng, vui lòng nhập lại!!"));
            } else {
                checkEmail = false;
            }

        } while (checkEmail);
        return email;
    }

    public static String inputRole() {
        String inputRole = "";
        String choice = "";
        do {
            System.out.println("㊋㊋㊋㊋㊋㊋ROLE㊋㊋㊋㊋㊋㊋㊋");
            System.out.println("        " + "1.SADMIN" + "       ㊋");
            System.out.println("        " + "2.ADMIN" + "        ㊋");
            System.out.println("        " + "3.USER" + "         ㊋ ");
            System.out.println("㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋");
            System.out.println("Chọn role bạn muốn thêm : ");
            choice = input.nextLine();
            switch (choice) {
                case "1":
                    inputRole = "SADMIN";
                    break;
                case "2":
                    inputRole = "ADMIN";
                    break;
                case "3":
                    inputRole = "USER";
                    break;
            }
            if (!ValidateUltils.isRoleValid(choice)) {
                System.out.println("Không đúng định dạng vui lòng nhập lại!!!");
            }
        } while (!ValidateUltils.isRoleValid(choice));
        return inputRole;
    }

}
