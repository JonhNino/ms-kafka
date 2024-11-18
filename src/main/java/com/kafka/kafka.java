package com.kafka;

import org.apache.camel.builder.RouteBuilder;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class kafka extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        // Ruta que consume mensajes del topic
        from("kafka:{{kafka.topic.name}}")
                .log("Mensaje recibido de Kafka: ${body}")
                .to("log:com.kafka?level=INFO");
    }
}