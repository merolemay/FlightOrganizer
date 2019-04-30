package model;

public class Date  {
	private int day,month,year;
	

	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public static int giveMeAnHour() {
		
		return 0;
	}
	public static Date dateTurning() {
		Date n = new Date((int)(Math.random() * 31) + 1,(int)(Math.random() * 12) + 1, 2019);
		return n;	
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (day < 10) {
            sb.append("0");
        }
        sb.append(day);
        sb.append("-");
        if (month < 10) {
            sb.append("0");
        }
        sb.append(month);
        sb.append("-");
        sb.append(year);
        return sb.toString();
    }

	public int compareTo(Date date) {
		int flag=0;
		if(this.month==date.getMonth()) {
			if(this.getDay()==date.getDay())
				flag=0;
		 if(this.getDay()>date.getDay())
			flag=1;
		else
			flag=-1;
		} else if(this.month>date.month)
			flag=1;
		else
			flag=-1;
		return flag;
		}
}
