package telran.java51.pulse.service;

import java.util.Random;
import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import telran.java51.pulse.dto.PulseDto;

@Configuration
public class PulseService {

	Random random = new Random();
	private int minId = 1;
	private int maxId = 10;
	private int minPulse = 1;
	private int maxPulse = 200;
	
	@Bean
	Supplier <PulseDto> stringSupplier() {
		
		return () -> {
			
			int id = random.nextInt(minId, maxId);
			long timeStamp=System.currentTimeMillis();
			int payload= random.nextInt(minPulse, maxPulse);
			return new PulseDto(id, timeStamp, payload);
		};
	}
}

/*
 * После этого для балансировки партиций, мы добавили две строчки в apllication.properties, чтобы у нас не улеатло все в одну партицию и мы могли подключать эффективно новых консьюмеров
*/