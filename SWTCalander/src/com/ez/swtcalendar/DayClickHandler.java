package com.ez.swtcalendar;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;

class DayClickHandler extends MouseAdapter {
	private final Runnable action;
	public static final int LEFT_BUTTON = 1;
	public static boolean armed = false;
	
	DayClickHandler (Runnable action) {
		this.action = action;
	}
	
	@Override
	public void mouseDown(MouseEvent event) {
		if (event.button == LEFT_BUTTON) {
			armed = true;
		}
	}
	
	@Override
	public void mouseUp(MouseEvent event) {
		if (armed && inRange(event)) {
			action.run();
		}
		armed = false;
	}
	
	static boolean inRange(MouseEvent event) {
		Point size = ((Control)event.widget).getSize();
		return event.x >= 0 && event.x <= size.x && event.y >= 0 && event.y <= size.y;
	}
}
