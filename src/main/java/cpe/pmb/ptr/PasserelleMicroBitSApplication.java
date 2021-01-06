package cpe.pmb.ptr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"uart", "controller", "service", "config"})
@EnableAutoConfiguration
public class PasserelleMicroBitSApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasserelleMicroBitSApplication.class, args);
	}

}
