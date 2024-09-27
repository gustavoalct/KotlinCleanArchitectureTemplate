package template.clean.architecture.database.config

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaRepositories(
	entityManagerFactoryRef = "TemplateManagerFactory",
	basePackages = ["template.clean.architecture.database"],
	transactionManagerRef = "TemplateManagerFactory"
)
@PropertySource("classpath:database-\${spring.profiles.active}.yml", factory = YamlPro)
class PostgresRepositoryConfig {
}