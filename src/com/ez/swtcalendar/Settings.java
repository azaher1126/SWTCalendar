package com.ez.swtcalendar;

public class Settings {
	private HeaderSettings headerSettings;
	private DayHeaderSettings dayHeaderSettings;
	private DaySettings daySettings;
	
	public Settings() {
		this.headerSettings = new HeaderSettings();
		this.dayHeaderSettings = new DayHeaderSettings();
		this.daySettings = new DaySettings();
	}
	
	public HeaderSettings getHeaderSettings() {
		return headerSettings;
	}
	public DayHeaderSettings getDayHeaderSettings() {
		return dayHeaderSettings;
	}
	public DaySettings getDaySettings() {
		return daySettings;
	}
}
