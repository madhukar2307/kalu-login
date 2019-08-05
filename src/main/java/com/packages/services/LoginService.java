package com.packages.services;

import com.packages.model.Login;

public interface LoginService {

    public Login validateUser(Login login);

    public Login registerUser(Login login);

}
