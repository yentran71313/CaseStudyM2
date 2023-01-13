package check;

import tools.UserManager;
import models.User;

import java.util.List;
import java.util.Scanner;

public class PasswordFogot {
    Scanner input = new Scanner(System.in);
    public void CheckEmail(){
        int count = 0;
        List<User> userList = UserManager.findAll();
        System.out.println("㊋㊋㊋㊋㊋㊋㊋Fogot PassWord㊋㊋㊋㊋㊋㊋㊋㊋㊋");
        System.out.println("Nhập Username muốn tìm lại PassWord : ");
        System.out.printf("==>");
        String userName = input.nextLine();
        for(User user: userList){
            String checkUser = user.getUsername();
            String checkPhone = user.getPhone();
            String checkEmail = user.getEmail();
            if(checkUser.equals(userName)){
                count++;
                System.out.println("Nhập Email đăng ký tài khoản: ");
                System.out.printf("==> :");
                String email = input.nextLine();
                System.out.println("Nhập số điện thoại đăng ký tài khoản: ");
                System.out.printf("==> :");
                String phone = input.nextLine();
                if(checkPhone.equals(phone)&&checkEmail.equals(email)){
                    System.out.println("Chào bạn : " + user.getFullName());
                    System.out.println("Username của bạn là : " + user.getUsername());
                    System.out.println("Password của bạn là : " + user.getPassword());
                } else {
                    System.out.println("Email hoặc số điện thoại đăng ký không đúng!!!");
                    break;
                }
            }
        }
        if(count == 0) {
            System.out.println("Username : " + userName +" không tồn tại vui lòng nhập lại!!!");
            CheckEmail();
            return;
        }
    }
}
