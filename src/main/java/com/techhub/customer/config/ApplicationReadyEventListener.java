package com.techhub.customer.config;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * The startup code that run after application startup
 * 
 * @author ramniwash
 * @since 1.0.0
 */
@Component
public class ApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent> {

	/** The LOGGER Constant */
	private static final Logger LOGGER = LogManager.getLogger(ApplicationReadyEventListener.class);

	/** The WELCOME_MSG Constant */
	public static final String WELCOME_LINE = "                       WELCOME TO WebMVCDemo                        ";

	/** The LINE Constant */
	public static final String LINE = "---------------------------------------------------------------------";

	/** The NEW_LINE Constant */
	private static final String NEW_LINE = "\n";

	/** The HOST Constant */
	private static final String HOST = "HOST";

	/** The ONE_SPACE Constant */
	private static final String ONE_SPACE = " ";

	/** The COLON Constant */
	private static final String COLON = ":";

	@Value("${server.port}")
	private String serverPort;

	@Value("${server.servlet.context-path}")
	private String contextPath;

	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {
		StringBuilder hosts = new StringBuilder(NEW_LINE);
		hosts.append(LINE);
		hosts.append(NEW_LINE);
		hosts.append(WELCOME_LINE);
		hosts.append(NEW_LINE);
		hosts.append(LINE);
		try {
			Enumeration<NetworkInterface> enumerationNW = NetworkInterface.getNetworkInterfaces();
			while (enumerationNW.hasMoreElements()) {
				NetworkInterface networkInterface = (NetworkInterface) enumerationNW.nextElement();
				Enumeration<InetAddress> enumeration = networkInterface.getInetAddresses();
				while (enumeration.hasMoreElements()) {
					InetAddress inetAddress = (InetAddress) enumeration.nextElement();
					hosts.append(NEW_LINE).append(HOST)
							.append(ONE_SPACE).append(COLON)
							.append(ONE_SPACE).append(inetAddress.getHostAddress())
							.append(COLON).append(serverPort)
							.append(contextPath);

				}
				hosts.append(NEW_LINE);
				hosts.append(LINE);
			}
		} catch (Exception e) {
			LOGGER.log(Level.FATAL, e.getMessage(), e);
		}
		System.out.println(hosts);
	}
}