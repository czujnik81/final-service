package org.ljug.gateway;

import lombok.Builder;
import lombok.Data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class FinalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalServiceApplication.class, args);
	}
}

@Data
@Builder
class DataClass {
    private String name;
    private String description;
}

@RestController
class SampleEndpoint {

    @GetMapping("{name}")
    public Flux<DataClass> endpointEmmiter(@PathVariable(name = "name") String name, ServerHttpRequest request) {
        return Flux.interval(Duration.of(50, ChronoUnit.MILLIS))
                    .onBackpressureDrop()
                    .map( x -> DataClass.builder().name(name + x).description("bbb").build())
            .take(10);
    }
}