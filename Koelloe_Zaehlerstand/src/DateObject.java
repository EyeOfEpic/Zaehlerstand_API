
public class DateObject {
	private String Date;
	private String Wasser;
	private String Strom;
	
	
	
	public DateObject(String date, String wasser, String strom) {
		super();
		Date = date;
		Wasser = wasser;
		Strom = strom;		
	}

	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getWasser() {
		return Wasser;
	}
	public void setWasser(String wasser) {
		Wasser = wasser;
	}
	public String getStrom() {
		return Strom;
	}
	public void setStrom(String strom) {
		Strom = strom;
	}
	public String getData()
	{
		return Strom +"-"+ Wasser;
	}
	
	

}
