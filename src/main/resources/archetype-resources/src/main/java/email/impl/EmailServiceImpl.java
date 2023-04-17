package ${package}.email.impl;

import ${package}.email.EmailService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.io.File;
import java.util.Map;

@Component
@Slf4j
public class EmailServiceImpl implements EmailService {
    private JavaMailSender mailSender;
    private SpringTemplateEngine thymeleafTemplateEngine;
    public EmailServiceImpl(JavaMailSender mailSender, SpringTemplateEngine thymeleafTemplateEngine) {
        this.mailSender = mailSender;
        this.thymeleafTemplateEngine = thymeleafTemplateEngine;
    }
    @Override
    public void sendTextEmail(String from, String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }

    @Override
    public void sendEmail(String from, String to, String subject, String body) {
        sendEmail(from, to, subject, body, null);
    }

    @Override
    public void sendEmail(String from, String to, String subject, String body, File fileToAttach) {
        MimeMessagePreparator preparator = mimeMessage -> {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");

            message.setTo(to);
            message.setFrom(from);
            message.setSubject(subject);
            message.setText(body, true);

            if (fileToAttach != null ) {
                log.info("Attaching file: {}", fileToAttach.getAbsolutePath());
                message.addAttachment(fileToAttach.getName(), fileToAttach);
            }
        };

        mailSender.send(preparator);
    }

    @Override
    public void sendMessage(String from, String to, String subject, Map<String, Object> templateModel) {
        sendMessage(from, to, subject, templateModel, null);
    }

    @Override
    public void sendMessage(String from, String to, String subject, Map<String, Object> templateModel, File attachment) {
        Context thymeleafContext = new Context();
        thymeleafContext.setVariables(templateModel);
        String htmlBody = thymeleafTemplateEngine.process("template-thymeleaf.html", thymeleafContext);

        sendEmail(from, to, subject, htmlBody, attachment);
    }
}
