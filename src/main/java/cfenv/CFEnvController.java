package cfenv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CFEnvController {

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
