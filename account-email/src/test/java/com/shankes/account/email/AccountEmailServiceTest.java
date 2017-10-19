package com.shankes.account.email;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.mail.Message;

public class AccountEmailServiceTest {
    private GreenMail greenMail;

    @Before
    public void startMailServer() throws Exception {
        greenMail = new GreenMail(ServerSetup.SMTP);
        greenMail.setUser("test@shankes.com", "123");
        greenMail.start();
    }

    @After
    public void stopMailServer() throws Exception {
        greenMail.stop();
    }

    @Test
    public void testSendMail() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("account-email.xml");
        AccountEmailService accountEmailService = (AccountEmailService) ctx.getBean("accountEmailService");
        String subject = "Test subject";
        String hemlText = "<h3>Test</h3>";
        accountEmailService.sendMail("test2@shankes.com", subject, hemlText);

        greenMail.waitForIncomingEmail(2000, 1);

        Message[] msgs = greenMail.getReceivedMessages();
        Assert.assertEquals(1, msgs.length);
        Assert.assertEquals(subject, msgs[0].getSubject());
        Assert.assertEquals(hemlText, GreenMailUtil.getBody(msgs[0]).trim());
    }
}
