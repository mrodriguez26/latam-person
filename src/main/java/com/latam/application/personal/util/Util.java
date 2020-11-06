package com.latam.application.personal.util;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Util {

	private Util() {
		throw new IllegalStateException("Utility class");
	}

	public static Date strToDate(String sdate) {
		return Date.valueOf(sdate);
	}

	public static Date strToDate(String sdate, String format) {
		java.util.Date date;
		try {
			date = new SimpleDateFormat(format).parse(sdate);
			return new Date(date.getTime());
		} catch (java.text.ParseException e) {
			// nothing
		}
		return null;

	}

	public static int getRandom() {

		Random random = new Random();
		int result = 0;
		int min = 0;
		int max = 4;

		return result = random.nextInt(max - min + 1) + min;
	}

	public static int getAge(String birthday) {
		int age = 0;

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		// Start date
		LocalDate startDate = LocalDate.parse(birthday, formatter);

		age = Period.between(startDate, LocalDate.now()).getYears();

		return age;

	}

	public static int getCurrentDay() {
		int currentDay = LocalDate.now().getDayOfMonth();
		return currentDay;
	}

	public static int getCurrentMonth() {
		int currentMonth = LocalDate.now().getMonth().getValue();
		return currentMonth;
	}

	public static int getCurrentYear() {
		int currentYear = LocalDate.now().getYear();
		return currentYear;
	}

	public static long getDaysToBirthday(String birthday) {
		long days = 0;

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		LocalDate thisYearBirthday = null;
		LocalDate nextYearBirthday = null;

		String strThisYearBirthday = null;
		String strNextBirthday = null;

		String[] dates = birthday.split("-");
		int dayOfBirthday = Integer.parseInt(dates[0]);
		int monthOfBirthday = Integer.parseInt(dates[1]);

		strThisYearBirthday = dates[0] + "-" + dates[1] + "-" + getCurrentYear();
		strNextBirthday = dates[0] + "-" + dates[1] + "-" + (getCurrentYear() + 1);
		thisYearBirthday = LocalDate.parse(strThisYearBirthday, formatter);
		nextYearBirthday = LocalDate.parse(strNextBirthday, formatter);

		if (monthOfBirthday == getCurrentMonth()) {
			if (dayOfBirthday >= getCurrentDay())
				days = daysBetween(LocalDate.now(), thisYearBirthday);
			else
				days = daysBetween(LocalDate.now(), nextYearBirthday);

		} else if (monthOfBirthday < getCurrentMonth()) {
			days = daysBetween(LocalDate.now(), nextYearBirthday);

		} else if (monthOfBirthday > getCurrentMonth()) {
			days = daysBetween(LocalDate.now(), thisYearBirthday);

		}

		return days;
	}

	public static Boolean isBirthday(String birthday) {

		Boolean dateIsBirthday = false;
		String[] dates = birthday.split("-");
		int dayOfBirthday = Integer.parseInt(dates[0]);
		int monthOfBirthday = Integer.parseInt(dates[1]);

		if (monthOfBirthday == getCurrentMonth() && dayOfBirthday == getCurrentDay())
			dateIsBirthday = true;

		return dateIsBirthday;
	}

	public static long daysBetween(LocalDate dateFrom, LocalDate dateTo) {
		long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(dateFrom, dateTo);

		return daysBetween;
	}

}
