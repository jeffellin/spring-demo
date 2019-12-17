package com.example.ellin.webdemo;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
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
	@Timed
	public class RestDemo {

		private final Log log = LogFactory.getLog(getClass());

		@Autowired
		MeterRegistry registry;

		@GetMapping("/")
		public Map<String,String> sayHello() throws InterruptedException {

			final Map<String,String> results = new HashMap<>();
			final Counter counter = registry.counter("hello.count");
			counter.increment();

			final Random rn = new Random();
			final int answer = rn.nextInt(5) + 1;

			Thread.sleep(answer * 1000);

			results.put("string","helloworld");
			results.put("color","yellow");
			results.put("counter", Integer.toString(answer));
			return results;


			
		}


		@GetMapping("/hi")
		public Map<String,String> sayHi() throws InterruptedException {

			final Map<String,String> results = new HashMap<>();
			final Counter counter = registry.counter("hello.count");
			counter.increment();

			final Random rn = new Random();
			final int answer = rn.nextInt(5) + 1;

			Thread.sleep(answer * 1000);

			results.put("string","hi");
			results.put("color","yellow");
			results.put("counter", Integer.toString(answer));
			return results;

		}

	}
}
