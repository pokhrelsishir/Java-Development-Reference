package com.pokhrel.jms;

import java.util.Properties;

import javax.naming.*;
import javax.jms.*;

public class SampleTopicSubcriber  implements MessageListener,ExceptionListener {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
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
		           //lookup("topic/connectionFactory");
		       lookup("TopicConnectionFactory");
		                                                                          
		       // create a topic connection
		       TopicConnection topicConn = connFactory.createTopicConnection();
		                                                                          
		       // create a topic session
		       TopicSession topicSession = topicConn.createTopicSession(false,
		           Session.AUTO_ACKNOWLEDGE);
		                                                                          
		       // create a topic subscriber
		       TopicSubscriber topicSubscriber = topicSession.createSubscriber(topic);
		                                                                          
		       // set an asynchronous message listener
		       SampleTopicSubcriber asyncSubscriber = new SampleTopicSubcriber();
		       topicSubscriber.setMessageListener(asyncSubscriber);
		                                                                          
		       // set an asynchronous exception listener on the connection
		       topicConn.setExceptionListener(asyncSubscriber);
		                                                                          
		       // start the connection
		       topicConn.start();
		                                                                          
		       // wait for messages
		       System.out.print("waiting for messages");
		       for (int i = 0; i < 100000; i++) {
		          Thread.sleep(5000);
		          System.out.print(".");
		       }
		       System.out.println();
		                                                                          
		       // close the topic connection
		       topicConn.close();
		}catch(Exception ex){
			
			ex.printStackTrace();
		}

	}

    
    /**
       This method is called asynchronously by JMS when a message arrives
       at the topic. Client applications must not throw any exceptions in
       the onMessage method.
       @param message A JMS message.
     */
    public void onMessage(Message message)
    {
       TextMessage msg = (TextMessage) message;
       try {
    	   
    	  System.out.println("Message Received: " + msg.getText());
       } catch (JMSException ex) {
          ex.printStackTrace();
       }
    }
                                                                           
    /**
       This method is called asynchronously by JMS when some error occurs.
       When using an asynchronous message listener it is recommended to use
       an exception listener also since JMS have no way to report errors
       otherwise.
       @param exception A JMS exception.
     */
    public void onException(JMSException exception)
    {
       System.err.println("Exception Raised: " + exception);
    }

	
}
