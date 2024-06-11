package com.Projekt.StronaStazowa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

import static com.Projekt.StronaStazowa.Hashing.Hashing.doHashing;

@SpringBootApplication
public class StronaStazowaApplication {
	public static void main(String[] args) {
		SpringApplication.run(StronaStazowaApplication.class, args);
	}

}
