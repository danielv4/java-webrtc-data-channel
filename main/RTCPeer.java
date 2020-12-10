import java.lang.reflect.Method;
import java.io.*;
import java.lang.Thread;
import java.util.ArrayList;
import java.nio.*; 
import java.util.*;








class RTCPeer {

    static {
		System.loadLibrary("rtcpeerjava");
    }

	public static native Object createPeer();
	public static native void setStunServer(Object obj, String s1);
	public static native void createPeerConnection(Object obj);
	public static native void createSessionDescription(Object obj, String s1);
	public static native void parseSessionDescription(Object obj, String s1, String s2);
	public static native void addIceCandidate(Object obj, String s1);
	public static native void createDataChannel(Object obj, String s1);
	public static native int getState(Object obj);
	public static native int sendBinary(Object obj, byte[] array, int arrayLen);
	public static native int send(Object obj, String s1);
	public static native byte[] readDebugMessage(Object obj);
	public static native byte[] readSessionDescription(Object obj);
	public static native byte[] readIceCandidate(Object obj);
	public static native byte[] readBinary(Object obj);
	public static native byte[] read(Object obj);
	public static native void close(Object obj);
}














