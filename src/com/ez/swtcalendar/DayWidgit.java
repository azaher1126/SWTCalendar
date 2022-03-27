package com.ez.swtcalendar;

import java.time.LocalDate;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Region;

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
		lblDayXx.setBounds(0, 0, 23, 23);
		lblDayXx.setText("" + date.getDayOfMonth());
		lblDayXx.setRegion(createRoundedRectangle(0,0,23,23,8));
		lblDayXx.setAlignment(SWT.CENTER);
		
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
	
	
	public static Region createRoundedRectangle(int x, int y, int W, int H, int r) {
	    Region region = new Region();
	    int d = (2 * r); // diameter

	    region.add(circle(r, (x + r), (y + r)));
	    region.add(circle(r, (x + W - r), (y + r)));
	    region.add(circle(r, (x + W - r), (y + H - r)));
	    region.add(circle(r, (x + r), (y + H - r)));

	    region.add((x + r), y, (W - d), H);
	    region.add(x, (y + r), W, (H - d));

	    return region;
	}
	
	static int[] circle(int r, int offsetX, int offsetY) {
		int[] polygon = new int[8 * r + 4];
		//x^2 + y^2 = r^2
		for (int i = 0; i < 2 * r + 1; i++) {
			int x = i - r;
			int y = (int)Math.sqrt(r*r - x*x);
			polygon[2*i] = offsetX + x;
			polygon[2*i+1] = offsetY + y;
			polygon[8*r - 2*i - 2] = offsetX + x;
			polygon[8*r - 2*i - 1] = offsetY - y;
		}
		return polygon;
	}
	
	
}
