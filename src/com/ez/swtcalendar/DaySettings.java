package com.ez.swtcalendar;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.wb.swt.SWTResourceManager;

class DaySettings {
	private Color background;
	private Color taskTextColor;
	private Color headerBackground;
	private Color headerTextColor;
	private Font headerFont;
	private Font tasksFont;
	
	DaySettings() {
		this.background = SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND);
		this.taskTextColor = SWTResourceManager.getColor(SWT.COLOR_BLACK);
		this.headerBackground = SWTResourceManager.getColor(SWT.COLOR_WIDGET_BORDER);
		this.headerTextColor = SWTResourceManager.getColor(SWT.COLOR_WHITE);
		this.headerFont = SWTResourceManager.getFont("Gilroy ExtraBold", 13, SWT.NORMAL);
		this.tasksFont = SWTResourceManager.getFont("Gilroy Light", 10, SWT.NORMAL);
	}
	
	public Color getBackground() {
		return background;
	}
	public void setBackground(Color background) {
		this.background = background;
	}
	public Color getTaskTextColor() {
		return taskTextColor;
	}
	public void setTaskTextColor(Color taskTextColor) {
		this.taskTextColor = taskTextColor;
	}
	public Color getHeaderBackground() {
		return headerBackground;
	}
	public void setHeaderBackground(Color headerBackground) {
		this.headerBackground = headerBackground;
	}
	public Color getHeaderTextColor() {
		return headerTextColor;
	}
	public void setHeaderTextColor(Color headerTextColor) {
		this.headerTextColor = headerTextColor;
	}
	public Font getHeaderFont() {
		return headerFont;
	}
	public void setHeaderFont(Font headerFont) {
		this.headerFont = headerFont;
	}
	public Font getTasksFont() {
		return tasksFont;
	}
	public void setTasksFont(Font tasksFont) {
		this.tasksFont = tasksFont;
	}
}
