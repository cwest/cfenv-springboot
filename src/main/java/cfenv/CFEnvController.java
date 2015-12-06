package cfenv;

import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CFEnvController {
	@RequestMapping("/")
	public CFEnv cfenv() {
		return new CFEnv(getInstanceFromEnv());
	}

	private String getInstanceFromEnv() {
		Map<String, String> env = System.getenv();
		return env.get("CF_INSTANCE_INDEX");
	}
}
