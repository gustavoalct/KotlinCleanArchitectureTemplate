package template.clean.architecture.usecase

import org.springframework.stereotype.Component
import template.clean.architecture.input.DummyInput

@Component
class DummyUseCase():DummyInput {

	override fun getDummy(): Any {
		TODO("Not yet implemented")
	}

}