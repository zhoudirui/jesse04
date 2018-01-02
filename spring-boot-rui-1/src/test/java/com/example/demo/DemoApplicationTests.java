package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


	@Autowired
	private MqService mqService;

	@Test
	public void contextLoads() {
		EmailTest mail = new EmailTest();
		mail.setTo("18355071573@163.com");
		mail.setSubject("异步发送的邮件");
		mail.setContent("嗨 ， 我是消息！");
		this.mqService.sendMessage(mail);

		System.out.println("发送mail 结束");
	}

}
