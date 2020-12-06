import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

/**
* This class is where the array of Country objects is made.
* A file is taken as an input and each line is read and parsed
* into the data fields that make the Country object. There
* are methods to sort these objects in various manners. This
* class also presents the user with a menu to choose how they
* want to sort the array. 
*
* @author Camille Copeland
* @version 1/31/2020
*/

public class Project1 {

	static Country[] countries;
		
	static Country country;
	
	static String format = "%1$-30s %2$-30s %3$-30s %4$-30s %5$-30s %6$-30s\n";

	/**
	* countries[] array is initialized. 
	* The user input file is taken and scanned. 
	* The countries are assigned to the indices in the array
	* The user is prompted with a menu. Switch case takes 
	* the user input and executes the correlating inst-
	* structions. 
	*
	* @param none
	* @return no return
	*/
	public static void main(String[] args) throws FileNotFoundException {
		
		
		Scanner in = new Scanner(System.in);//scanner to take input
		System.out.println("Please enter file name: ");
		String b = in.nextLine();// user input
		
		countries = new Country[155];// initialize array 
		File file = new File(b);// takes the file 
		Scanner read = new Scanner(file);// allows for the file to be read 
		read.useDelimiter("\n|,");//allows parsing of each line
		read.nextLine();// skips the header
			
		for(int i = 0; i < 155; i++) {// for initializes each individual object in the array and assigns values to its attributes
			String ab = read.next();
			String ac = read.next();
			String ad = read.next();
			String ae = read.next();
			String af = read.next();
			String ag = read.next();
			country = new  Country(ab, ac, ad, ae, af, ag);
			country.setCountry(ab);
			country.setCountryCode(ac);
			country.setCapitol(ad);
			country.setPopulation(ae);
			country.setGDP(af);
			country.setHappy(ag);
			country.setperCap(ae, af);
			read.nextLine();
			
			countries[i] = country;
		}
		int choice;// declares the value that the user will input will be used for case switch
		Scanner input;// declares actual input
		Scanner enter;// for option five so the user can input a country
		String name;//for searching
		int flag1 = 0; // when quit is chosen this signals to exit the loop
		int flag2 = 0;// indicates if the array is sorted by name 
		while(flag1 != -1) { //creates a loop that continually prompts user until they quit
		System.out.println("What would you like to do? Choose one:"
							+ "\n 1.) Print a Countries Report"
							+ "\n 2.) Sort by Name" 
							+ "\n 3.) Sort by Happiness"
							+ "\n 4.) Sort by GDP per capita"
							+ "\n 5.) Find and print a country"
							+ "\n 6.) Quit");
		input = new Scanner(System.in);
		choice = input.nextInt();	
			switch(choice) {// this switch takes the user input and performs the actions designated to each case
				case 1:
					System.out.format(format, "Name", "Code", "Capitol", "Population", "GDP", "Happiness Rank");
					System.out.println("------------------------------------------------------------"
							+ "----------------------------------------------------------------------------------------------------------------------");
					for(int i=0; i <155; i++)
					countries[i].printInfo();
					break;
				case 2:
					System.out.format(format, "Name", "Code", "Capitol", "Population", "GDP", "Happiness Rank");
					System.out.println("------------------------------------------------------------"
							+ "----------------------------------------------------------------------------------------------------------------------");
					bubSort(countries, 155);
					for(int i=0; i <155; i++)
						countries[i].printInfo();
					flag2 = 1;
					break;
				case 3:
					System.out.format(format, "Name", "Code", "Capitol", "Population", "GDP", "Happiness Rank");
					System.out.println("------------------------------------------------------------"
							+ "----------------------------------------------------------------------------------------------------------------------");
					selSort(countries, 155);
					for(int i=0; i <155; i++)
						countries[i].printInfo();
					break;
				case 4:
					System.out.format(format, "Name", "Code", "Capitol", "Population", "GDP", "Happiness Rank");
					System.out.println("------------------------------------------------------------"
							+ "----------------------------------------------------------------------------------------------------------------------");

					inSort(countries, 155);
					for(int i=0; i <155; i++)
						countries[i].printInfo();
					break;
				case 5:
					System.out.println("Enter the country name:");
					enter = new Scanner(System.in);
					name = enter.nextLine();
					if(flag2 == 1) {
						int min = 0;
						int max = 154;
						int mid; 
						while(min < max) {
							mid = (min + max)/2;
							if(name.equals(countries[mid].getCountry())) {
								countries[mid].printFind();
								break;
							}
							else if (name.compareTo(countries[mid].getCountry()) < 0) {
								  max = mid-1;
							}
							else
								min= mid +1; 
						}
					}
					else
					for(int i=0; i < 155; i++) {
						if(name.equals(countries[i].getCountry()))
							countries[i].printFind(); 
					}
					break;
				case 6:
					flag1 = -1;
					break;
				default: 
					System.out.println("Not valid.");	
		}
	}
	}// end main
		
	/**
	* This is the selection sort. Countries are sorted by happiness.
	*
	* @param Country[] takes the array that's already created
	* @param num is just the array size
	* @return none
	*/
	public static void selSort(Country[] country, int num) {
		for(int outer=0; outer<num-1; outer++) {
		int lowest = outer;
		for(int inner=outer+1; inner<num; inner++) {
		if(country[inner].getHappy() < country[lowest].getHappy()) {
		lowest = inner;
		}
		}
		if(lowest != outer) {
		Country temp = country[lowest];
		country[lowest] = country[outer];
		country[outer] = temp;
		}
		}
		}
	/**
	*Insertion sort method sorts the array by gdp per capita
	*
	* @param same as above
	* @return none
	*/
	
	public static void inSort(Country[] a, int num) {
		int in, out, comp;
		
		for(out=1; out < num; out++) {
			Country temp = a[out];
			comp = temp.getperCap();
			in = out;
			while(in>0 && a[in-1].getperCap() >= comp) {
				a[in] = a[in-1];
				--in;
			}
			a[in] = temp;
		}
	}
	
	/**
	* Bubble Sort sorts the array by name. 
	*
	* @param same as above
	* @return none
	*/
	public static void bubSort(Country[] list, int num) {
		int outer=0;
		while (outer<num-1) {
		int inner=num-1;
		while (inner>outer) {
		if (list[inner].getCountry().compareTo(list[inner-1].getCountry()) < 0) {
		Country temp = list[inner];
		list[inner] = list[inner-1];
		list[inner-1] = temp;
		}
		inner--;
		}
		outer++;
		}
		}
	
	public static void binarySearch(String a) {
		int min = 0;
		int max = 154;
		int mid; 
		while(min <= max) {
			mid = (min + max)/2;
			if(countries[mid].getCountry().equals(a)) {
				countries[mid].printFind();
			}
			else if (countries[mid].getCountry().compareTo(a) < 0) {
				  max = mid-1;
			}
			else
				min= mid +1; 
		}
	}
	

}// end class
