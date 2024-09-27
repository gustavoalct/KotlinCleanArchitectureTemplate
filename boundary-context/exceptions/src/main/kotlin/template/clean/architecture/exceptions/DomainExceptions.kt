package template.clean.architecture.exceptions

import org.springframework.http.HttpStatus

object DomainExceptions {

	data class HeadersApplicationsExceptions(val property: String, val msg: String) : RuntimeException(msg)
	data class ApplicationExceptions(val property: String, val errorMessage: String, val status: HttpStatus? = null) :
		RuntimeException(errorMessage)


}
