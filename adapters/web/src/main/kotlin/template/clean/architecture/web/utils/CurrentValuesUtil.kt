package template.clean.architecture.web.utils

import template.clean.architecture.commons.dto.CurrentValues
import template.clean.architecture.exceptions.DomainExceptions

fun Map<String, List<String>>.toCurrentValue() = CurrentValues(
	value1 = getHeader(VALUE_1, true),
	value2 = getHeader(VALUE_2, false),
	value3 = getHeader(VALUE_3, false),
)


fun Map<String, List<String>>.getHeader(header: String, isMandatory: Boolean): String {

	val first = if (this.containsKey(header)) {
		this.getValue(header)[0]
	} else ""

	return when(isMandatory){
		true -> if(first.isNullOrEmpty())
			throw DomainExceptions.HeadersApplicationsExceptions(
				property = header,
				msg = "header $header is mandatory"
			)
		else
			first
		else -> first

	}

}