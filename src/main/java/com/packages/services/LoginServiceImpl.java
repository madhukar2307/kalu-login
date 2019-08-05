package com.packages.services;

import com.packages.DAO.LoginDaoInterface;
import com.packages.model.Login;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDaoInterface loginDaoInterface;

    public Login validateUser(Login login) {
        return loginDaoInterface.validateLogin(login);
    }

    public Login registerUser(Login login) {
        return loginDaoInterface.registerUser(login);
    }
}
