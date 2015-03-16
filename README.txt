Enigma Machine

Enigma Machine has the following classed:

Plug, Plugboard, Rotor, Reflector, BasicRotor, TurnoverRotor, EnigmaFile, EnigmaMachine, Challenge1, Challenge2, Challenge3.

Each class has all the specified methods and they work properly.

In Plugboard class I added a new method get(char) which test if there is a plug connected to that char using test() method form Plug class.

EnigmaFile class  the program reads the encrypted text from a file “Input.txt” and print the text after decryption in another file “Dec.txt”.

I’ve created 3 new exceptions:
1.	NotCharacterException which returns an exception if the encrypted text contains other characters that letters A-Z.
2.	SameTypeOfRotorException which returns an exception if the use try to put the same type in two different Rotors.
3.	TwoPlugsInSameSocket   which returns an exception if the use try to put the same letter into a Plug.

All the tests worked properly:
Test1: BADGER
Test2: SNAKE
Message from the Dean: CONGRATULATIONSONBUILDINGYOURENIGMAMACHINEANDFOLLOWINGINTHEFOOTSTEPSOFTHOSEPIONEERINGMENANDWOMENATBLETCHLEYPARKWHOHELPEDCREATETHEFIRSTELECTRONICPROGRAMMABLECOMPUTERIWISHYOUALLTHEBESTFORYOURCONTINUINGSTUDIESPROFESSORDAMEWENDYHALL

How it works. EXAMPLE(based on test1)

Do you want to write the text you want to encript or read it from the txt file?
Press 1 for writing and 2 for reading from a file.
1
Enter your encripted text in A-Z uppercase characters only and without spaces
GFWIQH
How many Plugs do you want?
3
Type the(uppercase) letter in the first socket of the plug number 1
A
Type the(uppercase) letter in the second socket of the plug number 1
M
Type the(uppercase) letter in the first socket of the plug number 2
G
Type the(uppercase) letter in the second socket of the plug number 2
L
Type the(uppercase) letter in the first socket of the plug number 3
E
Type the(uppercase) letter in the second socket of the plug number 3
T
Select the types of the rotors.
Remember that the Rotors must have different types

Please select the type of the first rotor.

For typeI press 1. For typeII press 2. For typeIII press 3. For type IV press 4. For typeV press 5
1

Please insert the position of the first Rotor
6

Please select the type of the second rotor.

For typeI press 1. For typeII press 2. For typeIII press 3. For type IV press 4. For typeV press 5
2

Please insert the position of the second Rotor
12

Please select the type of the third rotor.

For typeI press 1. For typeII press 2. For typeIII press 3. For type IV press 4. For typeV press 5
3

Please insert the position of the third Rotor
5

Please initialise the Reflector.

For ReflectorI press 1. For ReflectorII press 2
1
BADGER


Extensions:
I’ve created the interface between user and machine. 

At the beginning of the encryption the user can choose between reading the encrypted text from “Input.txt” or write the text in the command line.

After that, he has to follow the guidance and add the plugs, type of the rotors and their initial position and also the type of the reflector.

The decrypted text will be output on the command line or in the file “Dec.txt”.


Challenge 1

First of all we observe that in the encoded message (JBZAQVEBRPEVPUOBXFLCPJQSYFJI) the character S appears only once (as the 24th character) and character D doesn’t appear at all. 
So, the only character that can change his value before the first Rotor is the 24th one. 
So, there won’t be major changes if we let the Plugboard empty.
After we set the Rotors and the Reflector  with the specified types, the output of the programme will be the following:

TSISYTSIAYGIVEMEYOURSNAGERTO

We observe that there is no “D” character in the output message. 
Moreover, the output message is supposed to contain the word “ANSWER” which again has no character “D”. 
Thus, any plug with one of the socket as “D” is kind of useless. 

But the output has lots of “S” characters which we can change by making a plug containing “S” as one of the sockets.  
The word  ”Answer” contain the letter “S”. So,  if we put a plug containing “S” it will be changed to another character just before the final output. 
Searching  through the output message for some pattern, or parts of the word “ANSWER”, we can see that there is only one group of characters that contains some of the letters we want.
Those are “ER”. Don’t forget that if we put any plug containing the letter “S” then the 24th letter will change.

Look close at the group “SNAGER”. We already have the final 2 letter “ER” and the second letter “N”. Also, “G” will change before the first Rotor. 
The first letter is “S” and the 3rd one “A”. So, we think that if we swap them, then we might obtain something very nice. 
Something like “ANSGER” where “G” will be changed during the encryption.

Therefore, we think about trying to encode the text again, but now with a new Plug: S-A.
After setting the Enigma Machine, the output text will be: 

TAISYTAISYGIVEMEYOURANSWERTO  

Now, we can see more than one appeareance of letter “T”. Plugging “T” with “D” we obtain:

DAISYDAISYGIVEMEYOURANSWERDO

In other words, we can put 2 for loops, each from 0 to 25(there are 26 letters) and try to add two plugs for each combination after transform the integer into char(one contain D and one S). 
So, there are 26*26=676 different combination. But we have to be careful not to put a plug with the same 2 sockets. So, no plugs D-D, S-S, D-S,S-D.
After we save the decrypted message into an array of Characters, with another for loop we go through the array and check of letters A,N,S,W,E,R.
When the program finds it, it will output the integer corresponding to that letter. So, the output will be 21 and 0, corresponding T and A.

Set the enigma machine and run the program. The output will be DAISYDAISYGIVEMEYOURANSWERDO.
The code is available in Challenge1 class and must be copied to the main method from EnigmaMachine class. Also update the method super().


Challenge 2

Challenge2 is similar to challenge3. All you have to do is to put 3 for loops from 0 to 25 (for each rotor position) and make the decryption every time.
 When you find the word “ELECTRIC” in the text, then output the positions that were used.





Challenge3

For the third challenge we don’t know the types of the three Rotors. But, we all know that each rotor’s type is out of 5 possibilities.
So, there are maximum 5*5*5=125 possibilities.

That’s why,  in the main method, all we have to do is to put 3 for loops, each from 1 to 5 and in each case to initiate the Rotors with that type. 
After that, for every possibility of encryption we save the message into an array of characters.

When the message is encrypted and saved in the Array, all we have to do is to put another for loop that go through the Characters of the array and compare it with what we want(i.e. JAVA).
When the program finds 4 consecutive Characters that form the word JAVA, it outputs the types of the rotors that was used. 

So, it will output several triplets of types. After removing the ones that contain at least 2 identical types we end up with one possibility that works. 
That is: 5 3 2.

Thus, the type of the first rotor is 5, the type of the second is 3 and the type of the third is 2.
After we put those types in the EnigmaMachine, the output will be: 

ILOVECOFFEEILOVETEAILOVETHEJAVAJIVEANDITLOVESME

Note: the code of this is in class Challenge3. If you want to verify it, just copy it in the main method from EmigmaMachine class after commenting the existent code in there. 
Also don’t forget to adapt the method start() from the same class.   

