package com.ez.swtcalendar;

import java.time.LocalDate;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import org.eclipse.swt.SWT;

class DayWidgit extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public DayWidgit(Composite parent, int style, LocalDate date, int numTasks, Settings settings) {
		super(parent, style);

		this.setBackground(settings.getDaySettings().getBackground());
		
		Label lblDayXx = new Label(this, SWT.NONE);
		lblDayXx.setForeground(settings.getDaySettings().getHeaderTextColor());
		lblDayXx.setBackground(settings.getDaySettings().getHeaderBackground());
		lblDayXx.setFont(settings.getDaySettings().getHeaderFont());
		lblDayXx.setBounds(0, 0, 80, 23);
		lblDayXx.setText("" + date.getDayOfMonth());
		
		Label tasks = new Label(this, 0);
		tasks.setFont(settings.getDaySettings().getTasksFont());
		tasks.setForeground(settings.getDaySettings().getTaskTextColor());
		tasks.setBounds(0, 27, 80, 23);
		tasks.setText("" + numTasks + " Tasks");
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	
}
