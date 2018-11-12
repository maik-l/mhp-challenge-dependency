package com.mhp.coding.challenges.dependency;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.mhp.coding.challenges.dependency.inquiry.Inquiry;
import com.mhp.coding.challenges.dependency.inquiry.InquiryService;
import com.mhp.coding.challenges.dependency.notifications.EmailHandler;
import com.mhp.coding.challenges.dependency.notifications.PushNotificationHandler;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
public class InquiryTest {

	@SpyBean
	private EmailHandler emailHandler;

	@SpyBean
	private PushNotificationHandler pushNotificationHandler;

	@Autowired
	private InquiryService inquiryService;

	@Test
	public void testInquiryHandlers() {
		final Inquiry inquiry = new Inquiry();
		inquiry.setUsername("TestUser");
		inquiry.setRecipient("service@example.com");
		inquiry.setText("Can I haz cheezburger?");

		this.inquiryService.create(inquiry);

		this.emailHandler.sendEmail(inquiry);
		verify(this.emailHandler).sendEmail(eq(inquiry));
		this.pushNotificationHandler.sendNotification(inquiry);
		verify(this.pushNotificationHandler).sendNotification(eq(inquiry));
	}
}
