package com.example.authentication.authserver.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.nimbusds.oauth2.sdk.as.ReadOnlyAuthorizationServerMetadata;

@Configuration
public class AuthServerConfiguration extends WebSecurityConfigurerAdapter implements 
AuthorizationServerConfigurer{
	
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}
	
	@Autowired
	AuthenticationManager authenticationManager;
	PasswordEncoder pe = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	
	@Override
	public void configure(AuthorizationServerConfigurer security) throws Exception{
		security.checkTokenAccess("permitAll()");
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer security) throws Exception{
		client.inMemory.withClient(clientId: "web").secret(pe.encode(charSequence:"webpass")).scopes("READ","WRITE").
		autorizationGrantTypes("password","authorization_code");
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoint) throws Exception{
		endpoint.authenticationManager(authenticationManager);
	}

}
