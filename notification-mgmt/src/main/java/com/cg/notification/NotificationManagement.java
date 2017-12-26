package com.cg.notification;

import static reactor.bus.selector.Selectors.$;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cg.notification.service.NotificationConsumer;

import reactor.Environment;
import reactor.bus.EventBus;

@SpringBootApplication
public class NotificationManagement implements CommandLineRunner {

	@Autowired
	private EventBus eventBus;

	@Autowired
	private NotificationConsumer notificationConsumer;

	@Bean
	Environment env() {
		return Environment.initializeIfEmpty().assignErrorJournal();
	}

	@Bean
	EventBus createEventBus(Environment env) {
		return EventBus.create(env, Environment.THREAD_POOL);
	}

	@Override
	public void run(String... args) throws Exception {
		eventBus.on($("notificationConsumer"), notificationConsumer);
	}

	public static void main(String[] args) {
		SpringApplication.run(NotificationManagement.class, args);
	}
}
