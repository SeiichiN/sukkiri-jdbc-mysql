package model;

public class LoginLogic {
    public static boolean execute (User user) {
        if (user.getPass().equals("1234")) { return true; }
        return false;
    }
}

// 修正時刻： Wed Jul  1 08:15:23 2020
