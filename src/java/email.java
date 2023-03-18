import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class email {
    public static void sendEmail(String recipient, String subject, String content) throws Exception {
        
        try{
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("email", "password");
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("zineelabidine.achaghour@edu.uiz.ac.ma","AMA School LTD"));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        message.setSubject(subject);
        message.setText(content);

        Transport.send(message);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
