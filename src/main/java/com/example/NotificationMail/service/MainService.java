package com.example.NotificationMail.service;


import org.springframework.stereotype.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class MainService {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private Environment env;

    public void sendMail(String mailTo) throws MessagingException {

        //String mailTo="palashdas932@gmail.com";
        String subject="Notification Mail";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        String idCombinedUserAccept= Base64.getEncoder().encodeToString((1+","+1+","+"accept").getBytes(StandardCharsets.UTF_8));
        String idCombinedUserReject= Base64.getEncoder().encodeToString((1+","+1+","+"reject").getBytes(StandardCharsets.UTF_8));
        String acceptUrl = "http://localhost:8081/notificationacceptance/" + idCombinedUserAccept;
        String rejectUrl = "http://localhost:8081/notificationacceptance/" + idCombinedUserReject;

        String htmlContent = "<h2>Action Required</h2>"
                        + "<p>Please respond to the notification:</p>"
                        + "<a href=\"" + acceptUrl + "\" style=\"padding:10px 20px;background-color:green;color:white;text-decoration:none;border-radius:5px;\">Accept</a>"
                        + "&nbsp;"
                        + "<a href=\"" + rejectUrl + "\" style=\"padding:10px 20px;background-color:red;color:white;text-decoration:none;border-radius:5px;\">Reject</a>";

        helper.setTo(mailTo);
        helper.setSubject(subject);
        helper.setText(htmlContent, true); // true enables HTML

        mailSender.send(message);
            }



}
