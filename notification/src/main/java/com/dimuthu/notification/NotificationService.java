package com.dimuthu.notification;

import com.dimuthu.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void send(NotificationRequest notificationRequest){
        notificationRepository.save(
          Notification.builder()
                  .toCustomerId(notificationRequest.toCustomerId())
                  .toCustomerEmail(notificationRequest.toCustomerEmail())
                  .sender("Dimuthu")
                  .message(notificationRequest.message())
                  .sentAt(LocalDateTime.now())
                  .build()
        );
    }
}
