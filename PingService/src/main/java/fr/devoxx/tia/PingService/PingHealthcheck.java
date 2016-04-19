package fr.devoxx.tia.PingService;

import com.codahale.metrics.health.HealthCheck;

public class PingHealthcheck extends HealthCheck {

	@Override
	protected Result check() throws Exception {

		if (!new PongCommand().execute().contains("fallback")) {
			return Result.healthy();
		}
		return Result.unhealthy("Oh la la, ca marche pas !!!");

	}

}
