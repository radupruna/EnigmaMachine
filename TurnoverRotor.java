
public class TurnoverRotor extends BasicRotor{	
	int turnoverPosition;
	int slot;
	
	TurnoverRotor nextRotor0 ;
	TurnoverRotor nextRotor1 ;
	 
	
	//TurnoverRotor constructor takes the type as a String and the slot as an int.
	public TurnoverRotor(String x, int y) {
		super(x);
		slot=y;
		
		// TODO Auto-generated constructor stub
		if(type=="typeI"){
			turnoverPosition=24;
		}
		if(type=="typeII"){
			turnoverPosition=12;
		}
		if(type=="typeIII"){
			turnoverPosition=3;
		}
		if(type=="typeIV"){
			turnoverPosition=17;
		}
		if(type=="typeV"){
			turnoverPosition=7;
		}
	}
	
	public int getSlot(){
		return slot;
	}
		

	public void setNextRotor0(TurnoverRotor rotor){
	 nextRotor0 = rotor;
	 nextRotor0.setPosition(rotor.position);
	}
	public void setNextRotor1(TurnoverRotor rotor){
		 nextRotor1 = rotor;
		 nextRotor1.setPosition( rotor.position);
		}
//When rotate() is called on our turnoverRotor it will rotate one position in the same way as the BasicRotor. 
//However, if its new position is the same as the turnoverPosition, it will then call rotate() on the Rotor to its right.
	
	public int rotate(){
		this.position++;
		if(this.position>=this.turnoverPosition&&this.slot==0){
			nextRotor0.position++;
		}
		if(nextRotor0.position>=nextRotor0.turnoverPosition&&nextRotor0.slot==1){
			nextRotor1.position++;
		}
		if(nextRotor1.position==26){nextRotor1.position=0;}
		
	return(position);
	}
	
	
}
