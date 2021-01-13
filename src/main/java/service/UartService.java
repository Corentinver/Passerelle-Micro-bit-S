package service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import dto.FireDTO;
import uart.SerialPortConnector;

@Service
public class UartService {
	
	@Autowired
	public SerialPortConnector serialPortConnector;
	
	@Autowired
	public ObjectMapper objectMapper;
	
	public void sendNewFire(FireDTO fire) throws IOException {
		serialPortConnector.sendMessage("new$" + objectMapper.writeValueAsString(fire));
	}
	
	public void updateFire(FireDTO fire) throws IOException {
		serialPortConnector.sendMessage("update$" + objectMapper.writeValueAsString(fire));
	}
	
	
}
