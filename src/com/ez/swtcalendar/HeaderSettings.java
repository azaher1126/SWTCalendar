package com.ez.swtcalendar;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.wb.swt.SWTResourceManager;

class HeaderSettings {
	private Font font;
	private Color textColor;
	private Color textBackground;
	private Color buttonBackground;
	private Color buttonForeground;
	
	private int buttonStyle;
	
	HeaderSettings() {
		this.font = SWTResourceManager.getFont("Gilroy ExtraBold", 11, SWT.NORMAL);
		this.textColor = SWTResourceManager.getColor(SWT.COLOR_BLACK);
		this.textBackground = SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND);
		this.buttonBackground = SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND);
		this.buttonForeground = SWTResourceManager.getColor(SWT.COLOR_BLACK);
		this.buttonStyle = SWT.NONE;
	}
	
	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public Color getTextColor() {
		return textColor;
	}

	public void setTextColor(Color textColor) {
		this.textColor = textColor;
	}

	public Color getTextBackground() {
		return textBackground;
	}

	public void setTextBackground(Color textBackground) {
		this.textBackground = textBackground;
	}

	public Color getButtonBackground() {
		return buttonBackground;
	}

	public void setButtonBackground(Color buttonBackground) {
		this.buttonBackground = buttonBackground;
	}

	public Color getButtonForeground() {
		return buttonForeground;
	}

	public void setButtonForeground(Color buttonForeground) {
		this.buttonForeground = buttonForeground;
	}

	public int getButtonStyle() {
		return buttonStyle;
	}

	public void setButtonStyle(int buttonStyle) {
		this.buttonStyle = buttonStyle;
	}
}
