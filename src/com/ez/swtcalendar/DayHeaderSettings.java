package com.ez.swtcalendar;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.wb.swt.SWTResourceManager;

class DayHeaderSettings {
	private Color textColor;
	private Color background;
	private Font font;
	
	DayHeaderSettings() {
		this.textColor = SWTResourceManager.getColor(SWT.COLOR_BLACK);
		this.background = SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND);
		this.font = SWTResourceManager.getFont("Gilroy Light", 10, SWT.NORMAL);
	}
	
	public Color getTextColor() {
		return textColor;
	}
	public void setTextColor(Color textColor) {
		this.textColor = textColor;
	}
	public Color getBackground() {
		return background;
	}
	public void setBackground(Color background) {
		this.background = background;
	}
	public Font getFont() {
		return font;
	}
	public void setFont(Font font) {
		this.font = font;
	}
}
