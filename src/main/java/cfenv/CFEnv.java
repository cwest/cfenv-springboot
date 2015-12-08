package cfenv;

public class CFEnv {
	private final String instance;
	private final String visits;

	public CFEnv(String instance, String visits) {
		this.instance = instance;
		this.visits = visits;
	}

	public String getInstance() {
		return instance;
	}

	public String getVisits() {
		return visits;
	}
}