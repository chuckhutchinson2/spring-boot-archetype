package ${package}.email;

public interface EmailService {
    public void sendMail(String from, String to, String subject, String body);
}
