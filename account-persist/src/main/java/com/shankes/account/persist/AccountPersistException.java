package com.shankes.account.persist;

public class AccountPersistException extends Exception {
    public AccountPersistException(String s) {
        super(s);
    }

    public AccountPersistException(String s, Exception e) {
        super(s);
    }
}
