package cfenv;

import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class CFEnvController {
	@Autowired
	private final Analytics analytics;

	@Autowired
	public CFEnvController(Analytics analytics) {
		this.analytics = analytics;
	}

	@RequestMapping("/")
	public CFEnv cfenv() {
		return new CFEnv(getInstanceFromEnv(), getVisits());
	}

	private String getInstanceFromEnv() {
		Map<String, String> env = System.getenv();
		return env.get("CF_INSTANCE_INDEX");
	}

	private String getVisits() {
		return analytics.getVisits();
	}
}
