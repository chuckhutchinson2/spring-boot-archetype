package ${package}.email.impl;

import org.example.datecalculator.email.EmailService;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {
    private MailSender mailSender;
    public EmailServiceImpl(MailSender mailSender) {
        this.mailSender = mailSender;
    }
    @Override
    public void sendMail(String from, String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        //sending message
        mailSender.send(message);
    }
}
