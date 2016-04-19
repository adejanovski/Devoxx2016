package fr.devoxx.tia;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class PongApplication extends Application<PongConfiguration> {
	
	public static void main(String[] args) throws Exception {
        new PongApplication().run(args);
    }
	
	@Override
    public void initialize(Bootstrap<PongConfiguration> bootstrap) {
    }
	
	@Override
	public void run(PongConfiguration configuration, Environment env) throws Exception {
		
		PongResource pongResource = new PongResource();		
		env.jersey().register(pongResource);
		
	}
	
	

}
