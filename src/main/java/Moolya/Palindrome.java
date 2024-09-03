package Moolya;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String original= "interview";
		String reversedString ="";
		
		
		int len = original.length();
		
		for (int i = len-1; i >=0; i--) {
			reversedString+= original.charAt(i);
		}
		
		
		if (original.equals(reversedString)) {
			System.out.println(reversedString +" is a palindrome");
		}
		else {
			System.out.println(reversedString +" is not a palindrome");
		}
	}

}
