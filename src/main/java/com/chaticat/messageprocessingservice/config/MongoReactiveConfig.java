package com.chaticat.messageprocessingservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.chaticat.messageprocessingservice.repository")
public class MongoReactiveConfig {

}