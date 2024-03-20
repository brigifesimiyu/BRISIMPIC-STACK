package com.ls.diary.controller;

import com.ls.diary.service.MessageService;
import nl.martijndwars.webpush.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/subscribe")
    public ResponseEntity<Void> subscribe(@RequestBody Subscription subscription) {
        messageService.subscribe(subscription);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/unsubscribe")
    public ResponseEntity<Void> unsubscribe(@RequestBody String endpoint) {
        messageService.unsubscribe(endpoint);
        return ResponseEntity.ok().build();
    }
}

