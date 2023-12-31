package com.nesterov.tasksexecutorreporter.notifications.notifiers.email;

import com.nesterov.tasksexecutorreporter.configs.applicationConfigs.ExternalConfigs;
import com.nesterov.tasksexecutorreporter.dao.OwnerDao;
import com.nesterov.tasksexecutorreporter.dto.Owner;
import com.nesterov.tasksexecutorreporter.notifications.notifiers.Notifier;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service("e-mail")
@RequiredArgsConstructor
public class EmailService implements Notifier {

    private final JavaMailSender javaMailSender ;
    private final OwnerDao ownerDao;
    private final ExternalConfigs.NotificationsConfig notificationsConfig;

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
    public void makeNotify(long ownerId, String message) {
        if (notificationsConfig.isDummyModeNotificationsEmailEnable()){
            dummyMode(ownerId, message);
        } else {
            realNotify(ownerId, message);
        }
    }

    public void realNotify(long ownerId, String message){
        Owner owner = ownerDao.getOwnerById(ownerId);
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(owner.getEMail());
        simpleMailMessage.setSubject("Worker notification");
        simpleMailMessage.setText(message);
        javaMailSender.send(simpleMailMessage);
    }

    public void dummyMode(long ownerId, String message){
        log.info("DUMMY message={} to owner={} was send", message,ownerId);
    }

}
