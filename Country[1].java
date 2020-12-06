import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;


/**
This class creates the country object. It sets all of the attributes
of the country and provides methods for getting the values of these
attributes.
*
* @author Camille Copeland
* @version 1/31/2020
*/



public class Country {

	private String countryName; 
	private String countryCode; 
	private String capitol;
	private String population;
	private String gdp; 
	private String happy; 
	private long perCap; 
	
	/**
	* This is a constructor. This just initializes the object.
	* 
	*
	* @param The parameters are, in this order, the country: name, code,
	* capitol, population, gdp, and happy rank
	* @return no return
	*/
	public Country(String q, String r, String s, String t, String u, String v) {
		countryName = q; 	population = t; 
		countryCode = r;	gdp = u; 
		capitol = s; 		happy = v; 
	}
	
	public void setCountry(String countryName) {
		this.countryName = countryName; 	
	}
	
	public String getCountry() {
		return countryName; 
	}
	
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode; 	
	}
	
	public String getCountryCode() {
		return countryCode; 
	}
	
	public void setCapitol(String capitol) {
		this.capitol = capitol;
	}
	
	public String getCapitol() {
		return capitol; 
	}
	
	public void setPopulation(String population) {
		this.population = population;	
	}
	
	public long getPopulation() {
		long num1 = Long.parseLong(population);
		return num1;  
	}
	
	public void setGDP(String gdp) {
		this.gdp = gdp; 
	}
	
	public long getGDP(){
		long num = new BigDecimal(gdp).longValue();
		return num;		
	}
	
	public void setHappy(String happy) {
		this.happy = happy;	
	}
	
	public int getHappy() {
		int num2 = (int) Long.parseLong(happy);
		return num2; 
	}
	
	/**
	* This sets the value of gdp per capita using
	* the string parameters equivalent to population
	*
	* @param population and gdp
	* @return description of the return value
	*/
	public void setperCap(String a, String b) {
		long num4 = Long.parseLong(a);
		long num5 = new BigDecimal(b).longValue();
		
		perCap = num5/num4;  
		this.perCap = perCap;
	}
	
	public int getperCap() {
		return (int) perCap;
	}
	
	String format = "%1$-30s %2$-30s %3$-30s %4$-30s %5$-30s %6$-30s\n";
	public void printInfo() {
		System.out.format(format, countryName, countryCode, capitol, population, gdp, happy);
	}
	
	public void printFind() {
		System.out.println("Name: " + countryName + "\n"
				+ "Code: " + countryCode+ "\n"
				+ "Capitol: " + capitol+ "\n"
				+ "Population: "+ population+ "\n"
				+ "GDP:"+ gdp + "\n"
				+ "Happy: " + happy);
	}
	
	

	
}
