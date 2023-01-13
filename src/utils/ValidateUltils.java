package utils;

import java.util.regex.Pattern;

public class ValidateUltils {
    public static final String NAME_PATTERN = "^([A-ZÁÀẢÃẠĂẮẰẲẴẶÂẤẦẨẪẬĐÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴ]{1}[a-záàảãạăắằẳẵặâấầẩẫậđéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵ]+[ ]?)+$";
    public static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=_])(?=\\S+$).{6,}$";
    public static final String USERNAME_PATTERN = "^\\S{6,}$";
    public static final String EMAIL_PATTERN = "^[A-Za-z0-9.]*[A-Za-z0-9]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    public static final String PHONE_PATTERN = "^[0][1-9][0-9]{8}$";
    public static final String CHOICE_PATTERN = "^[1-3]$";
    public static final String LOGINCHOICE_PATTERN = "^[1-2]$";
    public static final String QUANTITY_PATTERN = "^[1-100000]$";

    public static boolean isPassswordValid(String password) {
        return Pattern.compile(PASSWORD_PATTERN).matcher(password).matches();
    }

    public static boolean isNameValid(String name) {
        return Pattern.compile(NAME_PATTERN).matcher(name).matches();
    }

    public static boolean isUsernameValid(String userName) {
        return Pattern.compile(USERNAME_PATTERN).matcher(userName).matches();
    }

    public static boolean isPhoneValid(String phone) {
        return Pattern.compile(PHONE_PATTERN).matcher(phone).matches();
    }

    public static boolean isEmailValid(String email) {
        return Pattern.compile(EMAIL_PATTERN).matcher(email).matches();
    }

    public static boolean isRoleValid(String role) {
        return Pattern.compile(CHOICE_PATTERN).matcher(role).matches();
    }
    public static boolean isLoginValid(String login){
        return Pattern.compile(LOGINCHOICE_PATTERN).matcher(login).matches();
    }
    public static boolean isQuantityValid(String role) {
        return Pattern.compile(QUANTITY_PATTERN).matcher(role).matches();
    }
}
