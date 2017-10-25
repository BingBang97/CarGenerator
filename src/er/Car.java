package er;

import java.util.*;
import java.io.*;

public class Car {
	static List<Car> cars=new LinkedList<Car>();
	Name cn;
	String name;
	double price;
	int year;
	static Random generator = new Random();
	
	File file=new File("C:/Users/Wojtek/workspace/EasyRider/FILES/cars.txt");
	PrintWriter saveCars=null;
	FileReader readCars=null;
	BufferedReader br=null;
	String line=null;

public Car(String cname, double cprice, int cyear)
{	
	name=cname;
	price=cprice;
	year=cyear;
}

	
	public static double randprice()
	{
		return Math.round(generator.nextDouble()*(35000-500)+500);
	}
	
	public static String randname()
	{
		Name[] names=Name.values();
		Name value=names[(int) (Math.random()*names.length)];

		return value.toString();	
	}
	
	public static int randyear()
	{
	return  generator.nextInt(2001-1960+1)+1960;	
	}
	
public void setname(String cname)
{
		name= cname;
}

public void setprice(double cprice)
{				
		price=cprice;
}

public  void setyear(int cyear)
{		
		year=cyear;
}

public List<Car> getCar()
{
	return cars;
}

public Car()
{

}

public String getName() {return name;}

public int getYear() {return year;}

public double getPrice() {return price;}

public void generate(int x)
{
	for(int i=0;i<x;i++)
	{
	 name=randname();
	 price=randprice();
	 year=randyear();
	
	cars.add(new Car(name,price,year));
	}

}
public void toFile()
{
	try{
		saveCars = new PrintWriter(file);
	}
	catch(FileNotFoundException e){System.out.println("Brak pliku!");}
	
	for(Car car : cars)
	{
		String carToFile=car.getName()+";"+car.getYear()+";"+car.getPrice();
		saveCars.println(carToFile);
		carToFile="";
	}
	saveCars.close();
	saveCars.flush();
}
public void readFile() throws IOException
{
	
	try{readCars=new FileReader(file);
	br = new BufferedReader(readCars);
	while((line=br.readLine()) != null)
	{
		System.out.println(line);
	}
	
	}
	catch(FileNotFoundException e){System.out.println("Brak pliku!");}
	
	
	readCars.close();
	br.close();
}

}
