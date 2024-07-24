package af.cmr.indyli.akdemia.ws.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import af.cmr.indyli.akdemia.business.dto.full.ParticularSubscriptionFullDTO;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.service.impl.ParticularSubscriptionServiceImpl;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import jakarta.annotation.Resource;

@RestController
@RequestMapping("/particular-subscription")
@CrossOrigin("*")
public class ParticularSubscriptionController {
	@Resource(name = ConstsValues.ServiceKeys.PARTICULAR_SUBSCRIPTION_SERVICE_KEY)
	private ParticularSubscriptionServiceImpl particularSubscriptionService;
	
	@GetMapping
	public ResponseEntity<List<ParticularSubscriptionFullDTO>> getAll() {
		return ResponseEntity.ok(ResponseEntity.ok(particularSubscriptionService.fullAllList()).getBody());
	}
		
	@PostMapping
	public ResponseEntity<ParticularSubscriptionFullDTO> create(@RequestBody ParticularSubscriptionFullDTO dto) throws AkdemiaBusinessException {
		return ResponseEntity.ok(particularSubscriptionService.create(dto));
	}
}
