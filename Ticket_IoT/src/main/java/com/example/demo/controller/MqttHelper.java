package com.example.demo.controller;

import java.util.UUID;

import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.NodeDataDao;

@Controller
@RequestMapping("/mq")
public class MqttHelper {
	
	final String subscriptionTopic = "sensor/+";
	
	final String username = "lokejyzp";
    final String password = "6P08Ctz0rVD9";
    
    String splitAccel= "";
    String splitGyro= "";
    String splitLoc= "";
    String splitNode= "";
    
    @Autowired
    private NodeDataDao nodeDataDao;
    
    

	
	@RequestMapping("/mqtt")
	@ResponseBody
	private void startMqtt() {
		
		String publisherId = UUID.randomUUID().toString();
		try {	
			MqttClient client = new MqttClient("tcp://tailor.cloudmqtt.com:12658", publisherId);
			
			 MqttConnectOptions connOptions = new MqttConnectOptions();
			 connOptions.setUserName(username);
			 connOptions.setPassword(password.toCharArray());
			 client.connect(connOptions);
			 client.subscribe(subscriptionTopic);	 
			 
			 MqttMessage message = new MqttMessage();
			 message.setPayload("A single message".getBytes());
			 client.publish("pahodemo/test", message);
			
			 client.setCallback(new MqttCallbackExtended() {
				
	            @Override
	            public void connectComplete(boolean b, String s) {
	                System.out.println("mqtt"+ s);
	            }

	            @Override
	            public void connectionLost(Throwable throwable) {

	            }

	            @Override
	            public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
	                System.out.println("Mqtt Topic : "+ topic);
	                System.out.println("Mqtt PayLoad : "+ mqttMessage.toString());
	                System.out.println("Mqtt : " + topic + "/" + mqttMessage.toString());
	                String theTopic = topic.substring(7);
	                if(theTopic.equals("accelerometer")) {
	                	
	                	splitAccel = mqttMessage.toString();
	                	
	                }
	                if(theTopic.equals("gyroscope")) {
	                	
	                	splitGyro = mqttMessage.toString();
	                	
	                }
	                if( theTopic.equals("city")) {
	                	
	                	splitLoc = mqttMessage.toString();
	                	
	                }
	                if( theTopic.equals("node_id")) {
	                	
	                	splitNode = mqttMessage.toString();
	                	
	                }

	                if(splitAccel.length() > 2 && splitGyro.length() > 1 && splitLoc.length() > 1 && splitNode.length() > 1) {
	                	System.out.println("splits: "+ splitAccel);
	                	nodeDataDao.saveData(splitAccel,splitGyro,splitLoc,splitNode);
	                	splitAccel= "";
	                	splitGyro= "";
	                    splitLoc= "";
	                    splitNode= "";
	                }

	                	
	                 
	            }

	            @Override
	            public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

	            }
	        });
			
//			client.disconnect();
			
			

		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
	
}
