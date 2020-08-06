package com.pokhrel.jms;

import java.util.Properties;

import javax.naming.*;
import javax.jms.*;

public class SampleTopicPublisher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	try{	
		// get the initial context
		 Properties env = new Properties( );
		   env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
		   env.put(Context.PROVIDER_URL, "jnp://localhost:1099");
		   env.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
		   InitialContext ctx = new InitialContext(env);
		                                                                   
	       // lookup the topic object
	       Topic topic = (Topic) ctx.lookup("topic/testTopic");
	                                                                          
	       // lookup the topic connection factory
	       TopicConnectionFactory connFactory = (TopicConnectionFactory) ctx.
	           lookup("TopicConnectionFactory");
	                                                                          
	       // create a topic connection
	       TopicConnection topicConn = connFactory.createTopicConnection();
	                                                                          
	       // create a topic session
	       TopicSession topicSession = topicConn.createTopicSession(false, 
	           Session.AUTO_ACKNOWLEDGE);
	                                                                          
	       // create a topic publisher
	       TopicPublisher  topicPublisher = topicSession.createPublisher(topic);
	       topicPublisher.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	                                                                          
	       // create the "Hello World" message
	       TextMessage message = topicSession.createTextMessage();
	       message.setText("Hello World");
	                                                                          
	       // publish the messages
	       topicPublisher.publish(message);
	}catch(Exception ex){
		ex.printStackTrace();
	}

	}

}
