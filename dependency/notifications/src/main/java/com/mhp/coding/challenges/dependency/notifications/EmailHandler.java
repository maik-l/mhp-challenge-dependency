package com.mhp.coding.challenges.dependency.notifications;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mhp.coding.challenges.dependency.inquiry.Inquiry;

@Component
public class EmailHandler {

	private static final Logger LOG = LoggerFactory.getLogger(EmailHandler.class);

	public void sendEmail(final Inquiry inquiry) {
		LOG.info("Sending email for: {}", inquiry);
	}

}
