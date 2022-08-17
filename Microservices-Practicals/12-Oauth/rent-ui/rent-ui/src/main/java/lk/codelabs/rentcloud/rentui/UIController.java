package lk.codelabs.rentcloud.rentui;

import org.springframework.stereotype.Controller;

@Controller
EnableOAuth2Sso
public class UIController extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/")
                .permitAll()
                .anyRequest()
                .authenticated();



    }

    @RequestMapping(value = "/")
    public String loadUI(){
        return "home";
    }
    @RequestMapping(value = "/secure")
    public String loadSecuredUI(){
        return "secure";
    }
}
	
}
