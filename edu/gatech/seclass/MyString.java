package edu.gatech.seclass;
import java.util.Scanner;

public class MyString implements MyStringInterface 
{
	public static void main(String[] args) 
	{
		System.out.println(" ******** INPUT **************");
		Scanner input = new Scanner(System.in);
		
		System.out.println("\nEnter the String : ");
		String str = input.nextLine();
		
		System.out.println("\nEnter the position of the character in the String to be displayed : ");
		int position = input.nextInt();
		
		System.out.println("\nEnter the StartPosition to flip Case in String : ");
		int startPosition = input.nextInt();
		
		System.out.println("\nEnter the EndPosition to flip Case in String : ");
		int endPosition = input.nextInt();
		
		MyString testobj = new MyString();		
		testobj.setString(str);
		
		System.out.println(" ******** OUTPUT **************");
		System.out.printf("\nVowels in the String are            : %s",testobj.getVowels());
		System.out.printf("\nNumber of vowels in the String is   : %d",testobj.numberOfVowels());
		System.out.printf("\nThe Character in the position %d is  : %c",position, testobj.getCharacter(position));
		testobj.flipCaseInSubstring(startPosition,endPosition);
	}
	
	private String str;
	
	public void setString(String str)
	{
		this.str=str;
	}
	
	public String getString()
	{
		return str;
	}
	
	public String getVowels()
	{	
		String vowels = "aeiouAEIOU"; 
		String res=""; 
		for( int i = 0; i < str.length(); i++ ) 
		if( vowels.indexOf( str.charAt( i ) ) != -1 )	
			res=res+str.charAt( i );	    
		return(res);
	}
	
	public int numberOfVowels()
	{
		String vowels = "aeiouAEIOU"; 
		String res=""; 
		for( int i = 0; i < str.length(); i++ ) 
		if( vowels.indexOf( str.charAt( i ) ) != -1 )	
			res=res+str.charAt( i );
	    return(res.length());
	}
	
	public char getCharacter(int position) throws IllegalArgumentException,IllegalIndexException
	{	
		if(position>str.length())	
		{
			System.out.println("!!! Position is greater than length of the String !!!!");
			throw new IllegalIndexException();
		}		
		
		if(position <=0 )	
		{
			System.out.println();
			throw new IllegalArgumentException("\n!!! Position is invalid.Must be greater than 0 !!!!");
		}
		
		return(str.charAt(position-1));
			
	}
	
	public void flipCaseInSubstring(int startPosition, int endPosition) throws IllegalArgumentException,IllegalIndexException
	{
		
		if(endPosition>str.length())
		{
			System.out.println("End Position is greater than length of the string Invalid!!!!");
			throw new IllegalIndexException();
		}
	
		if(startPosition <= 0 || endPosition <= 0 ||startPosition > endPosition)
		{
			System.out.println();		
			throw new IllegalArgumentException("Position is invalid!Must be greater than 0");
		}
		
		String t = "";
        for (int x = startPosition - 1; x < endPosition; x++)
        {  
            char c = str.charAt(x);
            boolean check = Character.isUpperCase(c);
            if (check == true)
                t = t + Character.toLowerCase(c);
            else
                t = t + Character.toUpperCase(c);
        }
        
        System.out.printf ("\nFlip Case In SubString is : %s",t);
	}		
}
