package com.example.IOC;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class IocApplication {

	public static void main(String[] args) {
		String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";
		// Encoder encoder = new Encoder();
		// String result = encoder.encode(url);
		// System.out.println(result);

		// UrlEncoder urlEncoder = new UrlEncoder();
		// String result2 = urlEncoder.encode(url);
		// System.out.println("url : " + result2);

		// DI 개념
		// Encoder encoder = new Encoder(new UrlEncoder());
		// Encoder encoder1 = new Encoder(new Base64Encoder());
		// String result = encoder.encode(url);
		// System.out.println(result);

		SpringApplication.run(IocApplication.class, args);

		ApplicationContext context = ApplicationContextProvider.getContext();

		// application이 bean을 관리함. new를 사용하지 않음. (IOC 개념)
		// Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);

		// UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);

		// Encoder encoder = new Encoder(base64Encoder);

		// Encoder encoder = context.getBean(Encoder.class);
		// String result = encoder.encode(url);
		// System.out.println(result);
		// // encoder.setIEncoder(urlEncoder);
		// result = encoder.encode(url);
		// System.out.println(result);

		// Encoder encoder = context.getBean("base64Encoder", Encoder.class);
		Encoder encoder = context.getBean("urlEncode", Encoder.class);
		String result = encoder.encode(url);
		System.out.println(result);

	}

}

@Configuration
class AppConfig {

	// 미리 bean을 등록시킴
	@Bean("base64Encoder")
	public Encoder encoder(Base64Encoder base64Encoder) {
		return new Encoder(base64Encoder);
	}

	@Bean("urlEncode")
	public Encoder encoder(UrlEncoder urlEncoder) {
		return new Encoder(urlEncoder);
	}
}