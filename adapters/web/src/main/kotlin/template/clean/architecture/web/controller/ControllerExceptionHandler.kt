package template.clean.architecture.web.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.MessageSource
import org.springframework.web.bind.annotation.ControllerAdvice

@ControllerAdvice
class ControllerExceptionHandler(
	val messageSource: MessageSource,
	val objectMapper: ObjectMapper
) {

	// CONTINUAR AQUI

}