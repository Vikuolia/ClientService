package com.example.client.rabbitmq;

import com.example.client.model.Client;
import com.example.client.service.ClientService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.example.client.rabbitmq.Config.QUEUE;

@Component
public class Consumer {

    @Autowired
    ClientService clientService;

    @RabbitListener(queues = QUEUE)
    public  void consumeMessageFromQueue(Client client){
        System.out.println(clientService.addClient(client));
    }
}

