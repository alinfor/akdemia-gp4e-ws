package af.cmr.indyli.akdemia.ws.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import af.cmr.indyli.akdemia.business.dto.full.EmployeeSubscriptionFullDTO;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.service.impl.EmployeeSubscriptionServiceImpl;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import jakarta.annotation.Resource;

@RestController
@RequestMapping("/employer-subscription")
@CrossOrigin("*")
public class EmployeSubscriptionController {
	@Resource(name = ConstsValues.ServiceKeys.EMPLOYEE_SUBSCRIPTION_SERVICE_KEY)
	private EmployeeSubscriptionServiceImpl employeeSubscriptionService;

	@GetMapping
	public ResponseEntity<List<EmployeeSubscriptionFullDTO>> getAll() {
		return ResponseEntity.ok(ResponseEntity.ok(employeeSubscriptionService.fullAllList()).getBody());
	}
		
	@PostMapping
	public ResponseEntity<EmployeeSubscriptionFullDTO> create(@RequestBody EmployeeSubscriptionFullDTO dto) throws AkdemiaBusinessException {
		return ResponseEntity.ok(employeeSubscriptionService.create(dto));
	}
}
