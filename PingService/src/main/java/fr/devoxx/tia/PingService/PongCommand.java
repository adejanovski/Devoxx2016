package fr.devoxx.tia.PingService;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class PongCommand extends HystrixCommand<String>{
	protected PongCommand() {
		super(HystrixCommandGroupKey.Factory.asKey("PongCommand"));
	}

	@Override
	protected String run() throws Exception {
		return PongClient.getInstance().pong();

	}
	
	@Override
	protected String getFallback() {
		return "fallback";
	}

}
