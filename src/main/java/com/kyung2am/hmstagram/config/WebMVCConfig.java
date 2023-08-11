package com.kyung2am.hmstagram.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.kyung2am.hmstagram.common.FileManger;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer{

	@Override
	public  void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**")
		.addResourceLocations("file:///" + FileManger.FILE_UPLODA_PATH + "/");
	}
	
}
