package com.ms.email.controllers;

import com.ms.email.dtos.EmailDto;
import com.ms.email.models.EmailModel;
import com.ms.email.services.EmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("email")
public class EmailController {

	@Autowired
	private EmailService service;

	@PostMapping("/send")
	public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailDto email) {
		EmailModel emailModel = new EmailModel();
		BeanUtils.copyProperties(email, emailModel);
		service.sendEmail(emailModel);

		return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
	}

}