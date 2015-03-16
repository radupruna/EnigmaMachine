

EnigmaMachine e=new EnigmaMachine();
ArrayList<Character> decoded=new ArrayList<Character>();

for(int i=1;i<6;i++){
	for(int j=1;j<=5;j++){
		for(int k=1;k<=5;k++){
			switch(i){
			case 1:
				myBasicRotor0=new BasicRotor("typeI");
				break;

			case 2:
				myBasicRotor0=new BasicRotor("typeII");
				break;

			case 3:
				myBasicRotor0=new BasicRotor("typeIII");
				break;
			case 4:
				myBasicRotor0=new BasicRotor("typeIV");
				break;
			case 5:
				myBasicRotor0=new BasicRotor("typeV");
				break;

			}
			switch(j){
			case 1:
				myBasicRotor1=new BasicRotor("typeI");
				break;
			case 2:
				myBasicRotor1=new BasicRotor("typeII");
				break;

			case 3:
				myBasicRotor1=new BasicRotor("typeIII");
				break;
			case 4:
				myBasicRotor1=new BasicRotor("typeIV");
				break;
			case 5:
				myBasicRotor1=new BasicRotor("typeV");
				break;

			}
			switch(k){
			case 1:
				myBasicRotor2=new BasicRotor("typeI");
				break;
			case 2:
				myBasicRotor2=new BasicRotor("typeII");
				break;

			case 3:
				myBasicRotor2=new BasicRotor("typeIII");
				break;
			case 4:
				myBasicRotor2=new BasicRotor("typeIV");
				break;
			case 5:
				myBasicRotor2=new BasicRotor("typeV");
				break;
			}


			myBasicRotor0.setPosition(22);
			myBasicRotor1.setPosition(24);
			myBasicRotor2.setPosition(23);

			e.start();
			try {
				FileInputStream fis = new FileInputStream("Input.txt");
				char current;		

				while (fis.available() > 0) {

					current = (char) fis.read();				
					current=Character.toUpperCase(current);
					//choose only characters A-Z	
					if(Character.getNumericValue(current)<10 || Character.getNumericValue(current)>35)  	throw new NotCharacterException();		
					decoded.add(e.encodeLetter(current));
				}
			}

			catch (IOException e2) {
				e2.printStackTrace();
			}

			FileOutputStream out;
			PrintStream ps;

			for(int l=0;l<decoded.size()-4;l++){
				if(decoded.get(l)=='J'&&decoded.get(l+1)=='A'&&decoded.get(l+2)=='V'&&decoded.get(l+3)=='A'){
					System.out.println("are  "+i+"  "+j+"  "+k);
				}
			}

		}
	}
}