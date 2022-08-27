// javac Main.java
// jar cvfe main.jar Main *.class
// java -jar main.jar
import java.lang.reflect.Method;
import java.io.*;
import java.lang.Thread;
import java.util.ArrayList;
import java.nio.*; 
import java.util.*; 
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.*;


// somedata


public class Main {
	
    public static void main(String[] args) {
	
	
		Base64.Decoder dec = Base64.getDecoder();
		Base64.Encoder enc = Base64.getEncoder();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Command List");
		System.out.println("	--addSdp=base64");
		System.out.println("	--addIce=base64");
		System.out.println("	--getStatus=check");
		System.out.println("	--sendText=text");
	
	
		// start webrtc connection
		String stun = "stun:stun.l.google.com:19302";
		
		RTCPeerConnection connection = new RTCPeerConnection(stun);
		
		DataChannel channel = new DataChannel(connection.peer, connection.obj);
		
		channel.createDataChannel("channel321");
		
		connection.createOffer();	
	
	
		// read sdp and ice
		for (int w = 0; w < 10; w++) {
		
			String s1 = connection.readIceCandidate();
			String s2 = connection.readSessionDescription();	
			
			if(s1.length() > 0) {
		
				String encoded = enc.encodeToString(s1.getBytes());
				System.out.println("type base64 ice into browser");
				System.out.println(encoded);
			}

			if(s2.length() > 0) {

				String encoded = enc.encodeToString(s2.getBytes());
				System.out.println("type base64 sdp offer into browser");
				System.out.println(encoded);
			}
			
			try {
				Thread.sleep(1000);
			}
			catch(Exception e) {
				
			}
		}
	
	
		// interactive input
		while(true) {
			
			// 
			System.out.println("type command:");
			String line = scanner.nextLine();
			line = line.substring(2);
			String []list = line.split("=");
			
			if(list[0].equals("addSdp") == true) {
				
				String sdp = new String(dec.decode(list[1]));
				connection.setRemoteDescriptionAnswer(sdp);
			}
			else if(list[0].equals("addIce") == true) {
				
				String ice = new String(dec.decode(list[1]));
				connection.addIceCandidate(ice);
			}
			else if(list[0].equals("getStatus") == true) {
				
				String s1 = connection.readDebugMessage();
				System.out.println(s1);
			}
			else if(list[0].equals("sendText") == true) {
				
				int stat = channel.readyState();
				if(stat == 1) {
					
					channel.send(list[1]);
				}
			}
		}
    }
}







