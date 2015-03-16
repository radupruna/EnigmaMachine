
public abstract class Rotor {
	

	protected String type;
	protected int position;
	protected int[] refMapping=new int[26];
	protected int[] mapping=new int[26];  
	protected int[] invMapping=new int[26];
	

	//create the setPosition() and getPosition() methods of the Rotors.
	public void setPosition(int a){
		position=a;
	}
	public int getPosition(){
		return(position);
	}

	//create the abstract methods substitute() and initialize() which are override in other classes
	abstract int substitute(int b); 
	abstract void initialise(String c);
}
