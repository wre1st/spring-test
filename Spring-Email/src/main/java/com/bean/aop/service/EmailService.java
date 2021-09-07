package com.bean.aop.service;

import com.bean.aop.repository.EmailRepository;

public interface EmailService extends EmailRepository{

	public Integer send();
	public Integer sendEmail();

}