package warehouse.notifications;

import warehouse.item.Item;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.PasswordAuthentication;
import java.util.Properties;

public class EmailSender {
    public static void notify(Item item){
        // Configure email server
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.mailtrap.io");
        prop.put("mail.smtp.port", "2525");
        prop.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        "5d205e8b9503f6",
                        "969159ed0125ea");
            }
        });

        // Send actual email
        try {
            Message message = new MimeMessage(session);

            // to/from
            message.setFrom(new InternetAddress("stock@warehouse.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("vivkimi@gmail.com"));

            // subject
            message.setSubject("Item Notification");

            // content
            String msg = "Item Value: $" + item.getAmount();
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msg, "text/html");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            message.setContent(multipart);

            // send and wait (mail server has limit)
            Transport.send(message);
            System.out.println("Notified vivkimi@gmail.com about : " + item);
            Thread.sleep(3000);
        }
        catch (MessagingException e){
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
