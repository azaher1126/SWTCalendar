package com.ez.swtcalendar;

public class Settings {
	private HeaderSettings headerSettings;
	private DayHeaderSettings dayHeaderSettings;
	private DaySettings daySettings;
	/**
	 * Create a new settings object
	 */
	public Settings() {
		this.headerSettings = new HeaderSettings();
		this.dayHeaderSettings = new DayHeaderSettings();
		this.daySettings = new DaySettings();
	}
	/**
	 * Get header settings
	 * @return header settings
	 */
	public HeaderSettings getHeaderSettings() {
		return headerSettings;
	}
	/**
	 * Get settings for day headers
	 * @return day header settings
	 */
	public DayHeaderSettings getDayHeaderSettings() {
		return dayHeaderSettings;
	}
	/**
	 * Get settings for day views
	 * @return day settings
	 */
	public DaySettings getDaySettings() {
		return daySettings;
	}
}
