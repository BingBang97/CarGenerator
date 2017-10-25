package er;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException  {
		int car_number;
		Scanner get=new Scanner(System.in);
		Car x=new Car();
		Car temp;
		
		System.out.println("Program generujacy auta!");
		System.out.print("Podaj ile aut chcesz wygenerowac: ");
		car_number=get.nextInt();
		
		x.generate(car_number);
		
		for(int i=0;i<x.getCar().size();i++)
		{
			 temp=x.getCar().get(i);
			System.out.println("Marka: "+temp.getName()+" | Rok produkcji: "+temp.getYear()+" | Cena: "+temp.getPrice());
		}
		x.toFile();
		System.out.println("Auta zostaly wygenerowane!");
		System.out.println("Auta z pliku:");
		x.readFile();
	}

}
