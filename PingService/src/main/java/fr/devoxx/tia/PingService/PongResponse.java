package fr.devoxx.tia.PingService;

public class PongResponse {
	
	private String response;

	public PongResponse() {	
	}
	
	public PongResponse(String resp) {
		response = resp;
	}

	public String getResponse() {
		return response;
	}

}
