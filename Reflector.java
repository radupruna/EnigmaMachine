
public class Reflector extends Rotor {


//create initialise(String) method which creates the Reflector mapping based on its type(i.e. ReflectorI or ReflectorII ).
	
	

	public void initialise(String c) {
		
		if (c=="ReflectorI"){
		
			refMapping[0]=24;           refMapping[14]=12;
			refMapping[1]=17; 			refMapping[15]=8;
			refMapping[2]=20; 			refMapping[16]=4;
			refMapping[3]=7; 			refMapping[17]=1;
			refMapping[4]=16;			refMapping[18]=5;
			refMapping[5]=18;			refMapping[19]=25;
			refMapping[6]=11;			refMapping[20]=2;
			refMapping[7]=3;			refMapping[21]=22;
			refMapping[8]=15;			refMapping[22]=21;
			refMapping[9]=23; 			refMapping[23]=9;
			refMapping[10]=13;			refMapping[24]=0;
			refMapping[11]=6;			refMapping[25]=19;
			refMapping[12]=14;
			refMapping[13]=10; 
		}
		if(c=="ReflectorII"){
			refMapping[0]=5;            refMapping[14]=6;
			refMapping[1]=21; 			refMapping[15]=2;
			refMapping[2]=15; 			refMapping[16]=19;
			refMapping[3]=9; 			refMapping[17]=10;
			refMapping[4]=8;			refMapping[18]=20;
			refMapping[5]=0;			refMapping[19]=16;
			refMapping[6]=14;			refMapping[20]=18;
			refMapping[7]=24;			refMapping[21]=1;
			refMapping[8]=4;			refMapping[22]=13;
			refMapping[9]=3; 			refMapping[23]=12;
			refMapping[10]=17;			refMapping[24]=7;
			refMapping[11]=25;			refMapping[25]=11;
			refMapping[12]=23;
			refMapping[13]=22; 

		}
	}

//substitute(int) method returns the number corresponding to that element of the array.
	int substitute(int b) {

		return (refMapping[b]);
	}


}
