package com.reactive.ReactiveProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@SpringBootApplication
public class ReactiveProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveProjectApplication.class, args);
		System.out.println("Hello World");
		Mono<Integer> mono= Mono.just(42);//mono is a Mono<Integer> object
		
		//map transforms the emitted value of a reactive stream ie mono and concatenates it with the string "Result"
		// thus resulting in the  "Result:42" which is string literal
		Mono<String> stringMono= mono.map(value->"Result:"+value); //value ->"Result:" +value is a l expression that takes
		//an integer value emitted by the mono and concatenates it with the result
		stringMono.subscribe(System.out::println);
			
	
	 Mono<Integer> mono1 =Mono.just(1);
	 Mono<Integer> mono2 =Mono.just(2);
	 
	 //tuple is a Tuple2 object that holds the values emitted by mono1 and mono2. The getT1() and getT2() methods are used to 
	 //access the values from the Tuple2 object.
	 Mono<Integer>combinedMono= Mono.zip(mono1, mono2).map(tuple ->tuple.getT1()+tuple.getT2());
	 
	 //subscription
	 combinedMono.subscribe(result ->System.out.println("Result: "+result),
			                error->System.out.println("Error: " +error),
			                ()-> System.out.println("Completed")
			                );
	}
	
	}


