package ru.borovikov.topjavagraduation;

import org.springframework.boot.SpringApplication;

public class TestTopJavaGraduationApplication {

	public static void main(String[] args) {
		SpringApplication.from(TopJavaGraduationApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
