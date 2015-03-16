for(int i=0;i<25;i++){
	for(int j=0;j<25;i++){
		for(int k=0; k<25;k++){
			this.addPlug('H','L');
			this.addPlug('G','P');
			ArrayList<Character> decoded=new ArrayList<Character>();	
			myBasicRotor0=new BasicRotor("typeV");
			myBasicRotor1=new BasicRotor("typeIII");
			myBasicRotor2=new BasicRotor("typeII");
			myReflector=new Reflector();
			myReflector.initialise("ReflectorI");

			myBasicRotor0.setPosition(i);
			myBasicRotor1.setPosition(j);
			myBasicRotor2.setPosition(k);
			try {
				FileInputStream fis = new FileInputStream("Input.txt");
				char current;		

				try{
					while (fis.available() > 0) {

						current = (char) fis.read();				
						current=Character.toUpperCase(current);
						//choose only characters A-Z	
						if(Character.getNumericValue(current)<10 || Character.getNumericValue(current)>35)  	throw new NotCharacterException();		
						decoded.add(this.encodeLetter(current));

					}	
				}catch(NotCharacterException e2){
					e2.printStackTrace();
				}

			} catch (IOException e1) {
				e1.printStackTrace();
			}
			for(int l=0;i<decoded.size()-7;i++){
				if(decoded.get(l)=='E'&&decoded.get(l+1)=='L'&&decoded.get(l+2)=='E'&&decoded.get(l+3)=='C'&&decoded.get(l+4)=='T'
						&&decoded.get(l+5)=='R'&&decoded.get(l+6)=='I'){
					System.out.println("sunt" + i+" "+j+" " +k);
				} 

			}

		}
	}
}