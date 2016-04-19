package fr.devoxx.tia;

public class PongService {
	
	private PongService() {};
			
	private static class PongServiceHolder {
		private static PongService INSTANCE = new PongService();
	}
	
	public static PongService getInstance() {
		return PongServiceHolder.INSTANCE;
	}
	
	
	public PongResponse pong() throws InterruptedException {
		Thread.sleep(PongResource.sleepTime);
		return new PongResponse("pong");
	}

}
