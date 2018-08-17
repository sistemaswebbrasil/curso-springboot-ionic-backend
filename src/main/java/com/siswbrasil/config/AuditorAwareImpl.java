package com.siswbrasil.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

import com.siswbrasil.security.UserSS;
import com.siswbrasil.services.UserService;

public class AuditorAwareImpl implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {

		UserSS user = UserService.authenticated();
		if (user == null) {
			return Optional.of("admin");
		}

		return Optional.of(user.getUsername());
	}
}