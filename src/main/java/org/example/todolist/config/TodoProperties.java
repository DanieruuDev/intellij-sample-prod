package org.example.todolist.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "t")
public record TodoProperties(String greetings, String name) {

}
