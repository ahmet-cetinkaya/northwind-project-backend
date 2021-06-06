package ahmetcetinkaya.northwind.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ahmetcetinkaya.northwind.business.abstracts.UserService;
import ahmetcetinkaya.northwind.core.entities.User;
import ahmetcetinkaya.northwind.core.utilities.results.ErrorDataResult;
import ahmetcetinkaya.northwind.core.utilities.results.Result;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	private UserService userService;

	@Autowired
	public UsersController(final UserService userService) {
		this.userService = userService;
	}

	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody final User user) {
		final Result result = userService.add(user);

		return ResponseEntity.ok(result);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(final MethodArgumentNotValidException exceptions) {
		final Map<String, String> validationErrors = new HashMap<String, String>();
		for (final FieldError fieldError : exceptions.getBindingResult().getFieldErrors())
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());

		return new ErrorDataResult<Object>(validationErrors, "Validation Errors");
	}
}
