package com.chaticat.messageprocessingservice.repository;

import com.chaticat.messageprocessingservice.payload.Message;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends ReactiveCrudRepository<Message, String> {
}
