package com.reactive.ReactiveProject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Mono;

@SpringBootTest
class ReactiveProjectApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void workingWithMono() {
		
		//create a mono which is a publisher that emits a single item or no item
		System.out.println("Working with Mono");
		Mono<String> m1 = Mono.just("Learn Code with Durgester").log();
		//consume the mono by subscribing
		m1.subscribe(data -> System.out.println(data));
	}

}
