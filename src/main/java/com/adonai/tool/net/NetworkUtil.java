package com.adonai.tool.net;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;

public abstract class NetworkUtil {
	/**
	 * <pre>
	 * Performance Test No. 1
	 * </pre>
	 * 
	 * @param address
	 * @return
	 */
	public static boolean internetTest(String address) {
		try {
			URL url = new URL("http://" + address);
			URLConnection connection = url.openConnection();
			connection.connect();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * <pre>
	 * Performance Test No. 2
	 * </pre>
	 * 
	 * @param address
	 * @param port
	 * @param timeout
	 * @return
	 */
	public static boolean internetTest(String address, int port, int timeout) {
		try (Socket sock = new Socket();) {
			sock.connect(new InetSocketAddress(address, port), timeout);
			return sock.isConnected();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * <pre>
	 * Performance Test No. 3
	 * <code>ping</code>을 던졌다 받기까지 같음(속도가 많이 느림)
	 * </pre>
	 * 
	 * @param address
	 * @return
	 */
	public static boolean pingTest(String address) {
		try {
			if (java.lang.Runtime.getRuntime().exec("ping " + address).waitFor() == 0) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
}
