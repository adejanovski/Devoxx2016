package fr.devoxx.tia.PingService;

import org.apache.commons.configuration.MapConfiguration;

import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.contrib.codahalemetricspublisher.HystrixCodaHaleMetricsPublisher;
import com.netflix.hystrix.strategy.HystrixPlugins;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class PingApplication extends Application<PingConfiguration>{
	
	public static void main(String[] args) throws Exception {
		new PingApplication().run(args);
	}

	@Override
	public void initialize(Bootstrap<PingConfiguration> bootstrap) {
	}

	@Override
	public void run(PingConfiguration configuration, Environment env) throws Exception {
		// Configuration des commandes Hystrix
		ConfigurationManager.install(new MapConfiguration(configuration.getDefaultHystrixConfig()));

		// Ajout des métriques Hystrix à celle de dropwizard
		HystrixPlugins.getInstance().registerMetricsPublisher(new HystrixCodaHaleMetricsPublisher(env.metrics()));

		
		final PingHealthcheck healthcheck = new PingHealthcheck();
		
		env.healthChecks().register("Appel pong", healthcheck);
		
		PingResource resource = new PingResource();
		env.jersey().register(resource);
	}

}
