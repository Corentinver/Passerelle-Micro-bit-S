package controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dto.FireDTO;
import service.UartService;

@RestController
public class UartController {

	@Autowired
	public UartService uartService;
	
	@PostMapping("/newFire")
	public void newFire(@RequestBody FireDTO fire) throws IOException {
		
		uartService.sendNewFire(fire);
	}
	
	@PostMapping("/updateIncendie")
	public void updateFire(@RequestBody FireDTO fire) throws IOException {
		uartService.updateFire(fire);
	}
	
}
