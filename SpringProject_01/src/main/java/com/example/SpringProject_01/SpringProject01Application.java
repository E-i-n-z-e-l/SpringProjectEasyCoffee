package com.example.SpringProject_01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

/**
 * Аннотация @ConfigurationPropertiesScan в Java Spring используется для автоматического сканирования классов,
 * которые помечены аннотацией @ConfigurationProperties, и их регистрации в контексте Spring.
 * <p>
 * Это упрощает работу с конфигурационными свойствами, позволяя Spring автоматически настраивать и связывать
 * значения из конфигурационных файлов с объектами Java.
 *
 * Аннотация @ConfigurationPropertiesScan указывает Spring, где искать классы, помеченные @ConfigurationProperties,
 * и автоматически зарегистрировать их как бины в контексте приложения. Это упрощает настройку и конфигурацию
 * приложения, особенно если у вас много таких классов.
 */
@SpringBootApplication
@ConfigurationPropertiesScan
public class SpringProject01Application {
	public static void main(String[] args) {
		SpringApplication.run(SpringProject01Application.class, args);
	}

	/**
	 * В контексте Spring Framework, бин — это объект, который управляется контейнером Spring.
	 * <p>
	 * Аннотация @Bean позволяет явно указать, что метод должен создавать и возвращать бин, который Spring
	 * должен управлять.
	 * <p>
	 * Когда вы аннотируете метод в классе, помеченном как @Configuration (или в классе, который уже является
	 * компонентом Spring), с помощью @Bean, вы указываете Spring, что этот метод создает и возвращает бин.
	 * Этот бин будет управляться Spring контейнером.
	 *
	 * Метод, помеченный @Bean, может содержать любую логику для создания и настройки объекта. Вы можете использовать
	 * зависимости, переданные методу, или другие компоненты Spring для настройки возвращаемого бина.
	 * @return
	 */
	@Bean
	@ConfigurationProperties(prefix = "droid")
	Droid createDroid() {
		return new Droid();
	}

}
