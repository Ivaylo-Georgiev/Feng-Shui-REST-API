package com.fmi.fengshuirestapi.app.rpc;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.fmi.fengshuirestapi.pojo.RPCParameters;
import com.fmi.fengshuirestapi.util.FengShuiDetailsUtil;
import com.google.gson.Gson;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class RPCServer {

	private static final String RPC_QUEUE_NAME = "rpc_queue";
	private static final String HOST = "localhost";
	private static final String ENCODING = "UTF-8";

	public void establishRPCServerSide() throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(HOST);

		try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
			channel.queueDeclare(RPC_QUEUE_NAME, false, false, false, null);
			channel.queuePurge(RPC_QUEUE_NAME);

			channel.basicQos(1);

			Object monitor = new Object();
			DeliverCallback deliverCallback = (consumerTag, delivery) -> {
				AMQP.BasicProperties replyProps = new AMQP.BasicProperties.Builder()
						.correlationId(delivery.getProperties().getCorrelationId()).build();

				String response = "";

				try {
					String message = new String(delivery.getBody(), ENCODING);
					RPCParameters params = new Gson().fromJson(message, RPCParameters.class);
					response += FengShuiDetailsUtil.fengShuiDetails(params.getYear(), params.getHour(),
							params.getGender());
				} catch (RuntimeException e) {
					System.out.println(" [.] " + e.toString());
				} finally {
					channel.basicPublish("", delivery.getProperties().getReplyTo(), replyProps,
							response.getBytes(ENCODING));
					channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
					// RabbitMq consumer worker thread notifies the RPC server owner thread
					synchronized (monitor) {
						monitor.notify();
					}
				}
			};

			channel.basicConsume(RPC_QUEUE_NAME, false, deliverCallback, (consumerTag -> {
			}));
			// Wait and be prepared to consume the message from RPC client.
			while (true) {
				synchronized (monitor) {
					try {
						monitor.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
