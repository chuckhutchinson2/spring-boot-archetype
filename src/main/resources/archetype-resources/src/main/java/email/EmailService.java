package ${package}.email;

import java.io.File;
import java.util.Map;

public interface EmailService {
    public void sendTextEmail(String from, String to, String subject, String body);

    public void sendEmail(String from, String to, String subject, String body);

    public void sendEmail(String from, String to, String subject, String body, File attachment);

    public void sendMessage(String from, String to, String subject, Map<String, Object> templateModel);
    public void sendMessage(String from, String to, String subject, Map<String, Object> templateModel, File attachment);
}
