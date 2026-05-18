import java.util.ArrayList;

public class StringEditor{
	
	private ArrayList<String> theString; // each element in the String is a one-character string

	public StringEditor(String inputString){
		theString = new ArrayList<String>();
        for (int i = 0; i < inputString.length(); i++){
			String letter = inputString.substring(i,i+1);
			theString.add(letter);
		}
	}

	public void removeLetters(String target){
		for (int i = 0; i < target.length(); i++){
            String letter = target.substring(i, i + 1);
            for (int j = theString.size() - 1; j >= 0; j--){
                if (theString.get(j).equals(letter)){
                    theString.remove(j);
                }
            }
        }
	}
				
	public String toString(){
		String returnString = "";
		for (String s : theString){
			returnString += s;
		}
		return returnString;
	}

}
