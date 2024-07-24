package af.cmr.indyli.akdemia.ws.controller;

import java.nio.file.AccessDeniedException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import af.cmr.indyli.akdemia.business.dto.basic.SessionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.CompanyFullDTO;
import af.cmr.indyli.akdemia.business.dto.full.EmployeeFullDTO;
import af.cmr.indyli.akdemia.business.dto.full.SessionFullDTO;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.service.ISessionService;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import jakarta.annotation.Resource;

@RestController
@RequestMapping("/session")
@CrossOrigin("*")
public class SessionController {


	@Resource(name = ConstsValues.ServiceKeys.SESSION_SERVICE_KEY)
	private ISessionService sessionService;
	
	@GetMapping
	public ResponseEntity<List<SessionFullDTO>> getAll() {
		return ResponseEntity.ok(ResponseEntity.ok(sessionService.fullAllList()).getBody());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<SessionFullDTO> getSessionById(@PathVariable Integer id) throws AkdemiaBusinessException {
		SessionFullDTO sessionDTO = sessionService.findById(id);
		return new ResponseEntity<>(sessionDTO, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<SessionFullDTO> create(@RequestBody SessionFullDTO dto) throws AkdemiaBusinessException {
		return ResponseEntity.ok(sessionService.create(dto));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<SessionFullDTO> update(@PathVariable int id, @RequestBody SessionFullDTO dto)
			throws AccessDeniedException, AkdemiaBusinessException {
		return ResponseEntity.ok(sessionService.update(dto));
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) throws AkdemiaBusinessException, AccessDeniedException {
		sessionService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
