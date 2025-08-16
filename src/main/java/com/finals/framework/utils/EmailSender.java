
package com.finals.framework.utils;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class EmailSender {
    public static void send(String subject, String body, String attachmentPath) {
        try {
            // zip the reports folder if attachmentPath is a folder
            String toSend = attachmentPath;
            File f = new File(attachmentPath);
            if (f.isDirectory()) {
                String zipPath = "reports/report_bundle.zip";
                try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipPath))) {
                    File[] files = f.listFiles();
                    if (files != null) {
                        for (File file : files) {
                            zos.putNextEntry(new ZipEntry(file.getName()));
                            try (FileInputStream fis = new FileInputStream(file)) {
                                byte[] buffer = new byte[1024];
                                int len;
                                while ((len = fis.read(buffer)) > 0) {
                                    zos.write(buffer, 0, len);
                                }
                            }
                            zos.closeEntry();
                        }
                    }
                }
                toSend = zipPath;
            }

            String username = ConfigReader.get("mail.username");
            String password = ConfigReader.get("mail.password");
            String to = ConfigReader.get("mail.to");
            Properties props = new Properties();
            props.put("mail.smtp.host", ConfigReader.get("mail.smtp.host"));
            props.put("mail.smtp.port", ConfigReader.get("mail.smtp.port"));
            props.put("mail.smtp.auth", ConfigReader.get("mail.smtp.auth"));
            props.put("mail.smtp.starttls.enable", ConfigReader.get("mail.smtp.starttls.enable"));

            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(body, "text/html");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            if (toSend != null) {
                MimeBodyPart attachment = new MimeBodyPart();
                attachment.attachFile(new File(toSend));
                multipart.addBodyPart(attachment);
            }

            message.setContent(multipart);
            Transport.send(message);
            System.out.println("Email sent to " + ConfigReader.get("mail.to"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
