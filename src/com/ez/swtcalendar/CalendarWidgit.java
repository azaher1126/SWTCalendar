package com.ez.swtcalendar;

import org.eclipse.swt.widgets.Composite;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class CalendarWidgit extends Composite {
	YearMonth thisMonth = YearMonth.now();
	DayView dayView;
	Label lblMonthYyy;
	public int height;
	private final ScrolledComposite comp;
	private HashMap<LocalDate,Integer> tasks;
	
	public LocalDate selectedDay;
	
	private DaySelected listener = new DaySelected() {
		@Override
		public void daySelected(LocalDate day) {
			// TODO Auto-generated method stub
			selectedDay = day;
		}
	};
	
	/**
	 * Create a new CalanderWidgit.
	 * @param parent
	 * @param style
	 * @param tasks gives the number of tasks for each day.
	 */
	public CalendarWidgit(Composite parent, int style, HashMap<LocalDate,Integer> tasks) {
		super(parent, style);
		setLayout(null);
		this.tasks = tasks;
		
		lblMonthYyy = new Label(this, SWT.NONE);
		lblMonthYyy.setFont(SWTResourceManager.getFont("Gilroy ExtraBold", 11, SWT.NORMAL));
		lblMonthYyy.setAlignment(SWT.CENTER);
		lblMonthYyy.setBounds(36, 3, 488, 15);
		lblMonthYyy.setText(thisMonth.getMonth().toString() + " " + thisMonth.getYear());
		
		Button btnBack = new Button(this, SWT.NONE);
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				seek(-1);
			}
		});
		btnBack.setBounds(0, 0, 30, 20);
		btnBack.setText("<");
		
		Button btnForward = new Button(this, SWT.NONE);
		btnForward.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				seek(1);
			}
		});
		btnForward.setBounds(530, 0, 30, 20);
		btnForward.setText(">");
		comp = new ScrolledComposite(this, SWT.V_SCROLL);
		dayView = new DayView(comp,SWT.NONE,thisMonth,tasksForMonth());
		dayView.addListener(listener);
		dayView.setBounds(0, 0, 560, dayView.height);
		comp.setBounds(8, 25, 560, dayView.height);
		comp.setContent(dayView);
		height = dayView.height+25;
	}
	
	public void addListener(DaySelected listener) {
		this.listener = listener;
	}
	
	private void seek(int months) {
		int year = thisMonth.getYear();
		int month = thisMonth.getMonthValue()+months;
		if (month == 0) {
			month=12;
			year--;
		} else if (month == 13) {
			month = 1;
			year++;
		}
		thisMonth = YearMonth.of(year, month);
		setDayView();
		lblMonthYyy.setText(thisMonth.getMonth().toString() + " " + thisMonth.getYear());
		height = dayView.height+25;
	}
	
	private void setDayView() {
		dayView.dispose();
		dayView = new DayView(comp,0,thisMonth,tasksForMonth());
		dayView.addListener(listener);
		dayView.setBounds(0, 0, 560, dayView.height);
		comp.setContent(dayView);
	}
	
	private HashMap<LocalDate,Integer> tasksForMonth() {
		HashMap<LocalDate,Integer> results = new HashMap<LocalDate, Integer>();
		for (Map.Entry<LocalDate,Integer> entry : this.tasks.entrySet()) {
			if (entry.getKey().getMonthValue() == thisMonth.getMonthValue()) {
				results.put(entry.getKey(),entry.getValue());
			}
		}
		return results;
	}
	/**
	 * Update CalandarWidgit with new data.
	 * @param tasks gives the number of tasks for each day.
	 */
	public void updateData(HashMap<LocalDate,Integer> tasks) {
		this.tasks = tasks;
		setDayView();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
