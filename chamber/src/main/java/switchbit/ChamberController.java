package switchbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/chamber")
public class ChamberController {

	private static final Logger LOG = LoggerFactory.getLogger(ChamberController.class);

	@Value("${spring.application.name}")
	private String name;

	@PostMapping
	String echo(@RequestBody String message) {
		LOG.error("Echoing message: {}", message);

		return String.format("%s... %s.. %s <- %s", message.toUpperCase(), message,
				message.toLowerCase(), name);
	}
}
