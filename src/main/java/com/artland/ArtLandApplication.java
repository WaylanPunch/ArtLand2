package com.artland;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author WaylanPunch
 * @email waylanpunch@gmail.com
 * @link https://github.com/WaylanPunch
 * @date 2017-10-31
 */
@MapperScan("com.artland.dao")
@SpringBootApplication
public class ArtLandApplication {
	public static void main(String[] args) {
		SpringApplication.run(ArtLandApplication.class, args);
	}
}
