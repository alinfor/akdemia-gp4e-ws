package af.cmr.indyli.akdemia.ws.controller;

import java.nio.file.AccessDeniedException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import af.cmr.indyli.akdemia.business.dto.full.IntraSessionFullDTO;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.service.IIntraSessionService;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import jakarta.annotation.Resource;
@RestController
@RequestMapping("/intra-session")
@CrossOrigin("*")
public class IntraSessionController {
	@Resource(name = ConstsValues.ServiceKeys.INTRA_SESSION_SERVICE_KEY)
	private IIntraSessionService intraSessionService;
	
	@GetMapping
	public ResponseEntity<List<IntraSessionFullDTO>> getAll() {
		return ResponseEntity.ok(ResponseEntity.ok(intraSessionService.fullAllList()).getBody());
	}
		
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) throws AkdemiaBusinessException, AccessDeniedException {
		intraSessionService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
