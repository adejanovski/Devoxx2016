package fr.devoxx.tia.PingService;

public class PingResponse {
	private String response;

	public PingResponse() {
	}

	public PingResponse(String resp) {
		response = resp;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

}
