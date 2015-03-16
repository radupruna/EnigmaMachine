import java.util.*;
import java.io.*;
public class EnigmaMachine {


	 BasicRotor myBasicRotor0;
	 BasicRotor myBasicRotor1;
	 BasicRotor myBasicRotor2;
	Plugboard myPlugboard=new Plugboard();
	Reflector myReflector;
//	TurnoverRotor TurnoverRotor0;
//	TurnoverRotor TurnoverRotor1;
//	TurnoverRotor TurnoverRotor2;


	public EnigmaMachine(){

	}
	//method addPlug(char,char) adds a new plug to the Plugboard

	public void addPlug(char x,char y){
		myPlugboard.addPlug(x,y);
	}

	public void clearPlugboard(){
		myPlugboard.clear();
	}

	//getPlug(char) returns the letter connected to the plug(if there is one)

	public char getPlug(char a){
		return myPlugboard.get(a);
	}

	//addRotor(BasicRotor, int) adds a new BasicRotor in the specified slot.

	public void addRotor(BasicRotor x,int slot){
		switch(slot){
		case 0: 
			myBasicRotor0=x;
			break;
		case 1:
			myBasicRotor1=x;
			break;
		case 2:
			myBasicRotor2=x;
			break;
		default: 
			System.out.println("slots from 0 to 2");
			break;
		}

	}

	//getRotor(int) returns the Rotor from the specified slot.

	public Rotor getRotor(int slot){
		BasicRotor a=new BasicRotor(" ");
		switch(slot){
		case 0:
			a=myBasicRotor0;
			break;
		case 1:
			a=myBasicRotor1;
			break;
		case 2:
			a=myBasicRotor2;
			break;
		default: 
			System.out.println("slots from 0 to 2");
			break;
		}
		return (a);
	}

	//addReflector(Reclector) adds a new Reflector to the Enigma Machine.

	public void addReflector(Reflector a){
		myReflector=a;
	}

	public Reflector getReflector(){
		return(myReflector);
	}

	//setPosition(int,int) sets the initial position for Rotor in the specified slot.

	public void setPosition(int slot, int position){
		switch(slot){
		case 0:
			myBasicRotor0.setPosition(position);
			break;
		case 1:
			myBasicRotor1.setPosition(position);
			break;
		case 2:
			myBasicRotor2.setPosition(position);
			break;
		}
	}

	//encodeLetter(char) encodes the specified char going through the EnigmaMachine.

	public char encodeLetter(char x){

		char y= myPlugboard.get(x);
		int p=Character.getNumericValue(y)-10;  //transform char to int for rotors and reflector.
		int p1=myBasicRotor0.substitute(p);
		int p2=myBasicRotor1.substitute(p1);
		int p3=myBasicRotor2.substitute(p2);
		int p4=myReflector.substitute(p3);
		int p5=myBasicRotor2.substituteBack(p4);
		int p6=myBasicRotor1.substituteBack(p5);
		int p7=myBasicRotor0.substituteBack(p6);
		char t=(char) (p7+65);		 //transform int to char for plugboard	
		myBasicRotor0.rotate();
		char n=(myPlugboard.get(t));	
		return n;


		//	Uncomment this part in order to verify the TurnoverRotors.
		/*		  char y= myPlugboard.get(x);
		int p=Character.getNumericValue(y)-10;  //transform char to int for rotors and reflector.
		int p1=TurnoverRotor0.substitute(p);
		int p2=TurnoverRotor1.substitute(p1);
		int p3=TurnoverRotor2.substitute(p2);
		int p4=myReflector.substitute(p3);
		int p5=TurnoverRotor2.substituteBack(p4);
		int p6=TurnoverRotor1.substituteBack(p5);
		int p7=TurnoverRotor0.substituteBack(p6);
		char t=(char) (p7+65);		 //transform int to char for plugboard
		TurnoverRotor0.setNextRotor0(TurnoverRotor1);
		TurnoverRotor1.setNextRotor1(TurnoverRotor2);
		TurnoverRotor0.rotate();
		char n=(myPlugboard.get(t));	
		return n;
		 */		 
	}

	//method start() sets all the initial data for the EnigmaMachine 

