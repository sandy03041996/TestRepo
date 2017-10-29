import java.util.*;
public class MonoAlpha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Character> Plain= new ArrayList<Character>(Arrays.asList('A','B','C','D','E','F','G','H','I','J','K','L','N','M','O','P','Q','R','S','T','U','V','W','X','Y','Z'));
		
		ArrayList<Integer> num = new ArrayList<Integer>();
		for (int i=0; i<26; i++){
			num.add(i);
		}
		Collections.shuffle(num);
		
		ArrayList<Character> Cipher= new ArrayList<Character>();
		for (int j=0; j< num.size(); j++){
			//System.out.println((char)(65+num.get(j)));
			Cipher.add((char)(65+num.get(j)));
		}
		Scanner scnr = new Scanner(System.in);
		String text="",encryp="";
		System.out.print("Enter Phrase(Uppercase): ");
		text = scnr.nextLine().toUpperCase();
		
		/****************************ENCRYPTION*************************************/
		for (int x=0; x< text.length(); x++){
			
			if (Plain.contains(text.charAt(x))){
				encryp = encryp + Cipher.get(Plain.indexOf(text.charAt(x)));
			}
			else{
				encryp = encryp + text.charAt(x);
			}
		}
		text="";
		System.out.println("Encrypted Text: "+encryp);
		/****************************DE-ENCRYPTION*************************************/
		for (int z =0; z< encryp.length(); z++){
			if (Cipher.contains(encryp.charAt(z))){
				//System.out.println("Present");
				text = text + Plain.get(Cipher.indexOf(encryp.charAt(z)));
			}
			else{
				text = text + encryp.charAt(z);
			}
		}
		System.out.println("DE-Encryption: "+ text);
		//ArrayList<Character> Cipher= new ArrayList<Character>(Arrays.asList('A','B','C','D','E','F','G','H','I','J','K','L','N','M','O','P','Q','R','S','T','U','V','W','X','Y','Z'));
		
	}

}
