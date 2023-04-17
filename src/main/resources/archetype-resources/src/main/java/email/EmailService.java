package ${package}.email;

import java.io.File;

public interface EmailService {
    public void sendTextEmail(String from, String to, String subject, String body);

    public void sendEmail(String from, String to, String subject, String body);

    public void sendEmail(String from, String to, String subject, String body, File attachment);
}
