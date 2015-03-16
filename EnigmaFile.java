import java.util.*;
import java.io.*;

public class EnigmaFile {
	ArrayList<Character> decoded=new ArrayList<Character>(); //create an array of chars which saves all the characters after decoding process.
	BufferedReader reader;
	EnigmaMachine machine;
	Scanner in=new Scanner(System.in);
	char current;
	FileInputStream fis;
	public EnigmaFile(){
		machine=new EnigmaMachine(); //create a new EnigmaMachine;
		FileReader file=null;

		//read the file and check if it exists.

		try{
			file=new FileReader("Input.txt");
		}catch(FileNotFoundException e) {
			System.err.println("File not found!!!");
		}

		//read from file char by char and throw Exception if there are other characters in file than letters.
		try {
			FileInputStream fis = new FileInputStream("Input.txt");
			char current;
			machine.start();
			try{
				while (fis.available() > 0) {

					current = (char) fis.read();				
					current=Character.toUpperCase(current);
					//choose only characters A-Z	
					if(Character.getNumericValue(current)<10 || Character.getNumericValue(current)>35)  	throw new NotCharacterException();		
					decoded.add(machine.encodeLetter(current));

				}	}catch(NotCharacterException e){
					e.printStackTrace();
				}

		} catch (IOException e) {
			e.printStackTrace();
		}

		FileOutputStream out;
		PrintStream ps;

	
			try {
				// Create a new file output stream
				out = new FileOutputStream("Dec.txt");

				// Connect print stream to the output stream
				ps = new PrintStream(out);

				for(int i=0;i<decoded.size();i++){
					ps.print(decoded.get(i)); //save the decoded message into the Decoded.txt file.
				}
				
				ps.close();
			}
			catch (Exception e){
				System.err.println ("Error in writing to file");
			}

		}	
	
	
}
