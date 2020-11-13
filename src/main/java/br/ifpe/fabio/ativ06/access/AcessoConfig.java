package br.ifpe.fabio.ativ06.access;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AcessoConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AdmInterceptor())
			.addPathPatterns(new String[]{"/home"});
			//.excludePathPatterns(new String[] {"/", "/login", "/acessoNegado"});
		
	}
}

