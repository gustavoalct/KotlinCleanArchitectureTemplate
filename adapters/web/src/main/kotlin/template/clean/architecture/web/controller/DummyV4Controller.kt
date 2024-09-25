package template.clean.architecture.web.controller

import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.Parameters
import io.swagger.v3.oas.annotations.enums.ParameterIn
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import template.clean.architecture.web.utils.toCurrentValue

@RestController
@RequestMapping("/v4/dummy")
@Tag(
	description = "Dummy for template",
	name = "Template"
)
class DummyV4Controller(
//	private val
) {


	@GetMapping
	@Parameters(
		Parameter(name = "value1", required = true, `in` = ParameterIn.HEADER, schema = Schema(type = "String"), example = "value1"),
		Parameter(name = "value2", required = true, `in` = ParameterIn.HEADER, schema = Schema(type = "String"), example = "value2")
	)
	fun getDummy(
		@Parameter(hidden = true) @RequestHeader header: HttpHeaders
	):Any{

		// Formatar dados dos header para um obejto, pode ser usado para trafegar dados de usuario
		val currentValues = header.toCurrentValue()

		return ""
	}



}