package com.shankes.account.captcha;

public class AccountCaptchaException extends Exception {

    private Exception next;
    private static final long serialVersionUID = -7569192289819959253L;

    public AccountCaptchaException() {
        this.initCause((Throwable) null);
    }

    public AccountCaptchaException(String s) {
        super(s);
        this.initCause((Throwable) null);
    }

    public AccountCaptchaException(String s, Exception e) {
        super(s);
        this.next = e;
        this.initCause((Throwable) null);
    }

    public synchronized Exception getNextException() {
        return this.next;
    }

    public synchronized Throwable getCause() {
        return this.next;
    }

    public synchronized boolean setNextException(Exception ex) {
        Object theEnd;
        for (theEnd = this;
             theEnd instanceof AccountCaptchaException && ((AccountCaptchaException) theEnd).next != null;
             theEnd = ((AccountCaptchaException) theEnd).next) {

        }

        if (theEnd instanceof AccountCaptchaException) {
            ((AccountCaptchaException) theEnd).next = ex;
            return true;
        } else {
            return false;
        }
    }

    public synchronized String toString() {
        String s = super.toString();
        Exception n = this.next;
        if (n == null) {
            return s;
        } else {
            StringBuffer sb = new StringBuffer(s == null ? "" : s);

            while (n != null) {
                sb.append(";\n  nested exception is:\n\t");
                sb.append(n.toString());
                if (n instanceof AccountCaptchaException) {
                    AccountCaptchaException mex = (AccountCaptchaException) n;
                    n = mex.next;
                } else {
                    n = null;
                }
            }

            return sb.toString();
        }
    }
}
