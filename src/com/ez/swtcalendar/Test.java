package com.ez.swtcalendar;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import java.time.LocalDate;
import java.util.HashMap;


public class Test {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Test window = new Test();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(570, 470);
		shell.setText("SWT Application");
		HashMap<LocalDate,Integer> tasks = new HashMap<>();
		Settings settings = new Settings();
		settings.getDaySettings().setHeaderBackground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		CalendarWidgit calendar = new CalendarWidgit(shell, 0, tasks, settings);
		calendar.setBounds(0, 0, 560, calendar.getHeight());
		
	}
}
