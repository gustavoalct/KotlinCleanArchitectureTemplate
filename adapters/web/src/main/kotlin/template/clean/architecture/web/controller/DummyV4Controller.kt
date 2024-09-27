package template.clean.architecture.web.controller

import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.Parameters
import io.swagger.v3.oas.annotations.enums.ParameterIn
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.tags.Tag
import org.slf4j.LoggerFactory
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import template.clean.architecture.input.DummyInput
import template.clean.architecture.web.utils.toCurrentValue

@RestController
@RequestMapping("/v4/dummy")
@Tag(
	description = "Dummy for template",
	name = "Template"
)
class DummyV4Controller(
	private val dummyInput: DummyInput
) {

	private val logger = LoggerFactory.getLogger(javaClass)

	@GetMapping
	@Parameters(
		Parameter(name = "value1", required = true, `in` = ParameterIn.HEADER, schema = Schema(type = "String"), example = "value1"),
		Parameter(name = "value2", required = true, `in` = ParameterIn.HEADER, schema = Schema(type = "String"), example = "value2")
	)
	fun getDummy(
		@Parameter(hidden = true) @RequestHeader header: HttpHeaders
	):Any{

		val currentValues = header.toCurrentValue()

		logger.info("[v4-dummy] -> headers -> $header")

		return ResponseEntity.ok(
			dummyInput.getDummy()
		)
	}

}