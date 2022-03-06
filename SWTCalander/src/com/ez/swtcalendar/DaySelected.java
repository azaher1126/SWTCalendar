package com.ez.swtcalendar;

import java.time.LocalDate;

interface DaySelectedListener {
	void daySelected(LocalDate day);
}

/**
 * Listens for a change in the selected date.
 * @author Ayman Zaher
 * 
 */
public class DaySelected implements DaySelectedListener {
	
	@Override
	public void daySelected(LocalDate day) {
		
	}

}

