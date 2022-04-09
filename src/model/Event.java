package model;

public class Event{
	
	
	private String realizer;
	private double value;
	private String description;
	
	
	//associations
	private Date dateEvent;
	
	
	
	
	public Event(String realizer, double value, String description, Date dateEvent){
		this.realizer=realizer;
		this.value=value;
		this.description=description;
		this.dateEvent=dateEvent;
	}
	
	
	public String getRealizer(){
		return realizer;
	}
	
	public double getValue(){
		return value;
	}
	
	public String getDescription(){
		return description;
	}
	
	
	public void setRealizer(String r){
		realizer=r;
	}
	
	public void setValue(double v){
		value=v;
	}
	
	public void setDescription(String d){
		description=d;
	}
	
	public void setDateEvent(Date de){
		dateEvent=de;
	}
	
	
	
	
	
	
	
	
	
	
	
}
	