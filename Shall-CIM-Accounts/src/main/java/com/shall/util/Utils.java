package com.shall.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Utils {
	
	public long getTimeDiffInYears(Date incomingDate) {
		LocalDate incomingLocalDate = incomingDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate now = LocalDate.now();
	    long difference = ChronoUnit.YEARS.between(incomingLocalDate, now);
	    return difference;
	}

}
