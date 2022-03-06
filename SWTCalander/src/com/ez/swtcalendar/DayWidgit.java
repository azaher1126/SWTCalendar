package com.ez.swtcalendar;

import java.time.LocalDate;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

class DayWidgit extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public DayWidgit(Composite parent, int style, LocalDate date, int numTasks) {
		super(parent, style);

		Label lblDayXx = new Label(this, SWT.NONE);
		lblDayXx.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblDayXx.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BORDER));
		lblDayXx.setFont(SWTResourceManager.getFont("Gilroy ExtraBold", 13, SWT.NORMAL));
		lblDayXx.setBounds(0, 0, 80, 23);
		lblDayXx.setText("" + date.getDayOfMonth());
		
		Label tasks = new Label(this, 0);
		tasks.setFont(SWTResourceManager.getFont("Gilroy Light", 10, SWT.NORMAL));
		tasks.setBounds(0, 27, 80, 23);
		tasks.setText("" + numTasks + " Tasks");
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	
}
