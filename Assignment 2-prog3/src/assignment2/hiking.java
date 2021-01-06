package assignment2;

public class hiking extends outdoorSp{
	String sportname="Hiking";
	String gears="Water Bottles, Backpack, Rain wear, Survival kit";
	double caloriesBurn=300.0;
	String location="Mountains";

	
	public String getLoc() {
		return location;
	}
	public String getSportname() {
		return sportname;
	}
	public String getGears() {
		return gears;
	}
	public double getCalB(){
		return caloriesBurn;
	}
	public void experience() {
		super.experience();
		System.out.println("Seeing nature's beauty and wildlifes\n");
	}
	
	public String toString() {
		return part+"\nSport : "+sportname+"\nLocation : "+location+" \nGears :"+gears+" \nCalories burn estimation : "+caloriesBurn+" per km";
	}
	
	
}
