package com.example.ellin.webdemo;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@SpringBootApplication
public class WebDemoApplication {

    /**
     * Hello world spring app.
     *
     * @param args
     */
    public static void main(final String[] args) {
        SpringApplication.run(WebDemoApplication.class, args);
    }

    @RestController
    public class RestDemo {

        private final Log log = LogFactory.getLog(getClass());

        @Autowired
        MeterRegistry registry;

        @GetMapping("/")
        @Timed
        public Map<String, String> sayHello() throws InterruptedException {



            //processError();


            //Thread.sleep(5000);

            final String color = "green";
            final Tag tag = Tag.of("color", color);
            final Map<String, String> results = new HashMap<>();
            final Counter counter = registry.counter("hello", Collections.singletonList(tag));
            counter.increment();
            results.put("string", "hello-world");
            results.put("color", color);
            results.put("version", "three");
            return results;

        }

        private void processError() {

            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 0.70f) {
                throw new RuntimeException("Erroneous Condition");
            }
        }
    }
}
