package com.shankes.account.persist;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.List;

public class AccountPersistServiceImpl implements AccountPersistService {

    private static final String ELEMENT_ROOT = "ELEMENT_ROOT";
    private static final String ELEMENT_ACCOUNTS = "ELEMENT_ACCOUNTS";
    private static final String ELEMENT_ACCOUNT_ID = "ELEMENT_ACCOUNT_ID";
    private static final String ELEMENT_ACCOUNT_ACTIVATED = "ELEMENT_ACCOUNT_ACTIVATED";
    private static final String ELEMENT_ACCOUNT_EMAIL = "ELEMENT_ACCOUNT_EMAIL";
    private static final String ELEMENT_ACCOUNT_NAME = "ELEMENT_ACCOUNT_NAME";
    private static final String ELEMENT_ACCOUNT_PASSWORD = "ELEMENT_ACCOUNT_PASSWORD";

    private String file;
    private SAXReader reader = new SAXReader();

    private Document readDocument() throws Exception {
        File dateFile = new File(file);
        if (!dateFile.exists()) {
            dateFile.getParentFile().mkdirs();
            Document doc = DocumentFactory.getInstance().createDocument();
            Element rootEle = doc.addElement(ELEMENT_ROOT);
            rootEle.addElement(ELEMENT_ACCOUNTS);
            writeDocument(doc);
        }
        try {
            return reader.read(new File(file));
        } catch (DocumentException e) {
            throw new AccountPersistException("Unable to read persist data xml", e);
        }
    }

    private void writeDocument(Document doc) throws AccountPersistException {
        Writer out = null;
        try {
            out = new OutputStreamWriter(new FileOutputStream(file), "utf-8");
            XMLWriter writer = new XMLWriter(out, OutputFormat.createPrettyPrint());
            writer.write(doc);
        } catch (IOException e) {
            throw new AccountPersistException("Unable to write persist data xml", e);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                throw new AccountPersistException("Unable to close persist data xml writer", e);
            }
        }
    }

    @Override
    public Account createAccount(Account account) throws AccountPersistException {
        return null;
    }

    @Override
    public Account readAccount(String id) throws AccountPersistException {
        try {
            Document doc = readDocument();
            Element accountsEle = doc.getRootElement().element(ELEMENT_ACCOUNTS);
            for (Element accountEle : (List<Element>) accountsEle.elements()) {
                if (accountEle.elementText(ELEMENT_ACCOUNT_ID).equals(id)) {
                    return buildAccount(accountEle);
                }
            }
        } catch (Exception e) {
            throw new AccountPersistException("Unable to read document", e);
        }
        return null;
    }

    private Account buildAccount(Element element) {
        Account account = new Account();
        account.setId(element.elementText(ELEMENT_ACCOUNT_ID));
        account.setActivated(element.isRootElement());
//        account.setActivated(element.isRootElement(ELEMENT_ACCOUNT_ACTIVATED));
        account.setEmail(element.elementText(ELEMENT_ACCOUNT_EMAIL));
        account.setName(element.elementText(ELEMENT_ACCOUNT_NAME));
        account.setPassword(element.elementText(ELEMENT_ACCOUNT_PASSWORD));
        return account;
    }

    @Override
    public Account updateAccount(Account account) throws AccountPersistException {

        return null;
    }

    @Override
    public void deleteAccount(String id) throws AccountPersistException {

    }
}