	public void start(){
		myBasicRotor0=new BasicRotor("typeIV");
		myBasicRotor1=new BasicRotor("typeIII");
		myBasicRotor2=new BasicRotor("typeII");
		myReflector=new Reflector();
		myReflector.initialise("ReflectorI");

		myBasicRotor0.setPosition(8);
		myBasicRotor1.setPosition(4);
		myBasicRotor2.setPosition(21);
		
		
		

		//Ask the user the number of plugs in the EnigmaMachine and specify every plug.
		Scanner in=new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("How many Plugs do you want?");
		int p=in.nextInt(); //keep the number of plugs

		for(int i=0;i<p;i++){
			char w='.';
			char t='.';
			System.out.println("Type the(uppercase) letter in the first socket of the plug number "+(i+1));

			String u="";
			try {
				u = br.readLine();
			} catch (IOException e) {

				e.printStackTrace();
			}
			t=u.charAt(0); //transform the user input for the first socket into char


			System.out.println("Type the(uppercase) letter in the second socket of the plug number "+(i+1));

			String m="";
			try {
				m = br.readLine();
			} catch (IOException e) {

				e.printStackTrace();
			}
			w=m.charAt(0); //transform the user input for the second socket into char


			this.addPlug(t,w);
		}

		try{
			//Ask the user to introduce the types and the initial positions of the three rotors.		
			System.out.println("Select the types of the rotors.");
			System.out.println("Remember that the Rotors must have different types");
			System.out.println();
			System.out.println("Please select the type of the first rotor.");
			System.out.println();
			System.out.println("For typeI press 1. For typeII press 2. For typeIII press 3. For type IV press 4. For typeV press 5");
			int a=in.nextInt();
			switch(a){
			case 1: 
				myBasicRotor0 =new BasicRotor("typeI");
				break;

			case 2:
				myBasicRotor0 =new BasicRotor("typeII");
				break;

			case 3:
				myBasicRotor0 =new BasicRotor("typeIII");
				break;

			case 4:
				myBasicRotor0 =new BasicRotor("typeIV");
				break;

			case 5:
				myBasicRotor0 =new BasicRotor("typeV");
				break;

			default:
				System.out.println("I said 1,2,3,4 or 5");
				break;
			}

			System.out.println();
			System.out.println("Please insert the position of the first Rotor");
			int x=in.nextInt();
			myBasicRotor0.setPosition(x);

			System.out.println();
			System.out.println("Please select the type of the second rotor.");
			System.out.println();
			System.out.println("For typeI press 1. For typeII press 2. For typeIII press 3. For type IV press 4. For typeV press 5");
			int b=in.nextInt();
			switch(b){
			case 1: 
				myBasicRotor1 =new BasicRotor("typeI");
				break;

			case 2:
				myBasicRotor1 =new BasicRotor("typeII");
				break;

			case 3:
				myBasicRotor1 =new BasicRotor("typeIII");
				break;

			case 4:
				myBasicRotor1 =new BasicRotor("typeIV");
				break;

			case 5:
				myBasicRotor1 =new BasicRotor("typeV");
				break;

			default:
				System.out.println("I said 1,2,3,4 or 5");
				break;
			}

			System.out.println();
			System.out.println("Please insert the position of the second Rotor");
			int y=in.nextInt();
			myBasicRotor1.setPosition(y);

			System.out.println();
			System.out.println("Please select the type of the third rotor.");
			System.out.println();
			System.out.println("For typeI press 1. For typeII press 2. For typeIII press 3. For type IV press 4. For typeV press 5");
			int c=in.nextInt();
			switch(c){
			case 1: 
				myBasicRotor2 =new BasicRotor("typeI");
				break;

			case 2:
				myBasicRotor2 =new BasicRotor("typeII");
				break;

			case 3:
				myBasicRotor2 =new BasicRotor("typeIII");
				break;

			case 4:
				myBasicRotor2 =new BasicRotor("typeIV");
				break;

			case 5:
				myBasicRotor2 =new BasicRotor("typeV");
				break;

			default:
				System.out.println("I said 1,2,3,4 or 5");
				break;
			}

			if(myBasicRotor0.type==myBasicRotor1.type || myBasicRotor0.type==myBasicRotor2.type || myBasicRotor1.type==myBasicRotor2.type) throw new SameTypeOfRotorException();

			System.out.println();
			System.out.println("Please insert the position of the third Rotor");
			int z=in.nextInt();		
			myBasicRotor2.setPosition(z);

			//Ask the user to introduce the type of the reflector.
			myReflector=new Reflector();
			System.out.println();
			System.out.println("Please initialise the Reflector.");
			System.out.println();
			System.out.println("For ReflectorI press 1. For ReflectorII press 2");
			int d=in.nextInt();
			switch(d){
			case 1:
				myReflector.initialise("ReflectorI");
				break;
			case 2:
				myReflector.initialise("ReflectorII");
				break;
			default:
				System.out.println("I said 1 or 2");
				break;
			}




		}catch(SameTypeOfRotorException e){
			e.printStackTrace();
		}


		//Uncomment the following part if you want to verify the TurnoverRotors.

		/*	
		 * 			this.addPlug('Q','F');
		TurnoverRotor0 =new TurnoverRotor("typeI",0);
		TurnoverRotor1 =new TurnoverRotor("typeII",1);
		TurnoverRotor2 =new TurnoverRotor("typeIII",2);
		myReflector=new Reflector();
		myReflector.initialise("ReflectorI");
		TurnoverRotor0.setPosition(23);
		TurnoverRotor1.setPosition(11);
		TurnoverRotor2.setPosition(7);
		 */		 
	}

	public static void main(String[] args) throws NotCharacterException{
		EnigmaMachine enigmaMachine=new EnigmaMachine();
		System.out.println("Do you want to write the text you want to encript or read it from the txt file?");
		System.out.println("Press 1 for writing and 2 for reading from a file.");
		Scanner in=new Scanner(System.in);
		int h=in.nextInt();
		BufferedReader bra = new BufferedReader(new InputStreamReader(System.in));
		if(h==1){
			System.out.println("Enter your encripted text in A-Z uppercase characters only and without spaces");
			String text=null;
			try {
				text=bra.readLine();
			} catch (IOException e) {

				e.printStackTrace();
			}
			text.trim();  //eliminate the spaces.

			char[] stringArray; //declare the char array
			stringArray=text.toCharArray(); //convert string into array using toCharArray() method of string class
			enigmaMachine.start();
			for(int index=0;index<stringArray.length;index++){
				if(Character.getNumericValue(stringArray[index])<10 || Character.getNumericValue(stringArray[index])>35)  	throw new NotCharacterException();
				char t=enigmaMachine.encodeLetter(stringArray[index]);
				System.out.print(t);
			}


		}

		else{
			EnigmaFile e=new EnigmaFile();
			System.out.println("Thank you. Now you can check Decoded.txt for the decoded message");
		}

 

	}

}
