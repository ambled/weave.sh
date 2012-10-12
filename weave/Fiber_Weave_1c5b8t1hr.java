/*
 * Copyright 2012 Garth Johnson as Weave.sh
 * Copyright 2008-2010 Plura Processing, LP 
 *
 * This test headless client has all values hardcoded other than the optional clientId
 * If you are building this test for yourself, send a request to optin@weave.sh, a valid clientId will be returned to the same address as validation.
 * If you fail to register, work units completed will not be credited and revenue generated will be split between the pending non-profits
 * and weave.sh for development funding.
 */
package weave;

import java.util.Calendar;

//Partner library here: http://www.pluraprocessing.com/developer/downloads/plura-affiliate-app-connector.jar
import com.pluraprocessing.node.affiliate.desktop.JavaPluraConnector;
import com.pluraprocessing.node.exception.PluraInitializationException;
import com.pluraprocessing.node.exception.PluraIntervalException;
import com.pluraprocessing.node.exception.PluraLoadException;
import com.pluraprocessing.node.exception.PluraParameterException;
import com.pluraprocessing.node.exception.PluraStateException;

public class Fiber_Weave_1c5b8t1hr {

	/*
	 * This method tests JavaPluraConnector functionality for Java Applications and Java Signed Applets
	 */
	public static void main(String[] args) {

		JavaPluraConnector plura = null;

		//Hardcoded test client id pending registration system being online
		String FiberAnchor = "1c5b8t1hr";
		String FiberId     = FiberAnchor + "-";

		//Allow testers to append their own identifier for their processing records so we can total completed units
		if (args.length > 1) {
			System.err.println("The Fiber only accepts a single string as an optional identifier\n");
			System.exit(1);
		} 
		//Make sure we limit client id to a valid length
		if (args.length > 0) {
			String firstArg = args[0];
			try {
				if (firstArg.length() < (40 - FiberId.length())) {
					FiberId += firstArg;
				} else {
					FiberId += args[0].substring(0,40-(FiberId.length()));
				}
			} catch (Exception e) {
				System.err.println("Unable to append optional identifier " + firstArg + " to FiberId " + FiberAnchor);
				System.err.println("Exception: " + e.getMessage());
				System.exit(1);
			}
		}
		
		try {
			//instantiate new JavaPluraConnector with test affiliate id = d45f5668-672a-105a-80ab-fa23fc6ac15d, cpu percentage = .5, 
			//bandwidth percentage = .8, client id = FiberId, max plura threads = 1 (to use 1 cores on a computer)
			plura = new JavaPluraConnector("d45f5668-672a-105a-80ab-fa23fc6ac15d", .5, .8, FiberId, 1); 
			
			System.out.println("start Plura with FiberId: " + FiberId); 
			plura.start(); //start Plura at 80% bandwidth usage, 50% cpu usage, and 1 Plura threads max
			
			Thread.sleep(3600000); // 360 seconds = 360 000 milliseconds
	
			System.out.println("stop Plura"); 
			plura.stop(); //stop Plura

		} 
		catch (PluraInitializationException e) {
			e.printStackTrace(System.out);
		} 
		catch (InterruptedException e) {
			e.printStackTrace(System.out);
		} 
		catch (PluraLoadException e) {
			e.printStackTrace(System.out);
		} 
		catch (PluraParameterException e) {
			e.printStackTrace(System.out);
		} 
		catch (PluraStateException e) {
			e.printStackTrace(System.out);
		}
		finally {
			if (plura != null) {
				plura.stop(); //Stop Plura before the application exits (even if it exits on error) so that Plura threads are not abandoned.
			}
		}
	}

}




