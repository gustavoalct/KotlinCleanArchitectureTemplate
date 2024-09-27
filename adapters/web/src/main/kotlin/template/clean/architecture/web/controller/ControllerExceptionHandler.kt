package template.clean.architecture.web.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.MessageSource
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import template.clean.architecture.exceptions.DomainExceptions

@ControllerAdvice
class ControllerExceptionHandler(
	val messageSource: MessageSource,
	val objectMapper: ObjectMapper
) {

	@ExceptionHandler
	fun applicationException(exception: DomainExceptions.ApplicationExceptions): ResponseEntity<ApiError> {
		return ResponseEntity(
			ApiError(
				code = exception.status?.value().toString(),
				message = exception.errorMessage
			),
			exception.status ?: HttpStatus.BAD_REQUEST
		)
	}

}


data class ApiError(
	val code: String,
	val message: String? = null
)