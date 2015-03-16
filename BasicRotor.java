
public class BasicRotor extends Rotor{

	//create the BasicRotor constructor and its mapping depending on its type(I,II,III,IV or V)
	

	
	public BasicRotor(String x) {  
		type=x;
		

		if(x=="typeI"){
			mapping[0]=4;           mapping[14]=24;
			mapping[1]=10; 			mapping[15]=7;
			mapping[2]=12; 			mapping[16]=23;
			mapping[3]=5; 			mapping[17]=20;
			mapping[4]=11;			mapping[18]=18;
			mapping[5]=6;			mapping[19]=15;
			mapping[6]=3;			mapping[20]=0;
			mapping[7]=16;			mapping[21]=8;
			mapping[8]=21;			mapping[22]=1;
			mapping[9]=25; 			mapping[23]=17;
			mapping[10]=13;			mapping[24]=2;
			mapping[11]=19;			mapping[25]=9;
			mapping[12]=14;
			mapping[13]=22; 

		}
		if(x=="typeII"){
			mapping[0]=0;           mapping[14]=12;
			mapping[1]=9; 			mapping[15]=2;
			mapping[2]=3; 			mapping[16]=16;
			mapping[3]=10; 			mapping[17]=6;
			mapping[4]=18;			mapping[18]=25;
			mapping[5]=8;			mapping[19]=13;
			mapping[6]=17;			mapping[20]=15;
			mapping[7]=20;			mapping[21]=24;
			mapping[8]=23;			mapping[22]=5;
			mapping[9]=1; 			mapping[23]=21;
			mapping[10]=11;			mapping[24]=14;
			mapping[11]=7;			mapping[25]=4;
			mapping[12]=22;
			mapping[13]=19; 


		}
		if(x=="typeIII"){
			mapping[0]=1;           mapping[14]=24;
			mapping[1]=3; 			mapping[15]=4;
			mapping[2]=5; 			mapping[16]=8;
			mapping[3]=7; 			mapping[17]=22;
			mapping[4]=9;			mapping[18]=6;
			mapping[5]=11;			mapping[19]=0;
			mapping[6]=2;			mapping[20]=10;
			mapping[7]=15;			mapping[21]=12;
			mapping[8]=17;			mapping[22]=20;
			mapping[9]=19; 			mapping[23]=18;
			mapping[10]=23;			mapping[24]=16;
			mapping[11]=21;			mapping[25]=14;
			mapping[12]=25;
			mapping[13]=13; 


		}
		if(x=="typeIV"){
			mapping[0]=4;           mapping[14]=23;
			mapping[1]=18; 			mapping[15]=11;
			mapping[2]=14; 			mapping[16]=13;
			mapping[3]=21; 			mapping[17]=5;
			mapping[4]=15;			mapping[18]=19;
			mapping[5]=25;			mapping[19]=6;
			mapping[6]=9;			mapping[20]=10;
			mapping[7]=0;			mapping[21]=3;
			mapping[8]=24;			mapping[22]=2;
			mapping[9]=16; 			mapping[23]=12;
			mapping[10]=20;			mapping[24]=22;
			mapping[11]=8;			mapping[25]=1;
			mapping[12]=17;
			mapping[13]=7; 


		}
		if(x=="typeV"){
			mapping[0]=21;          mapping[14]=11;
			mapping[1]=25; 			mapping[15]=23;
			mapping[2]=1; 			mapping[16]=0;
			mapping[3]=17; 			mapping[17]=22;
			mapping[4]=6;			mapping[18]=12;
			mapping[5]=8;			mapping[19]=9;
			mapping[6]=19;			mapping[20]=16;
			mapping[7]=24;			mapping[21]=14;
			mapping[8]=20;			mapping[22]=5;
			mapping[9]=15; 			mapping[23]=4;
			mapping[10]=18;			mapping[24]=2;
			mapping[11]=3;			mapping[25]=10;
			mapping[12]=13;
			mapping[13]=7; 


		}
	}

//substitute(int) changes the int using the mapping of the BasicRotor. 
//We have to consider the position of the rotor when making this substitution however. 
//If the rotor is at position 0 then the mapping is used as is. 
//If the rotor is at position x then we have to remove x from the character being mapped before carrying out the mapping and add x back on after the mapping.
	
	int substitute(int b) {
		int c=0;
		if(position==0){
			c= mapping[b];
		}
		else{
			int x=b-position+26;
			c=x%26;
			c=mapping[c]+position;
			c=c%26;
			
//This another method of carring out the substitution.(However, the first one is more elegant) 
		 /* 	if(b-position<0){
				
			}
			if (mapping[26+b-position]+position>26){
					c=mapping[26+b-position]+position-26;
				}
				else{
					c=mapping[26+b-position]+position;
				}
			}

			else {
				if (mapping[b-position]+position>26){
					c=mapping[b-position]+position-26;
				}
				else{
					c=mapping[b-position]+position;
				}
			}*/

		}
		return c;
	}

//substituteBack(int) method uses an inverse mapping to change the integer passed to it. It changes the integer after it goes through the Reflector, on the way back.
	
	
	public int substituteBack (int p){
	
		p=p-position+26;
		p=p % 26;
		
		for(int i=0;i<26;i++){
			if(mapping[i]==p){
				return ((i+position)%26);
			}
		}
		
	return -1;
	}

	void initialise(String c) {
	}

//rotate() increases the position of the Rotor by one. But the Rotors are circular so the position becomes 0 after a complete tour.
	
	public int rotate(){
		this.position++;
		if(this.position==26){
			this.position=0;
		}
		return(this.position);
	}

}
