package telran.java51;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.PollableBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import kotlin.contracts.Returns;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

//@SpringBootApplication
//public class KarafkaProducerApplication {
//	
//	Random random = new Random();
//
//	public static void main(String[] args) {
//		SpringApplication.run(KarafkaProducerApplication.class, args);
//	}
//	
//	//Будет отправлять сообщения формата Received: data #5 с рандомными числами
//	 @Bean
//	    Supplier<String> stringSupplier() {
//	        return () -> "data #"+ random.nextInt(10);
//	       
//	    }
//
//}


/*
 * Дальше мы добавили закрытие этого приложения, чтобы не нажимать каждый раз кнопку стопа
 * То есть тупо для удобства использования в учебных целях
 * 
 * Чтобы его закрыть, надо закрыть аппликационный контекст.
 * 
 * То есть у нас программа запускается, засыпает на полминнуты, в это время она сикдывает примерно 30 строчек, после этого просыпается и закрывается
 */
@SpringBootApplication
public class KarafkaProducerApplication {
	
	//Random random = new Random(); Закомментили после создания PulseService

	public static void main(String[] args) {
		
		
ConfigurableApplicationContext ctx = SpringApplication.run(KarafkaProducerApplication.class, args);

try {
	
	Thread.sleep(30_000);
	
} catch (InterruptedException e) {
	
	e.printStackTrace();
	
} finally {
	
	ctx.close();
}

	}
	
	//Будет отправлять сообщения формата Received: data #5 с рандомными числами
//	 @Bean
//	    Supplier<String> stringSupplier() {
//		 
//	        return () -> "data #"+ random.nextInt(10);
//	       
//	    }
	 
	 /*
	  * После добавления закрытия, мы решили к рандомным числам добавить еще и текущее время, чтобы потом считать интервал
	  */
	
//	 @Bean
//	    Supplier<String> stringSupplier() {
//		 
//	        return () -> "data#"+ random.nextInt(10)+ " "+System.currentTimeMillis();
//	       
//	    }
	
	/*
	 * Затем, чтобы передавать не  стринги, а объекты, мы написали классы PulseDto и PulseService
	 * 
	 * Мы закомментили код выше, когда добавили классы PulseDto и PulseService, так как теперь Bean мы передаем в PulseService
	 */

}