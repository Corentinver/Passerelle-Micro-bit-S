package cpe.pmb.ptr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"controller", "uart", "service"})
public class PasserelleMicroBitSApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasserelleMicroBitSApplication.class, args);
	}

}
