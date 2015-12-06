package cfenv;

public class CFEnv {
	private final String instance;

	public CFEnv(String instance) {
		this.instance = instance;
	}

	public String getInstance() {
		return instance;
	}
}