package telran.java51;

import java.util.function.Supplier;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.PollableBean;
import org.springframework.context.annotation.Bean;

import kotlin.contracts.Returns;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@SpringBootApplication
public class KarafkaProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KarafkaProducerApplication.class, args);
	}
	
	 @Bean
	    public Supplier<Flux<String>> stringSupplier() {
	        return () -> Flux.fromStream(Stream.generate(new Supplier<String>() {
	            @Override
	            public String get() {
	                try {
	                    Thread.sleep(10000);
	                    return "Hello java51";
	                } catch (Exception e) {
	                 return e.getMessage();
	                }
	            }
	        })).subscribeOn(Schedulers.single()).share();
	    }

}
