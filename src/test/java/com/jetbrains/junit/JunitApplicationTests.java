package com.jetbrains.junit;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Tag("Unit")
class JunitApplicationTests {

	static User user;

	@BeforeAll
	static void setup() {
		user = new User("ray", 20);
	}

	@AfterAll
	static void cleanup(){
		user = null;
	}

	@Test
	@DisplayName("User age is at least 18")
	void userAgeAtLeast18() {
		Assertions.assertThat(user.getAge()).as("User should be at least 18 years old").isGreaterThanOrEqualTo(18);
	}

	@DisplayName("everyone is above age 18")
	@ParameterizedTest
	@ValueSource(ints = {18, 20, 25, 30, 34})
	void allUsersAgeAtLeast18(int age){
		Assertions.assertThat(age).isGreaterThanOrEqualTo(18);
	}

}
