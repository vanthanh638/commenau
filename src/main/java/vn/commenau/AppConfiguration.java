package vn.commenau;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class AppConfiguration {

//	@Bean
//	public MultipartResolver multipartResolver() {
//		CommonsMultipartResolver resover = new CommonsMultipartResolver();
////		resover.setMaxUploadSize(1000000);
//		return resover;
//	}
}
