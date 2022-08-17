package com.example.configconsumer.configconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.configconsumer.configconsumer.model.MemberProfileConfiguration;

@RestController
// to fetch to ui  @Controller is use.
//@Controller
public class ProfileController {

	@Autowired
	MemberProfileConfiguration memberProfileConfiguration;
	
	@RequestMapping(value="/profile")
	public MemberProfileConfiguration getConfig() {
		return memberProfileConfiguration;
	}
}
