package service;

import dao.UserDAO;
import model.User;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserService {

    public void addUser(String username, String password) {

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        UserDAO userDAO = new UserDAO();
        userDAO.create(user);
    }

    public User getUser(String username){

        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserByUsername(username);
        return user;
    }

//    private String encryptPassword(String password) {
//        MessageDigest digest = null;
//        try {
//            digest = MessageDigest.getInstance("MD5");
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        digest.update(password.getBytes());
//        String md5Password = new BigInteger(1, digest.digest()).toString(16);
//        return md5Password;
//    }
}

