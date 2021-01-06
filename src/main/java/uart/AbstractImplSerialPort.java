package uart;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TooManyListenersException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.adventurer.springserialport.connector.AbstractSpringSerialPortConnector;
import com.adventurer.springserialport.connector.SpringSerialPortConnector;
import com.adventurer.springserialport.connector.properties.SerialPortProperties;

import gnu.io.NRSerialPort;
import gnu.io.NoSuchPortException;
import gnu.io.SerialPortEvent;

public abstract class AbstractImplSerialPort implements SpringSerialPortConnector  {
	
	 private final Logger log = LoggerFactory.getLogger(this.getClass());

	    private BufferedReader input;

	    private NRSerialPort serial;


	    @PostConstruct
	    public void connect() throws TooManyListenersException, NoSuchPortException {
	        log.info("Connection PostConstruct callback: connecting ...");

	        serial = new NRSerialPort("", 9600);
	        serial.connect();

	        if (serial.isConnected()) {
	            log.info("Connection opened!");
	        } else {
	            throw new RuntimeException("Is not possible to open connection in port");
	        }
	        serial.addEventListener(this);
	        serial.notifyOnDataAvailable(true);
	        input = new BufferedReader(new InputStreamReader(serial.getInputStream()));
	    }

	    @PreDestroy
	    public void disconnect() {

	        log.info("Connection PreDestroy callback: disconnecting ...");

	        if (serial != null && serial.isConnected()) {
	            serial.disconnect();

	            if (!serial.isConnected()) {
	                log.info("Connection closed!");
	            }
	        }
	    }


	    @Override
	    public synchronized void sendMessage(String message) throws IOException {
	        DataOutputStream stream = new DataOutputStream(serial.getOutputStream());
	        stream.write(message.getBytes());
	    }

	    @Override
	    public synchronized void serialEvent(SerialPortEvent serialPortEvent) {
	        if (serialPortEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
	            try {
	                if (input.ready()) {
	                    processData(input.readLine());
	                }

	            } catch (Exception e) {
	                log.error("Error ", e);
	            }
	        }
	    }

	    /**
	     * This method must implemented with logic that you want execute at the moment to read
	     * information from the serial port
	     *
	     * @param line input data that comes from Serial port
	     */
	    public abstract void processData(String line);
}
