package config;

import java.io.DataOutputStream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import gnu.io.NRSerialPort;

@Configuration
public class UartConfig {

	@Bean
	public DataOutputStream dataOutputStream() {
    	int baudRate = 115200;
    	NRSerialPort serial = new NRSerialPort("COM5", baudRate);
    	serial.connect();
    	return new DataOutputStream(serial.getOutputStream());
	}
	
	
}
