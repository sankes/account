package com.shankes.account.persist;

public interface AccountPersistService {

    Account createAccount(Account account) throws Exception;

    Account readAccount(String id) throws Exception;

    Account updateAccount(Account account) throws Exception;

    void deleteAccount(String id) throws Exception;
}
