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

import af.cmr.indyli.akdemia.business.dto.basic.TrainingBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.TrainingFullDTO;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.service.ITrainingService;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import af.cmr.indyli.akdemia.ws.utils.AkdemiaUrlBase;
import jakarta.annotation.Resource;

/**
 * RESTful controller to manage operations related to training sessions.
 */
@RestController
@CrossOrigin(origins = AkdemiaUrlBase.url, maxAge = AkdemiaUrlBase.maxAge)
@RequestMapping("/training")
public class TrainingController {
	
	@Resource(name = ConstsValues.ServiceKeys.TRAINING_SERVICE_KEY)
	private ITrainingService trainingService;

	/**
	 * Retrieve the list of all training sessions.
	 *
	 * @return ResponseEntity containing the list of training sessions.
	 */
	@GetMapping
	public ResponseEntity<List<TrainingBasicDTO>> getAll() {
		return ResponseEntity.ok(trainingService.findAll());
	}

	/**
	 * Retrieve information about a training session by its identifier.
	 *
	 * @param id The identifier of the training session.
	 * @return ResponseEntity containing information about the training session.
	 * @throws AkdemiaBusinessException If a business exception occurs.
	 */
	@GetMapping("/{id}")
	public ResponseEntity<TrainingFullDTO> getOne(@PathVariable int id) throws AkdemiaBusinessException {
		return ResponseEntity.ok(trainingService.findById(id));
	}

	/**
	 * Create a new training session.
	 *
	 * @param dto Information about the training session to create.
	 * @return ResponseEntity containing information about the newly created
	 *         training session.
	 * @throws AkdemiaBusinessException If a business exception occurs.
	 */
	@PostMapping
	public ResponseEntity<TrainingFullDTO> create(@RequestBody TrainingFullDTO dto) throws AkdemiaBusinessException {
		return ResponseEntity.ok(trainingService.create(dto));
	}

	/**
	 * Update information about a training session.
	 *
	 * @param id  The identifier of the training session to update.
	 * @param dto The new information about the training session.
	 * @return ResponseEntity containing the updated information of the training
	 *         session.
	 * @throws AkdemiaBusinessException If a business exception occurs.
	 * @throws AccessDeniedException    If access is denied.
	 */
	@PutMapping("/{id}")
	public ResponseEntity<TrainingFullDTO> update(@PathVariable int id, @RequestBody TrainingFullDTO dto)
			throws AkdemiaBusinessException, AccessDeniedException {
		return ResponseEntity.ok(trainingService.update(dto));
	}

	/**
	 * Delete a training session by its identifier.
	 *
	 * @param id The identifier of the training session to delete.
	 * @return ResponseEntity with an empty body indicating the training session has
	 *         been successfully deleted.
	 * @throws AkdemiaBusinessException If a business exception occurs.
	 * @throws AccessDeniedException    If access is denied.
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) throws AkdemiaBusinessException, AccessDeniedException {
		trainingService.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
