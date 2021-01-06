package service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.FireDTO;
import uart.SerialPortConnector;

@Service
public class UartService {
	
	@Autowired
	public SerialPortConnector serialPortConnector;
	
	public void sendNewFire(FireDTO fire) throws IOException {
		serialPortConnector.sendMessage("test");
	}
	
	public void updateFire(FireDTO fire) throws IOException {
		serialPortConnector.sendMessage("test2");
	}
	
	
}
