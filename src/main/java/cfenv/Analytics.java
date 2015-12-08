package cfenv;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Component;

@Component
public class Analytics {
	private final StringRedisTemplate template;

	private final RedisAtomicLong visits;

	public Analytics(StringRedisTemplate template) {
		this.template = template;

		visits = new RedisAtomicLong("visits", template.getConnectionFactory());
	}

	public String getVisits() {
		return String.valueOf(visits.incrementAndGet());
	}
}