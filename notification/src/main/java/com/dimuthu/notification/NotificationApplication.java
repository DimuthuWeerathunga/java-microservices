package com.dimuthu.notification;

import com.dimuthu.amqp.RabbitMQMessageProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
        scanBasePackages = {
                "com.dimuthu.notification",
                "com.dimuthu.amqp"
        }
)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.dimuthu.clients"
)
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(RabbitMQMessageProducer producer, NotificationConfig notificationConfig) {
//        return args -> {
//            producer.publish("foo",
//                    notificationConfig.getInternalExchange(),
//                    notificationConfig.getInternalNotificationRoutingKey()
//            );
//        };
//    }
}
