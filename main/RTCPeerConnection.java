import java.lang.reflect.Method;
import java.io.*;
import java.lang.Thread;
import java.util.ArrayList;
import java.nio.*; 
import java.util.*; 
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.*;





public class RTCPeerConnection {
  
	Object peer;
	RTCPeer obj;

	public RTCPeerConnection(String stun) {
		
		this.obj = new RTCPeer();
		this.peer = this.obj.createPeer();
		
		String defaultStr = "stun:stun.l.google.com:19302";
		
		if(stun == null) {
			
			this.obj.setStunServer(this.peer, stun);
		}
		else {
			
			this.obj.setStunServer(this.peer, "stun:stun.l.google.com:19302");
		}
		
		this.obj.createPeerConnection(this.peer);
	}
	
	public void setRemoteDescriptionOffer(String s1) {
	
		this.obj.parseSessionDescription(this.peer, "offer", s1);
	}
	
	public void setRemoteDescriptionAnswer(String s1) {
	
		this.obj.parseSessionDescription(this.peer, "answer", s1);
	}
	
	public void createAnswer() {
	
		this.obj.createSessionDescription(this.peer, "answer");
	}
	
	public void createOffer() {
	
		this.obj.createSessionDescription(this.peer, "offer");
	}
	
	public void addIceCandidate(String s1) {
	
		this.obj.addIceCandidate(this.peer, s1);
	}
	
	public String readDebugMessage() {

		byte[] val = this.obj.readDebugMessage(this.peer);
		String s1 = new String(val, StandardCharsets.UTF_8);
		s1 = s1.trim();
		return s1;
	}
	
	public String readSessionDescription() {

		byte[] val = this.obj.readSessionDescription(this.peer);
		String s1 = new String(val, StandardCharsets.UTF_8);
		s1 = s1.trim();
		return s1;
	}
	
	public String readIceCandidate() {

		byte[] val = this.obj.readIceCandidate(this.peer);
		String s1 = new String(val, StandardCharsets.UTF_8);
		s1 = s1.trim();
		return s1;
	}
	
	public void close() {

		this.obj.close(this.peer);
	}
}