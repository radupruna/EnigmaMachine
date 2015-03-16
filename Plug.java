import java.util.*;
import java.io.*;
public class Plug {

	char firstSocket;
	char secondSocket;
	//create the plug constructor which takes 2 char variables as arguments.
	public Plug(char one, char two){
		firstSocket=one;
		secondSocket=two;
	}

	//create the getEnd1() and getEnd2() methods which return each of the characters from plug.
	public char getEnd1(){
		return firstSocket;
	}

	public char getEnd2(){
		return secondSocket;
	}

	//create the test(char) method which returns the letter from the argument if it's not in a plug and the other end if it is.
	public char test(char letterIn){
		char a;
		if( (Character.getNumericValue(letterIn) )==(Character.getNumericValue (this.getEnd1()) ) ){
			a=this.getEnd2();
		}
		else {
			if(Character.getNumericValue(letterIn)==(Character.getNumericValue (this.getEnd2()) ) ){
				a=this.getEnd1();
			}
			else{
				a=letterIn;
			}
		}
		return (a);
	}

	//clashWith(Plug) method test whether a plug can be connected to the plugboard or whether one of the sockets is already in use. 
	//The method  return true if either end of the Plug is shared with the Plug passed into the method.
	public boolean clashesWith(Plug plugin){
		boolean t=false;
		if(this.test(this.getEnd1())==plugin.getEnd1() 
				|| this.test(this.getEnd1())==plugin.getEnd2() 
				|| this.test(this.getEnd2())==plugin.getEnd1()
				|| this.test(this.getEnd2())==plugin.getEnd2() ){

			t=true;
		}
		return(t);
	}


}

