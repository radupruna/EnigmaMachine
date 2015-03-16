import java.util.*;
public class Plugboard {



	//the board Arraylist is actually the plugboard itself. It has the plugs from plugdoard as elements.
	ArrayList<Plug> board=new ArrayList<Plug>();


	//addPlug method verifies if the characters from plug are already used. 
	//It returns true if the plug doesn't exist and create it in plugboard.
	//It returns false if one of the characters is used in a previous plug.
	public boolean addPlug(char char1, char char2){
		boolean nClash=true;
		try{
			if( (Character.getNumericValue(char1) )==(Character.getNumericValue (char2) ) ) throw new TwoPlugsInSameSocketException();


			if(this.getNumPlugs()<13){
				Plug nPlug=new Plug(char1,char2);
				if(board.isEmpty()){
					board.add(new Plug(char1,char2));

				}
				else{
					for(int i=0;i<this.getNumPlugs();i++){
						if(nPlug.clashesWith(board.get(i))){
							nClash=false;
						}
					}

					if(nClash){
						board.add(new Plug(char1,char2));
					}
				}
			}


		}
		catch ( TwoPlugsInSameSocketException e) {
			e.printStackTrace();
		}
		return(nClash);
	}



	//create method get(char) which test if there is a plug connected to that char using test() method form Plug class. 
	public char get(char x){
		char c=x;
		for(int i=0;i<board.size();i++){
			if(board.get(i).test(x) != x){
				c=board.get(i).test(x);
			}
		}
		return c;
	}
	//create getNumPlugs() method which returns the number of the plugs in the plugboard.
	public int getNumPlugs(){
		return (board.size());
	}

	//clear() method erases all the plugs from plugboard 
	public void clear(){
		board.clear();
	}

}
