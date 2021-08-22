package io.getarrays.userservice;

import io.getarrays.userservice.domain.Role;
import io.getarrays.userservice.domain.User;
import io.getarrays.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "jon", "jon", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "neeraj", "neeraj", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "sai", "sai", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "viswa", "viswa", "1234", new ArrayList<>()));

			userService.addRoleToUser("jon","ROLE_USER");
			userService.addRoleToUser("jon","ROLE_MANAGER");
			userService.addRoleToUser("neeraj","ROLE_MANAGER");
			userService.addRoleToUser("sai","ROLE_ADMIN");
			userService.addRoleToUser("viswa","ROLE_SUPER_ADMIN");
			userService.addRoleToUser("viswa","ROLE_ADMIN");
			userService.addRoleToUser("viswa","ROLE_USER");
		};
	}

}
