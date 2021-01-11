package com.fmi.fengshuirestapi.app;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.fmi.fengshuirestapi.app.rpc.RPCServer;

@Component
public class AppStartupRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		new RPCServer().establishRPCServerSide();
	}

}