package org.board.cop.boardcopendium01.config;

import org.board.cop.boardcopendium01.domain.user.UrlRoleMapping;
import org.board.cop.boardcopendium01.interceptor.AccessPermitInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private UrlRoleMapping urlRoleMapping;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new AccessPermitInterceptor(urlRoleMapping.getUrlRoleMap()))
                .addPathPatterns("/**");
    }
}
