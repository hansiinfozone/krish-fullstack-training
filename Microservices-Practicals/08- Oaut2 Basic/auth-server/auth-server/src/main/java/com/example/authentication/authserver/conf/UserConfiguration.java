package com.example.authentication.authserver.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfiguration extends GlobalAuthenticationConfigurerAdapter{

	PasswordEncoder pe = PasswordEncoderFactories.createDelegatingPasswordEncoder();

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication().withUser(username:"cat").password(pe.encode(charSequence:"catPass")).roles
		("USER","ADMIN","MANAGER").authorities("CAN_READ","CAN_WRITE","CAN_DELETE").and()
		.withUser(username:"suranga").password(pe.encode(charSequence:"catpas")).roles
		("USER","ADMIN","MANAGER").authorities("CAN_READ","CAN_WRITE")
	}
}
