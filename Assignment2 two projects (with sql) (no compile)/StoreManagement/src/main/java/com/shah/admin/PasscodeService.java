package com.shah.admin;

public interface PasscodeService {
    boolean login(String code, boolean isAdminLogin);
}
