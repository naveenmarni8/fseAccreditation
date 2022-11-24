package com.shopping.app.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionData {
	private final String message;
	private final LocalDateTime localDateTime;
	private final Throwable throwable;

}

