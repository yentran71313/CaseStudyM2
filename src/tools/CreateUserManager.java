package tools;

import models.CreateUser;
import models.User;
import utils.InstantUtils;
import utils.UserValidateUltils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateUserManager {
    private final static String PATCH_CREATEUSER = "C:\\Users\\Admin\\Downloads\\CSModule2-main\\data\\CreateUser.csv";
    private final static String PATCH_USER = "C:\\Users\\Admin\\Downloads\\CSModule2-main\\data\\User.csv";

    public static void createAddUser() {
        List<CreateUser> createUsers = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        Long id = System.currentTimeMillis() / 1000;
        String userName = UserValidateUltils.inputUserName();
        String passWord = UserValidateUltils.inputPassWord();
        String fullName = UserValidateUltils.inputFullName();
        String phone = UserValidateUltils.inputPhone();
        String email = UserValidateUltils.inputEmail();
        System.out.println("Nhập địa chỉ người dùng: ");
        String address = input.nextLine();
        String role = "USER";
        CreateUser newUser = new CreateUser(id, userName, passWord, fullName, phone, email, address, role);
        newUser.setCreatedAt(Instant.now());
        createUsers.add(newUser);
        ReadFifeandWriteFile.write(PATCH_CREATEUSER, createUsers);
        List<User> users = UserManager.findAll();
        User newUser1 = new User(id,userName,passWord,fullName,phone,email,address,role);
        newUser1.setCreatedAt(Instant.now());
        users.add(newUser1);
        ReadFifeandWriteFile.write(PATCH_USER, users);
        System.out.println("Đã tạo thành công !!");
        renderCreateUser();
    }

    public static void renderCreateUser() {
        System.out.println("㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋USER-LIST㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋");
        System.out.printf("\n%-25s %-25s %-25s %-25s %-25s %-35s %-15s %-15s %-15s %s\n", "ID", "UserName", "PassWord", "Tên đầy đủ", "Số điện thoại", "Email", "Địa chỉ","Vai Trò", "Ngày Tạo", "㊋");
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader(PATCH_CREATEUSER));
            while ((line = br.readLine()) != null) {
                printMenu(parseCsvLine(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        System.out.println("㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋");
    }

    public static List<String> parseCsvLine(String csvLine) {
        List<String> result = new ArrayList<>();
        if (csvLine != null) {
            String[] splitData = csvLine.split(",");
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public static void printMenu(List<String> createUserList) {
        System.out.printf("\n%-25s %-25s %-25s %-25s %-25s %-35s %-15s %-15s %-15s %s\n", createUserList.get(0), createUserList.get(1), createUserList.get(2), createUserList.get(3), createUserList.get(4), createUserList.get(5), createUserList.get(6),createUserList.get(7), InstantUtils.instantToString(Instant.parse(createUserList.get(8))), "㊋");
    }
}
