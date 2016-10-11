package phonebook;

public class PhonebookEntry {

	private final String name;
	private final String telenumber;
	
	//represents a person in the phonebook. An entry contains a name and 10-digit telephone number. 
	//if the number is not 10 numerical digits, an IllegalArgumentException will be thrown.
	public PhonebookEntry(String name, String telenumber) throws Exception{
		String digits = telenumber.replaceAll( "[^\\d]", "" );
		if(digits.length() != 10){
			throw new IllegalArgumentException("Phone number must be 10 digits long");
		}else if(!name.matches("[a-zA-Z\\s]+")){
			throw new IllegalArgumentException("Name must contain only alphabetic characters");
		}else{
			String dashedNum = digits.substring(0, 3) + "-" + digits.substring(3, 6) + "-" + digits.substring(6);
			this.name = name;
			this.telenumber = dashedNum;//add dashes to make all entries uniform
		}
	}
	
	//returns the person's name of the entry
	public String getName(){
		return name;
	}
	
	//returns the person's telephone number of the entry
	public String getNumber(){
		return telenumber;
	}
	
	//returns the name and number of the entry
	public String toString(){
		return name + " : " + telenumber;
	}
	
	@Override
	public boolean equals(Object other) {
		if(other == this){
			return true;
		}
	    if (!(other instanceof PhonebookEntry)) {
	        return false;
	    }
	    PhonebookEntry that = (PhonebookEntry) other;
	    return this.name.equals(that.name) && this.telenumber.equals(that.telenumber);
	}
	
	@Override
	public int hashCode() {
	    int hashCode = 1;

	    hashCode = hashCode * 37 + this.name.hashCode();
	    hashCode = hashCode * 37 + this.telenumber.hashCode();

	    return hashCode;
	}
	

}
