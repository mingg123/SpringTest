package com.example.IOC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		Encoder encoder = new Encoder(new UrlEncoder());
		Encoder encoder1 = new Encoder(new Base64Encoder());
		String result = encoder.encode(url);
		System.out.println(result);

		SpringApplication.run(IocApplication.class, args);
	}

}
