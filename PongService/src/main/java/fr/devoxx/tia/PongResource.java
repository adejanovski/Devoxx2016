package fr.devoxx.tia;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.jetty.http.HttpStatus;

import com.codahale.metrics.annotation.Timed;

@Path("/")
public class PongResource {
	
	public static int sleepTime=0;

	@GET
	@Timed
	@Path("pong")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pong() throws InterruptedException{		
		return Response.status(HttpStatus.OK_200).entity(PongService.getInstance().pong()).build();
		
	}
	
	
	@GET
	@Timed
	@Path("setSleep/{sleepDuration}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setSleep(@PathParam("sleepDuration") int sleepDuration){				
		PongResource.sleepTime = sleepDuration;
		return Response.status(HttpStatus.OK_200).entity("Sleep = " + PongResource.sleepTime + "ms").build();
	}
	

}
