package com.ez.swtcalendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

class DayView extends Composite {
	private final String[] dayNames = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday", "Saturday"};
	public final int height;
	
	private ArrayList<DaySelectedListener> listeners = new ArrayList<DaySelectedListener>();
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	DayView(Composite parent, int style, YearMonth thisMonth, HashMap<LocalDate,Integer> tasks, Settings settings) {
		super(parent, style);
		setLayout(null);
		int row = 0;
		for (int i = 0;i<7;i++) {
			Label header = new Label(this,SWT.NONE);
			header.setText(dayNames[i]);
			header.setFont(settings.getDayHeaderSettings().getFont());
			header.setForeground(settings.getDayHeaderSettings().getTextColor());
			header.setBackground(settings.getDayHeaderSettings().getBackground());
			header.setAlignment(SWT.CENTER);
			header.setBounds(i*80, 0, 80, 15);
		}
		for (int i = 1; i <= thisMonth.lengthOfMonth();i++) {
			LocalDate day = LocalDate.of(thisMonth.getYear(), thisMonth.getMonthValue(), i);
			DayOfWeek weekDay = day.getDayOfWeek();
			int numTasks = 0;
			if (tasks.get(day) != null) {
				numTasks = tasks.get(day);
			}
			DayWidget dayView = new DayWidget(this,SWT.BORDER,day, numTasks, settings);
			dayView.addMouseListener(new DayClickHandler(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					for (DaySelectedListener listener: listeners) {
						listener.daySelected(day);
					}
				}
				
			}));
			if (weekDay.getValue() == 7) {
				dayView.setBounds(0, row*80+15, 80, 80);
			} else {
				dayView.setBounds((weekDay.getValue())*80, row*80+15, 80, 80);
			}
			if (weekDay.getValue() == 6) {
				if (i < thisMonth.lengthOfMonth()) {
					row++;
				}
			}
		}
		height = (row+1)*80+15;
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	void addListener(DaySelectedListener listener) {
		listeners.add(listener);
	}

}
