public class UtilsText {
  
  
  
   /**
	 * Given a sentence which has dots but all characters are 
	 * lower case, return a sentence that has all characters 
	 * after a dot upper case
	 * 
	 * Example:
	 * Given a sentence "something. that should start with up"
	 * returns a sentence: "Something. That should start with up"
	 * 
	 * @param mainText
	 * @return
	 */
	public static String restoreUpperCase(String sampleText)
	{
		String finalText = "";  
		String charRef = "<dotref31415>";
		String charSplitter = "<dostsplitter31415>";
		String wordRep = charRef + charSplitter;
		
		sampleText = Utils.clearSideSpaces(sampleText);
		sampleText = sampleText.replace(".", wordRep); 
 
		String[] splitted = sampleText.split(charSplitter); 
		
		if (splitted.length==1 )
		{
			finalText = splitted[0];
			String firstChar = String.valueOf(finalText.charAt(0));
			finalText = firstChar.toUpperCase() + finalText.substring(1,finalText.length()); 
		}
		else
		{
			for (int i=0; i<splitted.length; i++)
			{ 
				String word = splitted[i]; 
				
				//Check if first character is " "
				String firstChars = word.substring(0,1);
				while (String.valueOf(firstChars.charAt(firstChars.length()-1)).equals(" ") && word.length()>firstChars.length())
				{
					firstChars = word.substring(0,firstChars.length()+1);
				} 
				firstChars = firstChars.toUpperCase();
				
				
				String restChars = word.substring(firstChars.length(),word.length());
				String finalWord = firstChars + restChars; 
				 
				finalText = finalText + finalWord;
			}
		}
		  
		finalText = finalText.replaceAll(charRef, "."); 
		
		return finalText;
	}
  
  
  /**
	 * Given a String that has space at the beginning or/and end
	 * return a String without space at the beginning or/and end
	 * 
	 * @param text The input String
	 * @return The cleared String
	 */
  public static String clearSideSpaces(String text)
	{
		if (text.length()>2)
		{
			if (String.valueOf(text.charAt(0)).equals(" ")) {
				text = text.substring(1,text.length());
			}
			if (String.valueOf(text.charAt(text.length()-1)).equals(" ")) {
				text = text.substring(0,text.length()-1);
			}
		} 
		
		return text;
	}
  
  
  
}
