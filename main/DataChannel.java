import java.lang.reflect.Method;
import java.io.*;
import java.lang.Thread;
import java.util.ArrayList;
import java.nio.*; 
import java.util.*; 
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.*;






public class DataChannel {
	
	Object peer;
	RTCPeer obj;

	public DataChannel(Object peer, RTCPeer obj) {

		this.peer = peer;
		this.obj = obj;		
	}	
	
	public void createDataChannel(String s1) {
  
		this.obj.createDataChannel(this.peer, s1);
    }
	
	public byte[] readBinary() {
  
		byte[] val = this.obj.readBinary(this.peer);
		return val;
    }
	
	public String read() {
  
		byte[] val = this.obj.read(this.peer);
		String s1 = new String(val, StandardCharsets.UTF_8);
		s1 = s1.trim();
		return s1;
    }
	
	public int sendBinary(byte[] array, int arrayLen) {
  	
		int len = this.obj.sendBinary(this.peer, array, arrayLen);
		return len;
    }
	
	public int send(String s1) {
  	
		int len = this.obj.send(this.peer, s1);
		return len;
    }
	
	public int readyState() {
		
		int s1 = this.obj.getState(this.peer);
		return s1;
	}
}
	