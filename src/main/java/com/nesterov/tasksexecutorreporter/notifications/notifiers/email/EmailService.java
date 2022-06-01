package com.nesterov.tasksexecutorreporter.notifications.notifiers.email;

import com.nesterov.tasksexecutorreporter.notifications.notifiers.Notifier;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("e-mail")
@RequiredArgsConstructor
public class EmailService implements Notifier {

    private final JavaMailSender emailSender ;

//    @Override
//    public void sendEmailWithAttachment(String toAddress, String subject, String message, String attachment) throws MessagingException, FileNotFoundException {
//        MimeMessage mimeMessage = emailSender.createMimeMessage();
//        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
//        messageHelper.setTo(toAddress);
//        messageHelper.setSubject(subject);
//        messageHelper.setText(message);
//        FileSystemResource file = new FileSystemResource(ResourceUtils.getFile(attachment));
//        messageHelper.addAttachment("Purchase Order", file);
//        emailSender.send(mimeMessage);
//    }

    @Override
    public void makeNotify(int ownerId, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo("1212");
        simpleMailMessage.setSubject("Worker notification");
        simpleMailMessage.setText(message);
        emailSender.send(simpleMailMessage);
    }
}
