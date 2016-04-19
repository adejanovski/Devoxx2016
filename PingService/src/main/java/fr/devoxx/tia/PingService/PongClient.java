package fr.devoxx.tia.PingService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;

public class PongClient {
	
	private PongClient() {};
		
	private static class Holder {
			private static PongClient INSTANCE = new PongClient();
		}
		
	public static PongClient getInstance() {
			return Holder.INSTANCE;
		}
	
	
	interface PongFeignClient{
		@GET
		@Timed
		@Path("pong")
		@Produces(MediaType.APPLICATION_JSON)
		public PongResponse pong();
	}
	
	public String pong() {
		PongFeignClient client = Feign.builder()
									.contract(new JAXRSContract())
									.decoder(new JacksonDecoder())
									.encoder(new JacksonEncoder())									
									.target(PongFeignClient.class, "http://127.0.0.1:8081");

		PongResponse result = client.pong();

		return result.getResponse();
	}

}
