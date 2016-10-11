package phonebook;
import java.util.*;


public class Phonebook {

	private Map<String, List<PhonebookEntry>> phonebook;
	
	public Phonebook(){
		phonebook = new TreeMap<String,List<PhonebookEntry>>();
	}
	
	//adds a given entry to the phonebook 
	public void add(PhonebookEntry newEntry) {
		List<PhonebookEntry> entryList = phonebook.get(newEntry.getName());
		if(entryList == null){ 
			entryList = new LinkedList<PhonebookEntry>();
			phonebook.put(newEntry.getName(), entryList);
		}
		if(entryList.contains(newEntry)){
			System.out.println("Add failed: this entry is already in the phonebook!");
		}else{
			System.out.println(newEntry + " added to phonebook");
			entryList.add(newEntry);
		}
	}
	
	//deletes the entries in a phonebook matching the given name
	//notifies the user if no matching entry is found
	public void delete(String name){
		if(!phonebook.containsKey(name)){
			System.out.println("Input name does not exist in phonebook");
		}else{
			List<PhonebookEntry> entries = phonebook.get(name);
			PhonebookEntry deletedNum;
			
			if(entries.size() > 1){
				System.out.println("Multiple entries with the same name found. Which entry would you like to delete?");
				int count = 0;
				for(PhonebookEntry e : entries){	
					System.out.println("Press (" + count + ") to delete " + e.toString());
					count++;
				}
				
				Scanner console = new Scanner(System.in);
				int i = console.nextInt();
				if(i < 0 || i >= entries.size()){
					System.out.println("Please input a number within the range");
					return;
				}else{
					deletedNum = entries.get(i);
					entries.remove(i);
				}
				
			}else{
				deletedNum = entries.get(0);
				phonebook.remove(name);
			}
			System.out.println("Deleted "+ deletedNum.toString()+" from phonebook");
		}
	}
	
	//searches for an entry given a name
	public void search(String name){
		if(!phonebook.containsKey(name)){
			System.out.println(name + " does not exist in phonebook");
		}else{
			List<PhonebookEntry> num = phonebook.get(name);
			for(PhonebookEntry e: num){
				System.out.println(e.toString());
			}
		}
	}
	
	//prints all of the entries in the phonebook (name and number)
	public void printAll(){
		if(phonebook.isEmpty()){
			System.out.println("Phonebook is empty");
		}else{
			for (Map.Entry<String,List<PhonebookEntry>> l : phonebook.entrySet()) {
				List<PhonebookEntry> nums = l.getValue();				
				for(PhonebookEntry e: nums){
					System.out.println(l.getKey() + " : " + e.getNumber());
				}
			}
		}
	}
	
}
