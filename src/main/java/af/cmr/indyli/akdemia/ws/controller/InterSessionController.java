package af.cmr.indyli.akdemia.ws.controller;

import java.nio.file.AccessDeniedException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import af.cmr.indyli.akdemia.business.dto.full.InterSessionFullDTO;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.service.IInterSessionService;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import jakarta.annotation.Resource;
@RestController
@RequestMapping("/inter-session")
@CrossOrigin("*")
public class InterSessionController {

	@Resource(name = ConstsValues.ServiceKeys.INTER_SESSION_SERVICE_KEY)
	private IInterSessionService interSessionService;
	
	@GetMapping
	public ResponseEntity<List<InterSessionFullDTO>> getAll() {
		return ResponseEntity.ok(ResponseEntity.ok(interSessionService.fullAllList()).getBody());
	}
		
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) throws AkdemiaBusinessException, AccessDeniedException {
		interSessionService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
