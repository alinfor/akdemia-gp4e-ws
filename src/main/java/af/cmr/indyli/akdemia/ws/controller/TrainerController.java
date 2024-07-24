package af.cmr.indyli.akdemia.ws.controller;

import java.nio.file.AccessDeniedException;
import java.util.List;

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

import af.cmr.indyli.akdemia.business.dto.basic.TrainerBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.TrainerFullDTO;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.service.ITrainerService;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import af.cmr.indyli.akdemia.ws.utils.AkdemiaUrlBase;
import jakarta.annotation.Resource;

/**
 * RESTful controller to manage operations related to trainers.
 */
@RestController
@CrossOrigin(origins = AkdemiaUrlBase.url, maxAge = AkdemiaUrlBase.maxAge)
@RequestMapping("/trainers")
public class TrainerController {
	
	@Resource(name = ConstsValues.ServiceKeys.TRAINER_SERVICE_KEY)
	private ITrainerService trainerService;

	/**
	 * Retrieve the list of all trainers.
	 *
	 * @return ResponseEntity containing the list of trainers.
	 */
	@GetMapping
	public ResponseEntity<List<TrainerBasicDTO>> getAll() {
		return ResponseEntity.ok(trainerService.findAll());
	}
 
	/**
	 * Retrieve information about a trainer by their identifier.
	 *
	 * @param id The identifier of the trainer.
	 * @return ResponseEntity containing information about the trainer.
	 * @throws AkdemiaBusinessException If a business exception occurs.
	 */
	@GetMapping("/{id}")
	public ResponseEntity<TrainerFullDTO> getOne(@PathVariable int id) throws AkdemiaBusinessException {
		return ResponseEntity.ok(trainerService.findById(id));
	}

	/**
	 * Create a new trainer.
	 *
	 * @param dto Information about the trainer to create.
	 * @return ResponseEntity containing information about the newly created
	 *         trainer.
	 * @throws AkdemiaBusinessException If a business exception occurs.
	 */
	@PostMapping
	public ResponseEntity<TrainerFullDTO> create(@RequestBody TrainerFullDTO dto) throws AkdemiaBusinessException {
		return ResponseEntity.ok(trainerService.create(dto));
	}

	/**
	 * Update information about a trainer.
	 *
	 * @param id  The identifier of the trainer to update.
	 * @param dto The new information about the trainer.
	 * @return ResponseEntity containing the updated information of the trainer.
	 * @throws AkdemiaBusinessException If a business exception occurs.
	 * @throws AccessDeniedException    If access is denied.
	 */
	@PutMapping("/{id}")
	public ResponseEntity<TrainerFullDTO> update(@PathVariable int id, @RequestBody TrainerFullDTO dto)
			throws AkdemiaBusinessException, AccessDeniedException {
		return ResponseEntity.ok(trainerService.update(dto));
	}

	/**
	 * Delete a trainer by their identifier.
	 *
	 * @param id The identifier of the trainer to delete.
	 * @return ResponseEntity with an empty body indicating the trainer has been
	 *         successfully deleted.
	 * @throws AkdemiaBusinessException If a business exception occurs.
	 * @throws AccessDeniedException    If access is denied.
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) throws AkdemiaBusinessException, AccessDeniedException {
		trainerService.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
