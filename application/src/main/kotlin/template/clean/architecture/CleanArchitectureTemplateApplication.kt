package template.clean.architecture

import java.util.*
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("template.clean.architecture")
class CleanArchitectureTemplateApplication {
	companion object{

		@JvmStatic
		fun main(args:Array<String>){
			TimeZone.setDefault(TimeZone.getTimeZone("GMT-3"))
			runApplication<CleanArchitectureTemplateApplication>(*args)
		}
	}
}