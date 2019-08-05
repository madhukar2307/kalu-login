package com.packages.DAO;

import com.packages.model.Login;

public interface LoginDaoInterface {
    public Login validateLogin(Login login);
    public Login registerUser(Login login);
}
