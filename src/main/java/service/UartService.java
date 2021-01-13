package service;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import dto.FireDTO;

@Service
public class UartService {
	
	@Autowired
	public DataOutputStream dataOutputStream;
	
	@Autowired
	public ObjectMapper objectMapper;
	
	public void sendNewFire(FireDTO fire) throws IOException {
		String temp = "new$" + objectMapper.writeValueAsString(fire) + "%";
		dataOutputStream.write(temp.getBytes());
	}
	
	public void updateFire(FireDTO fire) throws IOException {
		String temp = "update$" + objectMapper.writeValueAsString(fire) + "%";
		dataOutputStream.write(temp.getBytes());
	}
	
}
