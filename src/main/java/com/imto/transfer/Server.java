package com.imto.transfer;

import org.apache.log4j.Logger;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;

import com.imto.transfer.scheduler.TrasferStatusCheckerScheduler;
import com.imto.transfer.utils.PropsCache;

import io.undertow.Undertow;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;



public class Server 
{
	private static Logger _log = Logger.getLogger(Server.class);

    public static void main( String[] args )
    {
    	
    			// Get Host
    			String host = PropsCache.getInstance().getProperty("HOST");
    			
    			// Get Port
    			int port = Integer.parseInt(PropsCache.getInstance().getProperty("PORT"));
    			
    			// Create the JAXRS Server
    			UndertowJaxrsServer server = new UndertowJaxrsServer();
    			Undertow.Builder serverBuilder = Undertow.builder().addHttpListener(port, host);
    			server.start(serverBuilder);

    			// Create the deployment
    			ResteasyDeployment deployment = new ResteasyDeployment();
    			deployment.setApplicationClass(TransferApplication.class.getName());
    			deployment.setInjectorFactoryClass(org.jboss.resteasy.cdi.CdiInjectorFactory.class.getName());

    			// Configure the deployment info
    			String genReqPath = "/api/v1";
    			String contextPath= PropsCache.getInstance().getProperty("CONTEXT_PATH");
    			DeploymentInfo di = server.undertowDeployment(deployment, genReqPath);
    		
    			di.setClassLoader(Server.class.getClassLoader()).setContextPath(contextPath).setDeploymentName("TxnApp");

    			// Add CDI listener
    			di.addListeners(Servlets.listener(org.jboss.weld.environment.servlet.Listener.class));

    			// Deploy the API
    			server.deploy(di);
    			
    			_log.info("TransactionWS started on " + host + ":" + port+contextPath+genReqPath);
    			System.out.println("TransactionWS started on " + host + ":" + port+contextPath+genReqPath);
    			
    			TrasferStatusCheckerScheduler scheduler = new TrasferStatusCheckerScheduler();
    			
    			 try {
    				 scheduler.run();
				} catch (Exception e) {
					e.printStackTrace();
				}

			
			    
    }
    
    
}
