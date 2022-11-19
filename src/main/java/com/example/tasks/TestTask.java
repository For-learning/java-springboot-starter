package com.example.tasks;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestTask {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 3000)
//	@Scheduled(cron = "4-40 * * * * ?")
	public void reportCurrentTime() {
		System.out.println(dateFormat.format(new Date()));
	}

}
