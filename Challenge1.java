import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

EnigmaMachine e=new EnigmaMachine();
ArrayList<Character> decoded=new ArrayList<Character>();	
for(int i=0;i<26&i!=3;i++){
	for(int j=0;j<26&&j!=18;j++){

		e.addPlug('D',((char)(i+65)));
		e.addPlug('S',((char)(j+65)));
		e.start();

		try {
			FileInputStream fis = new FileInputStream("Input.txt");
			char current;		

			try{
				while (fis.available() > 0) {

					current = (char) fis.read();				
					current=Character.toUpperCase(current);
					//choose only characters A-Z	
					if(Character.getNumericValue(current)<10 || Character.getNumericValue(current)>35)  	throw new NotCharacterException();		
					decoded.add(e.encodeLetter(current));

				}	
			}catch(NotCharacterException e2){
				e2.printStackTrace();
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		for(int l=0;i<decoded.size()-6;i++){
			if(decoded.get(l)=='A'&&decoded.get(l+1)=='N'&&decoded.get(l+2)=='S'&&decoded.get(l+3)=='W'){
				System.out.println("are" + i+" "+j+" ");
			} 

		}
	}

}
