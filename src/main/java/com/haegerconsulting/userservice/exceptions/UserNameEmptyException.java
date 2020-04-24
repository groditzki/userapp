package com.haegerconsulting.userservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "The Username must not be empty.")
public class UserNameEmptyException extends RuntimeException {
}
