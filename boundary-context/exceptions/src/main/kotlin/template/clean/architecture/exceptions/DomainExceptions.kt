package template.clean.architecture.exceptions

object DomainExceptions {

	data class HeadersApplicationsExceptions(val property: String, val msg: String) : RuntimeException(msg)


}
