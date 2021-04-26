package hh.swd20.organizer;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfigBox extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http
	      .csrf().disable();
		 //http.authorizeRequests().antMatchers("/", "/h2-console").permitAll();
				// Jotta css toimii, static/styles
				//.and().authorizeRequests().antMatchers("/", "/h2-console/**").permitAll();

	}

}
