package com.example.client.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@EnableAutoConfiguration
@Entity
@Data
@Table(name = "client")
public class Client {

    @Id
    private String clientId;

    private String name;
    private String surname;
    private int age;
    private int background;
    private boolean student;
    private boolean frequentBuyer;

    public Client(String id, String name, String surname, int age, int background, boolean student){
        this.clientId = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.background = background;
        this.student = student;
        this.frequentBuyer = false;
    }

}

