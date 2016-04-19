package fr.devoxx.tia.PingService;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.jetty.http.HttpStatus;

import com.codahale.metrics.annotation.Timed;
import com.google.common.collect.Lists;

@Path("/")
public class PingResource {

	@GET
	@Path("ping")
	@Produces(MediaType.APPLICATION_JSON)
	@Timed
	public Response ping() {
		return Response.status(HttpStatus.OK_200).entity(new PingResponse("ping " + pong())).build();
	}

	@GET
	@Timed
	@Produces(MediaType.APPLICATION_JSON)
	@Path("pingFlood/{nbPings}")
	public Response ping(@PathParam("nbPings") int nbPings) throws Exception {
		return Response.status(HttpStatus.OK_200).entity(new PingResponse(pingFlood(nbPings))).build();
	}

	public String pingFlood(int nbPings) throws InterruptedException, ExecutionException {
		List<Future<String>> futures = Lists.newArrayList();
		for (int i = 0; i < nbPings; i++) {
			futures.add(new PongCommand().queue());
		}

		int j = 0;
		for (Future<String> future : futures) {
			System.out.println("ping " + future.get() + " " + j);
			j++;
		}

		return nbPings + " pings";


	}

	private String pong() {
		return new PongCommand().execute();
	}

}
